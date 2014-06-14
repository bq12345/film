/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.dao.test;

import java.util.List;

import org.bq.dao.AdminDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 白强
 * @version 1.0
 */
public class AdminDAOTest {

	@Test
	public void queryByNames() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AdminDAO dao = (AdminDAO) ctx.getBean("adminDAO");
		List<String> list = dao.queryByName("admin", "admin");
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
		}
	}
}
