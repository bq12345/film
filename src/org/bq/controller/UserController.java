package org.bq.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.UserDAO;
import org.bq.model.User;
import org.film.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(value = "/user.do", produces = { "html/text;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String name = "";
		String password = "";
		try {
			name = new String(req.getParameter("name").getBytes("ISO-8859-1"),
					"utf-8");
			password = new String(req.getParameter("password").getBytes(
					"ISO-8859-1"), "utf-8");
			byte[] en_result = new BigInteger(password, 16).toByteArray();
			byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair()
					.getPrivate(), en_result);
			StringBuilder sb = new StringBuilder(new String(de_result));
			password = sb.reverse().toString();
		} catch (Exception e) {
			return "服务器内部错误 请重新登录";
		}
		System.out.println("user: " + name + "----" + password);
		System.out.println("success");
		if (userDAO.queryByName(name, password).size() > 0) {
			User u = userDAO.queryByName(name, password).get(0);
			System.out.println("验证成功");
			req.getSession().setAttribute("user", u);
		//	res.sendRedirect("/user.jsp");
			return "user";
		} else {
			System.out.println("验证失败");
			return "signup";
	}
}}
