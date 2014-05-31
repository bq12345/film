/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package net.bq;

import java.util.List;
import java.util.Scanner;

/**
 * @author 白强
 * @version 1.0
 */
public class Client {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		FilmServiceService service = new FilmServiceService();
		FilmService handler = service.getFilmServicePort();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要搜索的电影名称:");
		String name = scanner.next();
		List<Film> list = handler.search(name);
		for (Film f : list) {
			System.out.println(f);
		}
		scanner.close();
	}

}
