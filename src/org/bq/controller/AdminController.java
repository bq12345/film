package org.bq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bq.dao.AdminDAO;
import org.bq.dao.WaitDAO;
import org.bq.model.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class AdminController {
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private WaitDAO waitDAO;

	public WaitDAO getWaitDAO() {
		return waitDAO;
	}

	public void setWaitDAO(WaitDAO waitDAO) {
		this.waitDAO = waitDAO;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@RequestMapping(value = "/adminLogin.do", produces = { "text/html;charset=UTF-8" })
	public String execute(HttpServletRequest req) throws Exception {
		String name = "";
		String password = "";
		name = req.getParameter("username");
		password = req.getParameter("password");
		List<String> list = adminDAO.queryByName(name, password);
		if (list.size() > 0) {
			String s = list.get(0);
			List<Wait> waits = waitDAO.query(1);
			req.getSession().setAttribute("waits", waits);
			req.getSession().setAttribute("admin", s);
		}
		return "manage";
	}
}
