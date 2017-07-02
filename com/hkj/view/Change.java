

package com.hkj.view;

public class Change extends javax.swing.JFrame {

	public Change() {
		initComponents();
		
		this.setLocation(1150, 130);
	}

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jButton1.setText("\u5207\u6362");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setIcon(new javax.swing.ImageIcon(
				"Photo//Àı¬‘Õº.png")); // NOI18N

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel2.setText("\u9884\u89c8\u56fe\uff1a");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(79, 79, 79)
								.addComponent(jButton1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										120, Short.MAX_VALUE)
								.addComponent(jButton2).addGap(75, 75, 75))
				.addGroup(
						layout.createSequentialGroup().addGap(163, 163, 163)
								.addComponent(jLabel2)
								.addContainerGap(177, Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(jLabel1)
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap()));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Login log=new Login();
    	log.log();
    	log.img();
    	
    	this.setVisible(false);
    	
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		Login1 log = new Login1();
		log.log();
		log.img();
		
		this.setVisible(false);
		
		Login log1=new Login();
		log1.setVisible(false);

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Change().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;

}