/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author 白强
 * @version 1.0
 */
public class SwingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("BorderLayout");
		JButton btn = new JButton("BorderLayout.NORTH");
		f.add(btn, BorderLayout.NORTH);
		btn = new JButton("BorderLayout.SOUTH");
		f.add(btn, BorderLayout.SOUTH);
		btn = new JButton("BorderLayout.EAST");
		f.add(btn, BorderLayout.EAST);
		btn = new JButton("BorderLayout.West");
		f.add(btn, BorderLayout.WEST);
		btn = new JButton("BorderLayout.CENTER");
		f.add(btn, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
