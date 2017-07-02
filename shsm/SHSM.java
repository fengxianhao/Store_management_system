/*
 * SHSM.java
 *
 * Created on __DATE__, __TIME__
 */

package shsm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import com.hkj.view.Employee;
import com.hkj.view.Member;
import com.hkj.view.Register;

/**
 *
 * @author  __USER__
 */
public class SHSM extends javax.swing.JFrame {
	Image backgroundImage = null;
	static int index = -1;
	static String xiugaiID;
	//添加地址管理
	static int indexDZ = -1;
	static String xiugaiDzID;

	/** Creates new form SHSM */
	public SHSM() {
		initComponents();
		this.setSize(1172, 653);
		this.setLocationRelativeTo(null);
		this.setBounds(300,100, 1366,768);
		this.setResizable(false);

	}

	static DefaultTableModel modelKDGL = new DefaultTableModel(new Object[][] {

	}, new String[] { "快递员编号", "快递员姓名", "快递员性别", "快递员年龄", "快递员职位", "身份证号", "电话",
			"地址" });
	static DefaultTableModel modelDZGL = new DefaultTableModel(new Object[][] {

	}, new String[] { "地址编号", "订单编号", "送达地址", "下单时间", "送达时间", "快递员编号" });

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel4 = new javax.swing.JPanel();
		jLsure = new javax.swing.JLabel();
		jLUpdate = new javax.swing.JLabel();
		jLDelete = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jToolBar1 = new javax.swing.JToolBar();
		jPanel3 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		jlKDUpda = new javax.swing.JLabel();
		jlKDsure = new javax.swing.JLabel();
		jlKDDelete = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTableKDYGL = new javax.swing.JTable();
		jToolBar2 = new javax.swing.JToolBar();
		jPanel6 = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		jlDZSure = new javax.swing.JLabel();
		jlDZUpdate = new javax.swing.JLabel();
		jlDZDelete = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTableDZGL = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(jTable1);
		

		jPanel4.setBackground(new java.awt.Color(51, 155, 255));

