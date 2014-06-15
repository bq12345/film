/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package net.bq.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import net.bq.Film;
import net.bq.FilmService;
import net.bq.FilmServiceService;

/**
 * @author 白强
 * @version 1.0
 */
public class UpdateClient extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JButton search;
	private JLabel copyRight;
	private Vector<Vector<String>> data;
	private final JTable table;

	public UpdateClient() {
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		name = new JTextField(100);
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
		Vector<String> header = new Vector<String>();
		header.add("名称");
		header.add("描述");
		header.add("导演");
		header.add("豆瓣地址");
		header.add("观看地址");
		header.add("上映日期");
		header.add("别名");
		header.add("片长");
		data = new Vector<Vector<String>>();
		table = new JTable(data, header) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getTableHeader().setPreferredSize(new Dimension(0, 30));
		// 设置表内容行高
		table.setRowHeight(25);
		// 设置单选模式
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		// 设置单元格不可拖动
		table.getTableHeader().setReorderingAllowed(false);
		// 设置不可改变列宽
		table.getTableHeader().setResizingAllowed(false);
		// 设置列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(505);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(30);
		table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {// 点击几次，这里是双击事件
					tableChanged();
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		p2.add(scrollPane);
		copyRight = new JLabel("电影搜索.2014 All Rights Reserved.");
		JPanel p3 = new JPanel();
		p3.add(copyRight);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		this.setLocation(50, 20);
		this.setSize(1300, 700);
		this.setTitle("电影搜索");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void tableChanged() {
		int row = table.getSelectedRow();
		String url = table.getValueAt(row, 3).toString(); // 得到所在行的第一个列的值，作为下面事件传递的参数
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	class TableCellTextAreaRenderer extends JTextArea implements
			TableCellRenderer {
		private static final long serialVersionUID = 1L;

		public TableCellTextAreaRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (table.getRowHeight(row) != 100) // 少了这行则处理器瞎忙
				table.setRowHeight(row, 100);
			setText(value == null ? "" : value.toString());
			return this;
		}
	}

	public static void main(String[] args) {
		new UpdateClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("搜索")) {
			search();
		}
	}

	private void search() {
		FilmServiceService service = new FilmServiceService();
		FilmService handler = service.getFilmServicePort();
		List<Film> films = handler.search(name.getText());
		for (Film f : films) {
			Vector<String> row = new Vector<String>();
			row.add(f.getName());
			row.add(f.getDescription());
			row.add(f.getDirector());
			row.add(f.getFilmUrl());
			row.add(f.getViewLink());
			row.add(f.getShowtime());
			row.add(f.getNickname());
			row.add(f.getRuntime());
			data.add(row);
			table.updateUI();
		}

	}

}
