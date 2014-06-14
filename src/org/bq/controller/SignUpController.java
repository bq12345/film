/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class SignUpController {
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(value = "/signUp.do", produces = { "html/text;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String name = req.getParameter("name");
		name = new String(req.getParameter("name").getBytes("ISO-8859-1"),
				"utf-8");
		System.out.println("signUp--------" + name);
		if (userDAO.existName(name)) {
			return "fail";
		} else {
			return "success";
		}
	}
}
