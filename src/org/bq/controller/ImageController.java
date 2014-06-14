/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class ImageController {

	@RequestMapping(value = "/getImage.do", produces = { "html/text;charset=UTF-8" })
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String image = req.getParameter("image");
		if (image.equals("undefined")) {
			image = "http://placehold.it/300x400&text=No%20Photo";
		}
		URL url = new URL(image);
		URLConnection urlConnection = url.openConnection();
		InputStream inputStream = urlConnection.getInputStream();
		OutputStream stream = res.getOutputStream();
		res.setContentType("image/jpg");
		int c;
		while ((c = inputStream.read()) != -1) {
			stream.write(c);
		}
		stream.flush();
		stream.close();
	}
}
