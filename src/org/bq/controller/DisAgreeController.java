/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.WaitDAO;
import org.bq.model.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class DisAgreeController {
	@Autowired
	private WaitDAO waitDAO;
	public WaitDAO getWaitDAO() {
		return waitDAO;
	}

	public void setWaitDAO(WaitDAO waitDAO) {
		this.waitDAO = waitDAO;
	}

	@RequestMapping(value = "/disagree.do", produces = { "html/text;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		Wait wait = waitDAO.getWait(id);
		wait.setFlag(-1);
		waitDAO.disagreeWait(wait);
		return "disagree";
	}
}
