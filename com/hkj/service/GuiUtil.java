package com.hkj.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class GuiUtil {



	/**
	 * 绐楀彛灞呬腑鏄剧ず
	 * 
	 * @param win
	 */
	public static void centerWindow(Container win) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scr = toolkit.getScreenSize();
		int x = (scr.width - win.getWidth()) / 2;
		int y = (scr.height - win.getHeight()) / 2;
		win.setLocation(x, y);
	}

	// //////////////////////////琛ㄦ牸/////////////////////////////////
	/**
	 * 闅愯棌table鐨勯儴鍒嗗垪
	 */
	public static void hideTbColumn(JTable tb, int[] cols) {
		for (int i : cols) {
			TableColumn column = tb.getColumnModel().getColumn(i);
			column.setMinWidth(0);
			column.setMaxWidth(0);
			column.setWidth(0);
			column.setPreferredWidth(0);
		}
	}

	// jTable.getTableHeader().setBackground(new
	// Color(206,231,255));//璁剧疆JTable琛ㄥご棰滆壊
	// jTable.getTableHeader().setReorderingAllowed(false);//璁剧疆JTable姣忎釜瀛楁鐨勯『搴忎笉鍙互鏀瑰彉
	// jTable.getTableHeader().setResizingAllowed(false); //璁剧疆JTable姣忎釜琛ㄥご鐨勫ぇ灏忎笉鍙互鏀瑰彉

	/**
	 * 鏍煎紡鍖栬〃鏍�
	 */
	@SuppressWarnings("static-access")
	public static void formatTb(JTable tb) {
		@SuppressWarnings("serial")
		DefaultTableCellRenderer render = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				
				if (row % 2 == 0)
					setBackground(new Color(180, 227, 239)); // 璁剧疆濂囨暟琛屽簳鑹�
					//setBackground(new Color(153, 217, 234));
				else if (row % 2 == 1)
					setBackground(Color.white); // 璁剧疆鍋舵暟琛屽簳鑹�
				return super.getTableCellRendererComponent(table, value,
						isSelected, hasFocus, row, column);

			}

			@SuppressWarnings("unused")
			public void setValue(Object value) {
				if (value instanceof IconTxt) {
					if (value != null) {
						IconTxt d = (IconTxt) value;
						String txt = d.toString();

						setText(txt == null ? "" : txt);
						setIcon(d.getIcon());

						if (Validator.isNumeric(txt)) {
							setHorizontalTextPosition(SwingConstants.RIGHT);
							setVerticalTextPosition(SwingConstants.CENTER);
							setHorizontalAlignment(SwingConstants.LEFT);
							setVerticalAlignment(SwingConstants.CENTER);
						} else {
							setHorizontalTextPosition(SwingConstants.RIGHT);
							setVerticalTextPosition(SwingConstants.CENTER);
							setHorizontalAlignment(SwingConstants.LEFT);
							setVerticalAlignment(SwingConstants.CENTER);
						}
					} else {
						setText("");
						setIcon(null);
					}
				} else {
					super.setValue(value);
				}
			}
		};

		// 鎸囧畾鐨勫垪灞呬腑-
		for (int i = 0; i < tb.getColumnCount(); i++) {
			// if(tb.getColumnName(i).equals("鍏佽鍙戦�璀﹀憡淇℃伅")) continue;
			tb.getColumn(tb.getColumnName(i)).setCellRenderer(render);
		}
		// tb.setDefaultRenderer(Object.class, render);

		// 璁剧疆琛ㄥご灞呬腑
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tb
				.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(renderer.CENTER);
		// 绂佹鎷夊姩琛ㄦ牸锛岀姝㈣皟鏁村垪瀹�
		//tb.getTableHeader().setResizingAllowed(false);
		tb.getTableHeader().setReorderingAllowed(false);

		// 鏍规嵁琛ㄦ牸鍐呭鑷姩鐨勮皟鏁村垪瀹�
		for (int i = 0; i < tb.getColumnCount(); i++) {
			int with = getPreferredWidthForCloumn(tb, i) + 10;
			// with = iniCW[i] > with ? iniCW[i] : with; //濡傛灉寰楀埌鐨勫垪瀹藉お灏忥紝鍙互璁剧疆榛樿鐨勫垪瀹�
			tb.getColumnModel().getColumn(i).setPreferredWidth(with);
		}

	}

	/**
	 * 鑾峰彇琛ㄦ牸鐨勬渶澶х殑鍒楀
	 * 
	 * @param table
	 * @param icol
	 * @return
	 */
	private static int getPreferredWidthForCloumn(JTable table, int icol) {
		TableColumnModel tcl = table.getColumnModel();
		TableColumn col = tcl.getColumn(icol);
		int c = col.getModelIndex(), width = 0, maxw = 0;
		maxw = col.getPreferredWidth();
		for (int r = 0; r < table.getRowCount(); ++r) {
			TableCellRenderer renderer = table.getCellRenderer(r, c);
			Component comp = renderer.getTableCellRendererComponent(table,
					table.getValueAt(r, c), false, false, r, c);
			width = comp.getPreferredSize().width;
			maxw = width > maxw ? width : maxw;
		}
		return maxw;
	}

	/**
	 * 
	 * 榧犳爣鍙冲嚮鐩戝惉锛氳〃鏍奸�涓綋鍓嶆墍鍦ㄨ
	 * 
	 * @author liweiwei
	 * 
	 */
	public static class RightClickListener extends MouseAdapter {
		private JTable tb;

		public RightClickListener(JTable tb) {
			this.tb = tb;
		}

		public void mousePressed(MouseEvent e) {
			selectTable(e);
		}

		public void mouseReleased(MouseEvent e) {
			selectTable(e);
		}

		private void selectTable(MouseEvent e) {
			int row = tb.rowAtPoint(e.getPoint());
			if (row >= 0)
				tb.setRowSelectionInterval(row, row);

		}
	}

	/**
	 * 璁剧疆table 鐨勫榻愭柟寮�
	 * 
	 * @author liweiwei
	 * 
	 */
	@SuppressWarnings("serial")
	public static class MyTableCellRenderer extends DefaultTableCellRenderer

	{// SwingConstants.CENTER
		public MyTableCellRenderer(int directon) {
			super();
			setHorizontalAlignment(directon);
		}

		public void setValue(Object value) {
			super.setValue(value);
		}
	}

	// ///////////////////////鏃堕棿/////////////////////////////
	/**
	 * 鏍煎紡鍖栨椂闂存樉绀�
	 * 
	 * @param time
	 * @return
	 */
	public static String TimestampToString(java.sql.Timestamp time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time).toString();
	}

	public static Date StringToDate(String s) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// ///////////////////////

	public static String DateToString(Date time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time).toString();
	}

	public static String getYMD(Date time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time).toString();
	}

	public static Date inputStringToDate(String s) {
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(s);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "滴撒大");
			return null;
		}
	}

	// //////////////////////缂栬緫鍖哄煙/////////////////////////////

	/**
	 * 缂栬緫鍖哄煙鍒濆鍖栨樉绀�
	 * 
	 * @param panel
	 */
	@SuppressWarnings("rawtypes")
	public static void initView(JPanel panel) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			Component com = panel.getComponent(i);
			if (com instanceof JTextField) {
				((JTextField) com).setText("");
			}
			if (com instanceof JComboBox) {
				if (((JComboBox) com).getItemCount() > 0)
					((JComboBox) com).setSelectedIndex(0);
			}

			if (com instanceof JCheckBox)
				((JCheckBox) com).setSelected(false);

			if (com instanceof JPanel) {
				initView((JPanel) com);
			}
		}
	}
	
	/**
	 * 缂栬緫鍖哄煙鏄惁enble
	 * 
	 * @param panel
	 */
	public static void enableView(JPanel panel, boolean flg) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			Component com = panel.getComponent(i);
			if (com instanceof JLabel) {
				com.setEnabled(true);
			} else if (com instanceof JPanel) {
				enableView((JPanel) com, flg);
			} else {
				com.setEnabled(flg);
			}
		}
	}

	/**
	 * 缂栬緫鍖烘槸鍚﹀彲缂栬緫
	 * 
	 * @param panel
	 * @param flg
	 */
	public static void editAbled(JPanel panel, boolean flg) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			Component com = panel.getComponent(i);
			if (com instanceof JLabel) {// 鏍囩
				com.setEnabled(true);
			} else if (com instanceof JTextField) {// 鏂囨湰妗�
				((JTextField) com).setEditable(flg);
			} else if (com instanceof JPanel) {// 闈㈡澘
				editAbled((JPanel) com, flg);
			} else {// 鍏朵粬
				com.setEnabled(flg);
			}
		}
	}

	// /////////////////////////////////////////////////////////////
	/**
	 * 寰楀埌鍥剧墖鏂囦欢鐨勫ぇ灏�
	 * 
	 * @param name
	 * @return
	 */
	public static Dimension getImageSize(String name) {
		File _file = new File(name); // 璇诲叆鏂囦欢
		Image src;
		Dimension dim = new Dimension();
		try {
			src = javax.imageio.ImageIO.read(_file);
			int width = src.getWidth(null) + 10; // 寰楀埌婧愬浘瀹�
			int height = src.getHeight(null) + 10; // 寰楀埌婧愬浘闀�
			dim.setSize(width, height);
		} catch (IOException e) {
			e.printStackTrace();
		} // 鏋勯�Image瀵硅薄
		return dim;
	}

	// //////////////////////////鑾峰彇鍩虹珯璇嗗埆鐮佺殑鍗佸叚杩涘埗鏄剧ず///////////////////
	/**
	 * 鑾峰彇4浣嶇殑鍗佸叚杩涘埗璇嗗埆鐮�
	 * 
	 * @param sysId
	 * @return
	 */
	public static String getSysId(int sysId) {
		StringBuilder sb = new StringBuilder(Integer.toHexString(sysId));
		int len = sb.length();
		for (int i = 0; i < 4 - len; i++) {
			sb.insert(0, '0');
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 鑾峰彇4浣嶇殑鍗佸叚杩涘埗璇嗗埆鐮�
	 * 
	 * @param sysId
	 * @return
	 */
	public static String getLong(int sysId) {
		StringBuilder sb = new StringBuilder(Integer.toHexString(sysId));
		int len = sb.length();
		for (int i = 0; i < 4 - len; i++) {
			sb.insert(0, '0');
		}
		return sb.toString().toUpperCase();
	}
	
	
	public static String getCurrTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fromatter = new SimpleDateFormat("yyyy / MM / dd  HH:mm:ss");
		String strCurrTime = fromatter.format(cal.getTime());
		return strCurrTime;
	}

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(date));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String d = format.format(date).toString() + " 00:00:00";
		System.out.println(d);
		System.out.println(GuiUtil.inputStringToDate(d));
	}


}
