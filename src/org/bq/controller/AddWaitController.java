package org.bq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.WaitDAO;
import org.bq.model.User;
import org.bq.model.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class AddWaitController {
	@Autowired
	private WaitDAO waitDAO;

	public WaitDAO getWaitDAO() {
		return waitDAO;
	}

	public void setWaitDAO(WaitDAO waitDAO) {
		this.waitDAO = waitDAO;
	}

	@RequestMapping(value = "/addWait.do", produces = { "html/text;charset=UTF-8" })
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		String url = req.getParameter("url");
		String director = req.getParameter("director");
		String watch = req.getParameter("watch");
		String date = req.getParameter("date");
		Wait w = new Wait(name, url, desc, director, date, watch);
		System.out.println("Request_____" + w);
		User u = (User) req.getSession().getAttribute("user");
		waitDAO.addWait(w, u.getId());
		List<Wait> list = waitDAO.query(1, u.getId());
		req.getSession().setAttribute("waits", list);
		return "user";
	}
}
