package com.hkj.service;

import java.awt.Component;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Validator {



	/**
	 * 瀛楃涓叉槸鏁板瓧鎴�"鏃秚rue锛屽惁鍒檉alse
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (str == null)
			return false;
		if (str.matches("\\d*") || str.matches("\\d*\\.\\d*")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 淇濊瘉鍏ㄦ槸鏁板瓧
	 * @param str
	 * @return
	 */
	public static boolean isNumNoPoint(String str) {
		if (str.matches("\\d*")) {
			return true;
		} else {
			return false;
		}
	}

	// 2.姝ｅ垯琛ㄨ揪寮�
	public static boolean isNumeric1(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 楠岃瘉鐢佃瘽鍙风爜(010)-12233221銆�0123)11221122銆�22-22332211銆�22
	 * 22332211銆�2222332211銆�3911221122
	 * 
	 * @param tel
	 * @return
	 */
	public static boolean tel(String tel) {
		boolean b = tel.matches("(^\\(0\\d{2,3}\\)-\\d{7,8}$)"
				+ "|(^\\(0\\d{2,3}\\)\\d{7,8}$)" + "|(^0\\d{2,3}-\\d{7,8}$)"
				+ "|(^0\\d{2,3}\\s\\d{7,8}$)" + "|(^0\\d{2,3}\\d{7,8}$)"
				+ "|(^[1]\\d{10}$)");
		if (b) {
			return true;
		} else {
			return false;
		}

		// (^(13|15|18)[0-9]{9}$)
		// |(^0[1,2]{1} \\d{1}-?\\d{8}$)
		// |(^0[3-9]{1}\\d{2}-?\\d{7,8}$)
		// |(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)
		// |(^0[3-9]{1}\\d{2}-?\\d{7,8}-(\\d{1,4})$)

	}

	/**
	 * 楠岃瘉鏈夋晥ip
	 * 
	 * @param ip
	 */
	
	public static boolean validIp(JTextField txt,boolean isMsg) {
		
		String regExp = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

		if (txt.getText().trim().equals("")) {
			return true;
		}
		if (txt.getText().trim().matches(regExp)) {
			return true;
		} else {
			if(isMsg)
				JOptionPane.showMessageDialog(null, "璇疯緭鍏ユ纭殑IP鍦板潃,濡傦細100.2.3.56");
			txt.setText("");
			txt.requestFocus();
			return false;
		}
	}

	/**
	 * 闈炵┖銆佹暟瀛椼�min锝瀖ax鐨勮寖鍥�鏁存暟
	 * 
	 * @param txt
	 * @param max
	 */
	public static boolean validInt(javax.swing.JDialog frm, JTextField txt,
			String lbl, int min, int max) {
		String str = txt.getText().trim();
		if (str.length() == 0) {
			JOptionPane.showMessageDialog(frm, lbl + "涓嶈兘涓虹┖");
			txt.setText("");
			txt.requestFocus();
			return false;
		}
		
		if (!Validator.isNumNoPoint(str)) {
			JOptionPane.showMessageDialog(frm, lbl + "搴斾负鏁存暟鏁板瓧");
			txt.setText("");
			txt.requestFocus();
			return false;
		}
		if(str.length()>(Integer.MAX_VALUE+"").length()){
			JOptionPane.showMessageDialog(frm, lbl + "涓嶈兘瓒呰繃10浣嶆暟瀛楋紒");
			txt.setText("");
			txt.requestFocus();
			return false;
		}
		
		long iStr;
		try {
			iStr = Long.valueOf(str);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frm, lbl + "鍙栧�鑼冨洿:" + min + "~" + max+"鐨勬暣鏁帮紒");
			txt.setText("");
			txt.requestFocus();
			return false;
		}
		if (iStr < min || iStr > max) {
			JOptionPane.showMessageDialog(frm, lbl + "鍙栧�鑼冨洿:" + min + "~" + max+"鐨勬暣鏁帮紒");
			txt.setText("");
			txt.requestFocus();
			return false;
		}
		return true;
	}
	
	/**
	 * 鍒ゆ柇Int
	 * 
	 * @param txt
	 * @param lbl
	 * @param min
	 * @param max
	 * @param isMsg
	 * @return
	 */
	public static boolean validIntNum(JTextField txt, String lbl, int min,
			int max, boolean isMsg) {

		// 涓虹┖鐩存帴杩斿洖true
		String str = txt.getText().trim();
		if (str.length() == 0)
			return true;

		// 绫诲瀷鍙婂叾鍙栧�鑼冨洿楠岃瘉
		boolean isOK = true;
		try {
			int num = Integer.parseInt(str);
			if (num < min || num > max) {// 鑼冨洿
				isOK = false;
			}
		} catch (NumberFormatException e) {// 鏁板瓧
			isOK = false;
			e.printStackTrace();
		}

		if (!isOK) {
			if (isMsg)
				JOptionPane.showMessageDialog(null, lbl + "鍙栧�鑼冨洿:" + min + "~"
						+ max + "鐨勬暣鏁帮紒");
			txt.setText("");
			txt.requestFocus();

			return false;
		} else
			return true;
	}
	
	
	/**
	 * 鍒ゆ柇Float
	 * 
	 * @param txt
	 * @param lbl
	 * @param min
	 * @param max
	 * @param isMsg
	 * @return
	 */
	public static boolean validDoubleNum(JTextField txt, String lbl, double max, boolean isMsg) {

		// 涓虹┖鐩存帴杩斿洖true
		String str = txt.getText().trim();
		if (str.length() == 0)
			return true;

		// 绫诲瀷鍙婂叾鍙栧�鑼冨洿楠岃瘉
		boolean isOK = true;
		try {
			Double num = Double.parseDouble(str);
			if (num < 0 || num > max) {// 鑼冨洿
				isOK = false;
			}
		} catch (NumberFormatException e) {// 鏁板瓧
			isOK = false;
		}

		if (!isOK) {
			if (isMsg)
				JOptionPane.showMessageDialog(null,lbl + "鍙栧�鑼冨洿:0~" + String.valueOf(max+"").toLowerCase());
			
			txt.setText("");
			txt.requestFocus();

			return false;
		} else
			return true;
	}


	/**
	 * 楠岃瘉淇℃伅鏄惁濉啓瀹屾暣
	 * 
	 * @param panel
	 *            缂栬緫鍖洪潰鏉�
	 * @param flag
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean validPanel(JPanel panel) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			Component com = panel.getComponent(i);
			if (com instanceof JTextField && com.isVisible()) {//鏂囨湰妗�
				boolean flag = ((JTextField) com).getText().trim().equals("");
				if (flag){
					((JTextField) com).requestFocus();
					return false;
				}
			}

			if (com instanceof JComboBox) {//澶嶉�妗�
				boolean flag = ((JComboBox) com).getSelectedIndex() == -1;
				if (flag){
					com.requestFocus();
					return false;
				}
			}
			
			if(com instanceof JPanel){//闈㈡澘
				if(!validPanel((JPanel) com))
					return false;
			}
		}
		
		return true;
	}

	/**
	 * 閫夋嫨琛ㄦ牸涓殑琛岃褰�
	 * 
	 * @param tb
	 * @param operate
	 * @return
	 */
	public static boolean validTb(JTable tb, String operate) {
		int row = tb.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "璇峰厛閫夋嫨瑕�" + operate + "鐨勮褰�");
			return false;
		}
		return true;
	}

	/**
	 * 淇℃伅纭
	 * 
	 * @param frm
	 * @param title
	 *            鏍囬
	 * @param info
	 *            淇℃伅
	 * @return
	 */
	public static boolean confirm(javax.swing.JDialog frm, String title, String info) {
		return JOptionPane.showConfirmDialog(frm, info, title,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}


	/**
	 * 楠岃瘉PDT鐨勪釜銆佺粍鍛煎彿鐨勬湁鏁�
	 * 
	 * @author wulei
	 * @param num
	 *            鏁板瓧缁勬垚鐨勫瓧绗︿覆
	 * @param isIndividualNumber 涓懠true;缁勫懠false
	 * @param txtFieldNumber 鏂囨湰妗�
	 * @param parentComponent 鏂囨湰妗嗘墍鍦ㄧ殑绐椾綋
	 * 
	 */
	public static boolean isCallNumberCorrect(String num,
			boolean isIndividualNumber, JTextField txtFieldNumber,
			Component parentComponent) {
		if (!isNumeric1(num)) {
			JOptionPane.showMessageDialog(parentComponent, "鍛煎彿搴斾负鏁板瓧");
			txtFieldNumber.setText("");
			txtFieldNumber.requestFocus();
			return false;
		}
		if (num.length() != 8) {
			JOptionPane.showMessageDialog(parentComponent, "鍛煎彿鏄暱搴︿负鍏殑鏁板瓧");
			txtFieldNumber.setText("");
			txtFieldNumber.requestFocus();
			return false;
		}

		int np = Integer.valueOf(num.substring(0, 3));
		if (np >= 328 && np <= 806) { // 328~806
			int fXn_1st = Integer.valueOf(num.substring(3, 4));
			if (fXn_1st >= 2 && fXn_1st <= 6) { // 2~6
				int fXn_20_69 = Integer.valueOf(num.substring(3, 5));
				int Xn_20_69 = Integer.valueOf(num.substring(5, 8));
				if (fXn_20_69 >= 20 && fXn_20_69 <= 35) { // 20~35

					if (isIndividualNumber) {
						if (Xn_20_69 >= 200 && Xn_20_69 <= 899) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�in)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					} else {
						if (Xn_20_69 >= 900 && Xn_20_69 <= 999) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�gn)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					}

				} else if (fXn_20_69 >= 36 && fXn_20_69 <= 67) { // 36~67
					if (isIndividualNumber) {
						if (Xn_20_69 >= 200 && Xn_20_69 <= 549) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�in)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					} else {
						if (Xn_20_69 >= 900 && Xn_20_69 <= 999) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�gn)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					}

				} else if (fXn_20_69 == 68 || fXn_20_69 == 69) { // 68~69
					if (isIndividualNumber) {
						JOptionPane.showMessageDialog(parentComponent,
								"鍛煎彿涓嶆纭�gn)");
						txtFieldNumber.setText("");
						txtFieldNumber.requestFocus();
						return false;
					} else {
						if (Xn_20_69 >= 900 && Xn_20_69 <= 999) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�gn)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					}

				} else {
					JOptionPane
							.showMessageDialog(parentComponent, "鍛煎彿涓嶆纭�fXn)");
					txtFieldNumber.setText("");
					txtFieldNumber.requestFocus();
					return false;
				}
			} else if (fXn_1st == 7 || fXn_1st == 8) { // 7~8
				int fXn = Integer.valueOf(num.substring(3, 6));
				if (fXn >= 700 && fXn <= 843) {
					int Xn = Integer.valueOf(num.substring(6, 8));
					if (isIndividualNumber) {
						if (Xn >= 20 && Xn <= 89) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�in)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					} else {
						if (Xn > 90 && Xn < 99) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�gn)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					}
				} else if (fXn >= 844 && fXn <= 899 && !isIndividualNumber) {
					if (isIndividualNumber) {
						JOptionPane.showMessageDialog(parentComponent,
								"鍛煎彿涓嶆纭�gn)");
						txtFieldNumber.setText("");
						txtFieldNumber.requestFocus();
						return false;
					} else {
						int gn = Integer.valueOf(num.substring(6, 8));
						if (gn >= 90 && gn <= 99) {
							return true;
						} else {
							JOptionPane.showMessageDialog(parentComponent,
									"鍛煎彿涓嶆纭�gn)");
							txtFieldNumber.setText("");
							txtFieldNumber.requestFocus();
							return false;
						}
					}
				} else {
					JOptionPane.showMessageDialog(parentComponent, "鍛煎彿涓嶆纭�fXn)");
					txtFieldNumber.setText("");
					txtFieldNumber.requestFocus();
					return false;
				}

			} else {
				JOptionPane.showMessageDialog(parentComponent, "鍛煎彿涓嶆纭�fxn1st)");
				txtFieldNumber.setText("");
				txtFieldNumber.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(parentComponent, "鍛煎彿涓嶆纭�np)");
			txtFieldNumber.setText("");
			txtFieldNumber.requestFocus();
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}


}
