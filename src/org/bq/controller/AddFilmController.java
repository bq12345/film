package org.bq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.FilmDAO;
import org.bq.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 白强
 * @version 1.0
 */
@Controller
public class AddFilmController {
	@Autowired
	private FilmDAO filmDAO;

	public FilmDAO getFilmDAO() {
		return filmDAO;
	}

	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}

	@RequestMapping(value = "/addFilm.do", produces = { "html/text;charset=UTF-8" })
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		String url = req.getParameter("url");
		String director = req.getParameter("director");
		String watch = req.getParameter("watch");
		String date = req.getParameter("date");
		Film f = new Film(name, url, desc, director, date,watch);
		System.out.println("Request_____" + f);
		filmDAO.
		return "success";
	}
}
