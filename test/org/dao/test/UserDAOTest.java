package org.dao.test;

import java.util.List;

import org.bq.dao.UserDAO;
import org.bq.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDAOTest {

	@Test
	public void queryByNames() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO userDAO=(UserDAO) ctx.getBean("userDAO");
		List<User> list=userDAO.queryByName("baiqiang", "123456");
		for(User u:list){
			System.out.println(u);
		}
	}
	@Test
	public void addUser() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO userDAO=(UserDAO) ctx.getBean("userDAO");
		User user=new User("bq","1234567890",10,"惊悚","10570795@aa.com");
		userDAO.addUser(user);
	}
}
