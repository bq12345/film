/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.bq.dao.FilmDAO;
import org.bq.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author °×Ç¿
 * @version 1.0
 */
@Controller
public class FilmController {
	@Autowired
	private FilmDAO dao;

	public FilmDAO getDao() {
		return dao;
	}

	public void setDao(FilmDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/search.do", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req) {
		String name = "";
		try {
			name = new String(req.getParameter("name").getBytes("ISO-8859-1"),
					"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("²ÎÊý--------" + name);
		List<Film> list = dao.queryByName(name);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object source, String name, Object value) {
				return value == null;
			}
		});
		JSONArray array = JSONArray.fromObject(list, jsonConfig);
		System.out.println("success");
		return array.toString();
	}
}
