
package fxh.com.hkj.view;

import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Trade_F1 extends javax.swing.JFrame {

	private JLabel totaLabel,payeeLable,boundary,shoudJLabel;
	public Trade_F1(Home_F1 home_F1, double money, double total) {
		this.setTitle("��ɽ���");
		this.getLayeredPane().setLayout(null);
		this.setBounds(800,400,300, 260);
		totaLabel=new JLabel("�ϼƣ�"+total);
		payeeLable=new JLabel("ʵ�գ�"+money);
		boundary=new JLabel("��������������������������������");
		shoudJLabel=new JLabel("Ӧ��:"+(money-total));
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

