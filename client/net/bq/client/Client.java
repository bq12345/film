/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package net.bq.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.bq.Film;
import net.bq.FilmService;
import net.bq.FilmServiceService;

/**
 * @author 白强
 * @version 1.0
 */
public class Client extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JButton search;
	private JList<Film> list;
	private JLabel copyRight;
	private DefaultListModel<Film> defaultListModel;

	public Client() {
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		name = new JTextField(50);
		search = new JButton("搜索");
		name.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				if (i == KeyEvent.VK_ENTER) {
					search();
				}
			}
		});
		search.addActionListener(this);
		p1.add(name, BorderLayout.WEST);
		p1.add(search, BorderLayout.EAST);
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		list = new JList<Film>();
		defaultListModel = new DefaultListModel<Film>();
		p2.add(list);
		copyRight = new JLabel("电影搜索.2014 All Right Reserved.");
		JPanel p3 = new JPanel();
		p3.add(copyRight);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		this.setLocation(200, 100);
		this.setSize(600, 500);
		this.setTitle("电影搜索");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		list.setModel(defaultListModel);
	}

	public static void main(String[] args) {
		new Client();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("搜索")) {
			search();
		}
	}

	private void search() {
		defaultListModel.removeAllElements();
		FilmServiceService service = new FilmServiceService();
		FilmService handler = service.getFilmServicePort();
		List<Film> films = handler.search(name.getText());
		for (Film f : films) {
			defaultListModel.addElement(f);
		}

	}

}
