package org.dao.test;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.bq.dao.FilmDAO;
import org.bq.model.Film;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FilmDAOTest {
	@Test
	public void queryFilms() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		FilmDAO dao = FilmDAO.getFromApplicationContext(ctx);
		List<Film> list = dao.queryByName("钢铁");
		/*
		 * for(Film f: list){ System.out.println(f); }
		 */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object source, String name, Object value) {
				return value == null;
			}
		});
		JSONArray array = JSONArray.fromObject(list, jsonConfig);
		System.out.println(array);
	}
}
