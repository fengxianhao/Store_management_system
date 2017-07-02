
package fxh.com.hkj.view;

import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Trade_F1 extends javax.swing.JFrame {

	private JLabel totaLabel,payeeLable,boundary,shoudJLabel;
	public Trade_F1(Home_F1 home_F1, double money, double total) {
		this.setTitle("完成交易");
		this.getLayeredPane().setLayout(null);
		this.setBounds(800,400,300, 260);
		totaLabel=new JLabel("合计："+total);
		payeeLable=new JLabel("实收："+money);
		boundary=new JLabel("————————————————");
		shoudJLabel=new JLabel("应找:"+(money-total));
		totaLabel.setBounds(30, 20, 120, 30);
		payeeLable.setBounds(30, 80, 120, 30);
		boundary.setBounds(30, 110, 300, 30);
		shoudJLabel.setBounds(30, 140, 120, 30);
		this.getLayeredPane().add(totaLabel);
		this.getLayeredPane().add(payeeLable);
		this.getLayeredPane().add(boundary);
		this.getLayeredPane().add(shoudJLabel);
		this.setVisible(true);
	}
}

