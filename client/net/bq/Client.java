/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package net.bq;

import java.util.List;
import java.util.Scanner;

/**
 * @author ��ǿ
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
		System.out.println("������Ҫ�����ĵ�Ӱ����:");
		String name = scanner.next();
		List<Film> list = handler.search(name);
		for (Film f : list) {
			System.out.println(f);
		}
		scanner.close();
	}

}
