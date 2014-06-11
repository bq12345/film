package org.bq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.UserDAO;
import org.bq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class UpdateUserController {
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(value = "/updateUser.do", produces = { "html/text;charset=UTF-8" })
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String love = req.getParameter("love");
		User u = userDAO.getUser(id);
		u.setUsername(name);
		u.setAge(age);
		u.setEmail(email);
		u.setLove(love);
		u.setPassword(password);
		System.out.println("Request_____" + u.toString());
		userDAO.updateUser(u);
		req.getSession().setAttribute("user", u);
		return "user";
	}
}
