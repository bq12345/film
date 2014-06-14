/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import java.security.interfaces.RSAPublicKey;

import javax.servlet.http.HttpServletRequest;

import org.film.util.RSAUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class RSAController {
	

	@RequestMapping(value = "/key.do", produces = { "html/text;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req) throws Exception {
		RSAPublicKey rsap = (RSAPublicKey) RSAUtil.generateKeyPair()
				.getPublic();
		String module = rsap.getModulus().toString(16);
		System.out.println("module");
		System.out.println(module);
		System.out.println("success");
		return module;
	}
}
