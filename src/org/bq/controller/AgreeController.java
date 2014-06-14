/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.dao.FilmDAO;
import org.bq.dao.WaitDAO;
import org.bq.model.Film;
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
public class AgreeController {
	@Autowired
	private WaitDAO waitDAO;
	@Autowired
	private FilmDAO dao;

	public FilmDAO getDao() {
		return dao;
	}

	public void setDao(FilmDAO dao) {
		this.dao = dao;
	}

	public WaitDAO getWaitDAO() {
		return waitDAO;
	}

	public void setWaitDAO(WaitDAO waitDAO) {
		this.waitDAO = waitDAO;
	}

	@RequestMapping(value = "/agree.do", produces = { "html/text;charset=UTF-8" })
	public @ResponseBody
	String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		Wait wait = waitDAO.getWait(id);
		waitDAO.deleteWait(id);
		Film film = new Film();
		film.setDescription(wait.getDescription());
		film.setDirector(wait.getDirector());
		film.setName(wait.getName());
		film.setFilmUrl(wait.getUrl());
		film.setView_link(wait.getWatch());
		film.setShowtime(wait.getDate());
		dao.addFilm(film);
		return "agree";
	}
}
