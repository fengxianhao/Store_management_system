

package com.hkj.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

import com.hkj.db.DbConnection;

import fxh.com.hkj.view.Home_F;
import fxh.com.hkj.view.Home_F1;



public class Login extends JFrame {

	private JPanel imagePanel;

	 private ImageIcon background;
	 
	  JFrame frame = new JFrame("登录");

    /** Creates new form login */
    public void log() {
    	
    	frame.setBounds(300, 100, 1366, 768);
    	frame.setUndecorated(true);
    	

		final JTextField jTextField=new JTextField();
		//向文本框中添加字段
		jTextField.setFont(new Font("微软雅黑",1,20));//其中""中的代表字体，1代表粗体，22代表字体大小
		jTextField.setBounds(570, 275, 260, 44);//设置位置，前面两个代表横纵坐标，后面两个代表宽高
		frame.add(jTextField);

		final JPasswordField jPasswordField=new JPasswordField();
		jPasswordField.setFont(new Font("微软雅黑",1,40));//其中""中的代表字体，1代表粗体，22代表字体大小
		jPasswordField.setBounds(570, 328, 260, 44);//设置位置，前面两个代表横纵坐标，后面两个代表宽高
		frame.add(jPasswordField);

		JButton jButton1=new JButton("点我登录>>>");
		jButton1.setFont(new Font("微软雅黑",1,20));//其中""中的代表字体，1代表粗体，20代表字体大小
		jButton1.setBounds(518, 381, 310, 45);//设置位置，前面两个代表横纵坐标，后面两个代表宽高
		frame.add(jButton1);
		
		Icon icon=new ImageIcon("Photo//退出1.png");
		JButton jButton2=new JButton(icon);
		jButton2.setFont(new Font("微软雅黑",1,22));//其中""中的代表字体，1代表粗体，20代表字体大小
		jButton2.setBounds(1310, 11, 45, 40);//设置位置，前面两个代表横纵坐标，后面两个代表宽高
		frame.add(jButton2);

		Icon icon1=new ImageIcon("Photo//换肤1.png");
		JButton jButton3=new JButton(icon1);
		jButton3.setFont(new Font("微软雅黑",0,10));//其中""中的代表字体，1代表粗体，20代表字体大小
		jButton3.setBounds(1260, 11, 45, 40);//设置位置，前面两个代表横纵坐标，后面两个代表宽高
		frame.add(jButton3);

		JLabel jLabel5=new JLabel();
		jLabel5.setIcon(new ImageIcon("Photo//进度条2.gif"));
		jLabel5.setBounds(500, 428, 220, 19);
		frame.add(jLabel5);

		JLabel jLabel6=new JLabel();
		jLabel6.setIcon(new ImageIcon("Photo//进度条2.gif"));
		jLabel6.setBounds(604, 428, 220, 19);
		frame.add(jLabel6);

		JLabel jLabel7=new JLabel();
		jLabel7.setIcon(new ImageIcon("Photo//进度条2.gif"));
		jLabel7.setBounds(708, 428, 220, 19);
		frame.add(jLabel7);

		JLabel jLabel8=new JLabel();
		jLabel8.setIcon(new ImageIcon("Photo//进度条2.gif"));
		jLabel8.setBounds(740, 428, 220, 19);
		frame.add(jLabel8);

		JLabel jLabel3=new JLabel();
		jLabel3.setIcon(new ImageIcon("Photo//登录界面1.png"));
		jLabel3.setBounds(500, 100, 500, 500);
		frame.add(jLabel3);

		jButton1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    			String number=jTextField.getText();
    			String pwd=new String(jPasswordField.getPassword());
    			String sql="";
    			String sql1="";
    			if(number.equals("")){
    				
    				JOptionPane.showMessageDialog(
    						Login.this, "账号不能为空！","提示",JOptionPane.INFORMATION_MESSAGE);
    				jPasswordField.setText("");				
    				return;
    			}
    			if(pwd.equals("")){    				
    				JOptionPane.showMessageDialog(
    						Login.this, "密码不能为空！","提示",JOptionPane.INFORMATION_MESSAGE);
    				jTextField.setText("");
    				return; 				
    			}
    			  sql="select * from employee where Number='"+"admin"+"' and Pwd='"+"123456"+"'";
    			  sql1="select * from employee where Number='"+"cashier"+"' and Pwd='"+"123456"+"'";
    			  
    			Connection conn;
    			try {
    				conn = DbConnection.getConnection();
    				java.sql.PreparedStatement ps=conn.prepareStatement(sql);
    				//当账号为admin时进入的界面
    				
    				if (jTextField.getText().equals("admin")) {
    					if(ps.executeQuery().next()){
        					
   					 	 frame.setVisible(false);

       					 final JFrame jFrame=new JFrame();
       					
       					jFrame.setBounds(750, 350, 442, 303);
       					jFrame.setUndecorated(true);
       					
       					JLabel jLabel1=new JLabel();
       					jLabel1.setIcon(new ImageIcon("Photo//登录成功.png"));
       					jLabel1.setBounds(750, 350, 400, 300);
       					jFrame.add(jLabel1);
       					jFrame.setVisible(true);
       					
   						
       					jFrame.addWindowListener(new WindowListener() {
								
								@Override
								public void windowOpened(WindowEvent e) {
									
									try {
										Thread.sleep(3000);//出现时间3000毫秒，3秒
										jFrame.setVisible(false);
									} catch (InterruptedException e1) {
										JOptionPane.showMessageDialog(null, "进入系统失败，请重进！");
										e1.printStackTrace();
									}

								
											new Home_F().setVisible(true);
											
		
								}
								
								@Override
								public void windowIconified(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowDeiconified(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowDeactivated(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowClosing(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowClosed(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowActivated(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
							});	
   				} else{
   							JOptionPane.showMessageDialog(null, "登录失败，账号或密码输入错误，请重新输入！");
   							jPasswordField.setText("");
   							jTextField.setText("");
   					}
					}
    				
    				
    				if (jTextField.getText().equals("cashier")) {
    					//当账号为cashier时进入的界面
        				java.sql.PreparedStatement ps1=conn.prepareStatement(sql1);
        				
        				if(ps1.executeQuery().next()){
        					
    					 	 frame.setVisible(false);

       					 final JFrame jFrame=new JFrame();
       					
       					jFrame.setBounds(750, 350, 442, 303);
       					jFrame.setUndecorated(true);
       					
       					JLabel jLabel1=new JLabel();
       					jLabel1.setIcon(new ImageIcon("Photo//登录成功.png"));
       					jLabel1.setBounds(750, 350, 400, 300);
       					jFrame.add(jLabel1);
       					jFrame.setVisible(true);
       					
    						
       					jFrame.addWindowListener(new WindowListener() {
    							
    							@Override
    							public void windowOpened(WindowEvent e) {
    								
    								try {
    									Thread.sleep(3000);//出现时间3000毫秒，3秒
    									jFrame.setVisible(false);
    								} catch (InterruptedException e1) {
    									JOptionPane.showMessageDialog(null, "进入系统失败，请重进！");
    									e1.printStackTrace();
    								}

    								
    										new Home_F1().setVisible(true);
    										new Home_F().setVisible(false);
    								
    							}
    							
    							@Override
    							public void windowIconified(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowDeiconified(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowDeactivated(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowClosing(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowClosed(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowActivated(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    						});	
    				} else{
    							JOptionPane.showMessageDialog(null, "登录失败，账号或密码输入错误，请重新输入！");
    							jPasswordField.setText("");
    							jTextField.setText("");
    					}
					}
    			
    				
    				
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    		}
    		});
		
		
		
		
		
		
		//getRootPane().setDefaultButton(jButton1);
		

		
		jButton2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			int show = JOptionPane.showConfirmDialog(null, "确定要退出吗？", "请选择", JOptionPane.YES_NO_OPTION);
    			if(show==JOptionPane.YES_OPTION){
    			System.exit(0);
    			}
    		}
    		});
		
		jButton3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		
    				new Change().setVisible(true);
    				
    		}
    		});
    	 
		jPasswordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String number=jTextField.getText();
    			String pwd=new String(jPasswordField.getPassword());
    			String sql="";
    			String sql1="";
    			if(number.equals("")){
    				
    				JOptionPane.showMessageDialog(
    						Login.this, "账号不能为空！","提示",JOptionPane.INFORMATION_MESSAGE);
    				jPasswordField.setText("");				
    				return;
    			}
    			if(pwd.equals("")){    				
    				JOptionPane.showMessageDialog(
    						Login.this, "密码不能为空！","提示",JOptionPane.INFORMATION_MESSAGE);
    				jTextField.setText("");
    				return; 				
    			}
    			  sql="select * from employee where Number='"+"admin"+"' and Pwd='"+"123456"+"'";
    			  sql1="select * from employee where Number='"+"cashier"+"' and Pwd='"+"123456"+"'";
    			  
    			Connection conn;
    			try {
    				conn = DbConnection.getConnection();
    				java.sql.PreparedStatement ps=conn.prepareStatement(sql);
    				//当账号为admin时进入的界面
    				
    				if (jTextField.getText().equals("admin")) {
    					if(ps.executeQuery().next()){
        					
   					 	 frame.setVisible(false);

       					 final JFrame jFrame=new JFrame();
       					
       					jFrame.setBounds(750, 350, 442, 303);
       					jFrame.setUndecorated(true);
       					
       					JLabel jLabel1=new JLabel();
       					jLabel1.setIcon(new ImageIcon("Photo//登录成功.png"));
       					jLabel1.setBounds(750, 350, 400, 300);
       					jFrame.add(jLabel1);
       					jFrame.setVisible(true);
       					
   						
       					jFrame.addWindowListener(new WindowListener() {
								
								@Override
								public void windowOpened(WindowEvent e) {
									
									try {
										Thread.sleep(3000);//出现时间3000毫秒，3秒
										jFrame.setVisible(false);
									} catch (InterruptedException e1) {
										JOptionPane.showMessageDialog(null, "进入系统失败，请重进！");
										e1.printStackTrace();
									}

								
											new Home_F().setVisible(true);
											
		
								}
								
								@Override
								public void windowIconified(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowDeiconified(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowDeactivated(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowClosing(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowClosed(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
								
								@Override
								public void windowActivated(WindowEvent e) {
									// TODO Auto-generated method stub
									
								}
							});	
   				} else{
   							JOptionPane.showMessageDialog(null, "登录失败，账号或密码输入错误，请重新输入！");
   							jPasswordField.setText("");
   							jTextField.setText("");
   					}
					}
    				
    				
    				if (jTextField.getText().equals("cashier")) {
    					//当账号为cashier时进入的界面
        				java.sql.PreparedStatement ps1=conn.prepareStatement(sql1);
        				
        				if(ps1.executeQuery().next()){
        					
    					 	 frame.setVisible(false);

       					 final JFrame jFrame=new JFrame();
       					
       					jFrame.setBounds(750, 350, 442, 303);
       					jFrame.setUndecorated(true);
       					
       					JLabel jLabel1=new JLabel();
       					jLabel1.setIcon(new ImageIcon("Photo//登录成功.png"));
       					jLabel1.setBounds(750, 350, 400, 300);
       					jFrame.add(jLabel1);
       					jFrame.setVisible(true);
       					
    						
       					jFrame.addWindowListener(new WindowListener() {
    							
    							@Override
    							public void windowOpened(WindowEvent e) {
    								
    								try {
    									Thread.sleep(3000);//出现时间3000毫秒，3秒
    									jFrame.setVisible(false);
    								} catch (InterruptedException e1) {
    									JOptionPane.showMessageDialog(null, "进入系统失败，请重进！");
    									e1.printStackTrace();
    								}

    								
    										new Home_F1().setVisible(true);
    										new Home_F().setVisible(false);
    								
    							}
    							
    							@Override
    							public void windowIconified(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowDeiconified(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowDeactivated(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowClosing(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowClosed(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    							
    							@Override
    							public void windowActivated(WindowEvent e) {
    								// TODO Auto-generated method stub
    								
    							}
    						});	
    				} else{
    							JOptionPane.showMessageDialog(null, "登录失败，账号或密码输入错误，请重新输入！");
    							jPasswordField.setText("");
    							jTextField.setText("");
    					}
					}
    			
    				
    				
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
				
				
			}
		});
    	    			
    }
    
    
    

    public void img(){
    	
    	
		  //插入背景图片
  	  background = new ImageIcon("Photo//背景.jpg");// 背景图片
  	  JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
  	  // 把标签的大小位置设置为图片刚好填充整个面板
  	  label.setBounds(0, 0, background.getIconWidth(),
  	    background.getIconHeight());
  	  // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
  	  imagePanel = (JPanel) frame.getContentPane();
  	  imagePanel.setOpaque(false);
  	  // 内容窗格默认的布局管理器为绝对定位
  	  imagePanel.setLayout(null);
  	  frame.getLayeredPane().setLayout(null);
  	  // 把背景图片添加到分层窗格的最底层作为背景
  	  frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
  	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  frame.setSize(background.getIconWidth(), background.getIconHeight());
  	  frame.setResizable(true);
  	  frame.setVisible(true);
  	  
	}
    
    
    public static void main(String args[]) {

    
    	Login log=new Login();
    	log.log();
    	log.img();
    	
    	
        }
    }

 