		jLsure.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLsureMouseEntered(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(133, 133, 133)
										.addComponent(
												jLsure,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												114,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(270, 270, 270)
										.addComponent(
												jLUpdate,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												117,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												275, Short.MAX_VALUE)
										.addComponent(
												jLDelete,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												114,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(157, 157, 157)));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel4Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLDelete,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				48,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLUpdate,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				48,
																				Short.MAX_VALUE))
														.addComponent(
																jLsure,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																48,
																Short.MAX_VALUE))
										.addContainerGap()));

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}

			public void windowIconified(java.awt.event.WindowEvent evt) {
				formWindowIconified(evt);
			}
		});

		jPanel1.setLayout(null);

		jToolBar1.setRollover(true);

		jPanel5.setBackground(new java.awt.Color(19, 148, 240));

		jlKDUpda.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/修改.png"))); // NOI18N
		jlKDUpda.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jlKDUpdaMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jlKDUpdaMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jlKDUpdaMouseExited(evt);
			}
		});

		jlKDsure.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/确定.png"))); // NOI18N
		jlKDsure.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jlKDsureMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jlKDsureMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jlKDsureMouseExited(evt);
			}
		});

		jlKDDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/删除.png"))); // NOI18N
		jlKDDelete.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jlKDDeleteMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jlKDDeleteMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jlKDDeleteMouseExited(evt);
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel5Layout
										.createSequentialGroup()
										.addGap(158, 158, 158)
										.addComponent(jlKDsure)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												246, Short.MAX_VALUE)
										.addComponent(jlKDUpda)
										.addGap(243, 243, 243)
										.addComponent(jlKDDelete)
										.addGap(165, 165, 165)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jlKDsure,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																59,
																Short.MAX_VALUE)
														.addComponent(
																jlKDUpda,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																59,
																Short.MAX_VALUE)
														.addComponent(
																jlKDDelete,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																59,
																Short.MAX_VALUE))
										.addContainerGap()));

		jTableKDYGL.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "快递员编号", "快递员姓名", "快递员性别", "快递员年龄", "快递员职位",
						"身份证号", "电话", "地址" }));
		jScrollPane2.setViewportView(jTableKDYGL);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						jPanel3Layout
								.createSequentialGroup()
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										1147, Short.MAX_VALUE)
								.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												441,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		jToolBar1.add(jPanel3);

		jTabbedPane1.addTab("\u5feb\u9012\u5458\u7ba1\u7406", jToolBar1);

		jToolBar2.setRollover(true);

		jPanel7.setBackground(new java.awt.Color(19, 148, 240));

		jlDZSure.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/确定.png"))); // NOI18N
		jlDZSure.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jlDZSureMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jlDZSureMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jlDZSureMouseExited(evt);
			}
		});

		jlDZUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/修改.png"))); // NOI18N
		jlDZUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jlDZUpdateMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jlDZUpdateMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jlDZUpdateMouseExited(evt);
			}
		});

		jlDZDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/删除.png"))); // NOI18N
		jlDZDelete.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jlDZDeleteMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jlDZDeleteMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jlDZDeleteMouseExited(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel7Layout
										.createSequentialGroup()
										.addGap(155, 155, 155)
										.addComponent(jlDZSure)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												242, Short.MAX_VALUE)
										.addComponent(jlDZUpdate)
										.addGap(247, 247, 247)
										.addComponent(jlDZDelete)
										.addGap(168, 168, 168)));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jlDZDelete,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																59,
																Short.MAX_VALUE)
														.addComponent(
																jlDZSure,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																59,
																Short.MAX_VALUE)
														.addComponent(
																jlDZUpdate,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																59,
																Short.MAX_VALUE))
										.addContainerGap()));

		jTableDZGL.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "快递员编号", "送达地址", "下单时间", "送达时间" }));
		jScrollPane3.setViewportView(jTableDZGL);

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(
						jPanel6Layout
								.createSequentialGroup()
								.addComponent(jScrollPane3,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										1147, Short.MAX_VALUE)
								.addContainerGap()));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												442,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		jToolBar2.add(jPanel6);

		jTabbedPane1.addTab("\u5730\u5740\u7ba1\u7406", jToolBar2);

		jPanel1.add(jTabbedPane1);
		jTabbedPane1.setBounds(10, 50, 1366, 650);

		jPanel2.setBackground(new java.awt.Color(53, 155, 240));
		
		jPanel2.setLayout(null);

		jLabel1.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel1.setForeground(new java.awt.Color(240, 240, 240));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("\u9001\u8d27\u4e0a\u95e8\u670d\u52a1");
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel1MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel1MouseExited(evt);
			}
		});
		jPanel2.add(jLabel1);
		jLabel1.setBounds(720, 0, 120, 50);

		jLabel2.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel2.setForeground(new java.awt.Color(240, 240, 240));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("\u5e97\u94fa\u6536\u6b3e");
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel2MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel2MouseExited(evt);
			}
		});
		jPanel2.add(jLabel2);
		jLabel2.setBounds(10, 0, 120, 50);

		jLabel3.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel3.setForeground(new java.awt.Color(240, 240, 240));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("\u96c7\u5458\u7ba1\u7406");
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel3MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel3MouseExited(evt);
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Employee().setVisible(true);
						Employee table=new Employee();
					}
				});
			}
			
			
		});
	
		jPanel2.add(jLabel3);
		jLabel3.setBounds(150, 0, 120, 50);

		jLabel4.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel4.setForeground(new java.awt.Color(240, 240, 240));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("\u4f1a\u5458\u7ba1\u7406");
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel4MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel4MouseExited(evt);
			}
			public void mouseReleased(MouseEvent e) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Member().setVisible(true);
					}
				});
			}
		});
		jPanel2.add(jLabel4);
		jLabel4.setBounds(300, 0, 110, 50);

		jLabel5.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel5.setForeground(new java.awt.Color(240, 240, 240));
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("\u4ea7\u54c1\u7ba1\u7406");
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel5MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel5MouseExited(evt);
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						Register register=new Register();
						register.reg();
						
						setVisible(false);
					}
				});
			}
		});
		jPanel2.add(jLabel5);
		jLabel5.setBounds(440, 0, 120, 50);

		jLabel6.setFont(new java.awt.Font("宋体", 1, 18));
		jLabel6.setForeground(new java.awt.Color(240, 240, 240));
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setText("\u9500\u552e\u7edf\u8ba1");
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel6MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel6MouseExited(evt);
			}
		});
		jPanel2.add(jLabel6);
		jLabel6.setBounds(580, 0, 120, 50);

		jPanel1.add(jPanel2);
		jPanel2.setBounds(0, 0, 1366, 50);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel1.setForeground(new Color(235, 255, 255));
	}

	private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel1.setForeground(new Color(235, 255, 43));
	}

	private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel6.setForeground(new Color(235, 255, 255));
	}

	private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel6.setForeground(new Color(235, 255, 43));
	}

	private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel5.setForeground(new Color(235, 255, 255));
	}

	private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel5.setForeground(new Color(235, 255, 43));
	}

	private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel4.setForeground(new Color(235, 255, 255));
	}

	private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel4.setForeground(new Color(235, 255, 43));
	}

	private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel3.setForeground(new Color(255, 255, 255));
	}

	private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel3.setForeground(new Color(235, 255, 43));
	}

	private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel2.setForeground(new Color(255, 255, 255));
	}

	private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jLabel2.setForeground(new Color(235, 255, 43));
	}

	private void formWindowIconified(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:

	}

	private void jlDZUpdateMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		// TODO add your handling code here:
		indexDZ = SHSM.jTableDZGL.getSelectedRow();
		xiugaiDzID = jTableDZGL.getValueAt(indexDZ, 0).toString();
		new DZinfoDialog(null, true).setVisible(true);
	}

	private void jlDZDeleteMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		// TODO add your handling code here:
		int row;
		row = this.jTableDZGL.getSelectedRow();
		String id = jTableDZGL.getValueAt(row, 0).toString();

		int n = JOptionPane.showConfirmDialog(null, "是否删除？", "警告",
				JOptionPane.WARNING_MESSAGE);
		if (n == 0) {
			if (ShsmManage.runUpdate("delete from deliver where addressid="
					+ id + "")) {
				JOptionPane.showMessageDialog(null, "删除成功");
				showTableDzgl();
			} else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}
	}

	private void jlDZSureMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		new DzglDialog(null, true).setVisible(true);
	}

	private void jlKDUpdaMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		index = SHSM.jTableKDYGL.getSelectedRow();
		xiugaiID = jTableKDYGL.getValueAt(index, 0).toString();
		new KDinfoDialog(null, true).setVisible(true);
	}

	private void jlKDDeleteMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row;
		row = this.jTableKDYGL.getSelectedRow();
		String id = jTableKDYGL.getValueAt(row, 0).toString();

		int n = JOptionPane.showConfirmDialog(null, "是否删除？", "警告",
				JOptionPane.WARNING_MESSAGE);
		if (n == 0) {
			if (ShsmManage.runUpdate("delete from employee where employeeID="
					+ id + "")) {
				JOptionPane.showMessageDialog(null, "删除成功");
				showTableKdgl();
			} else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}

	}

	//快递员管理添加事件
	private void jlKDsureMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		new KdglDialog(null, true).setVisible(true);

	}

	//显示快递员管理表方法
	public static void showTableKdgl() {
		jTableKDYGL.setModel(modelKDGL);
		modelKDGL.setRowCount(0);//设置表格行数为零
		ResultSet rst = ShsmManage.runSelect("select * from employee");
		try {
			while (rst.next()) {
				Object row[] = { rst.getString(1), rst.getString(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getString(6), rst.getString(7), rst.getString(8) };
				modelKDGL.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//显示地址管理表方法
	public static void showTableDzgl() {
		jTableDZGL.setModel(modelDZGL);
		modelDZGL.setRowCount(0);//设置表格行数为零
		ResultSet rst = ShsmManage.runSelect("select * from deliver");
		try {
			while (rst.next()) {
				Object row[] = { rst.getString(1), rst.getString(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getString(6), };
				modelDZGL.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jlDZUpdateMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlDZUpdate.setSize(125, 58);
	}

	private void jlDZUpdateMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlDZUpdate.setSize(130, 60);
	}

	private void jlKDUpdaMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlKDUpda.setSize(125, 58);
	}

	private void jlKDUpdaMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlKDUpda.setSize(130, 60);
	}

	private void jlKDDeleteMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlKDDelete.setSize(118, 58);
	}

	private void jlKDDeleteMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlKDDelete.setSize(122, 60);
	}

	private void jlDZDeleteMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlDZDelete.setSize(118, 58);
	}

	private void jlDZDeleteMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlDZDelete.setSize(122, 60);
	}

	private void jlDZSureMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlDZSure.setSize(118, 58);
	}

	private void jlDZSureMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlDZSure.setSize(122, 60);
	}

	private void jlKDsureMouseExited(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlKDsure.setSize(118, 58);
	}

	private void jlKDsureMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jlKDsure.setSize(122, 60);
	}

	private void jLsureMouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:

	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		showTableKdgl();
		showTableDzgl();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SHSM().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLDelete;
	private javax.swing.JLabel jLUpdate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLsure;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private static javax.swing.JTable jTableDZGL;
	private static javax.swing.JTable jTableKDYGL;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JToolBar jToolBar2;
	private javax.swing.JLabel jlDZDelete;
	private javax.swing.JLabel jlDZSure;
	private javax.swing.JLabel jlDZUpdate;
	private javax.swing.JLabel jlKDDelete;
	private javax.swing.JLabel jlKDUpda;
	private javax.swing.JLabel jlKDsure;
	// End of variables declaration//GEN-END:variables

}