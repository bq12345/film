package org.bq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class LogoutController {

	@RequestMapping(value = "/logout.do", produces = { "text/html;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req) throws Exception {

		if (req.getSession().getAttribute("user") != null) {
			req.getSession().removeAttribute("user");
		}
		return "success";
	}
}
