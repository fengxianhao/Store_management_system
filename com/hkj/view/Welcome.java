		
package com.hkj.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 *
 * @author  __USER__
 */
public class Welcome extends JFrame {
	/** Creates new form Welcome */
	public void wel() {
		initComponents();

		ResultSet rstResultSet = null;
		boolean a = true;
		this.setTitle("��ӭ����");
		this.setBounds(750, 380, 370, 320);
		JLabel aIconLabel = new JLabel();
		this.setFont(new Font("����", Font.BOLD, 50));


		ImageIcon image = new ImageIcon("Photo//OK.gif");
		// �ѱ���ͼƬ��ʾ��һ����ǩ����
		JLabel label = new JLabel(image);
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0,  370, 320);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.getContentPane().add(aIconLabel);
		this.setResizable(true);
		this.setVisible(true);
	}


	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 949,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 477,
						Short.MAX_VALUE));

		pack();
	}

	public static void main(String args[]) {

		Welcome welcome = new Welcome();
		welcome.wel();

		try {
			Thread.sleep(1700);
			welcome.setVisible(false);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "����ϵͳʧ�ܣ����˳����ԣ�");
		}

		Login log = new Login();
		log.log();
		log.img();



	}

	private javax.swing.JLabel jLabel1;
}


