/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.bq.dao.FilmDAO;
import org.bq.model.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 白强
 * @version 1.0
 */
@WebService
public class FilmService {

	@WebMethod
	public List<Film> search(String name) {
		System.out.println("query"+name);
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		FilmDAO dao = FilmDAO.getFromApplicationContext(ctx);
		return dao.queryByName(name);
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/film", new FilmService());
		System.out.println("The search server running....");
	}
}
