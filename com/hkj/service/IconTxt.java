package com.hkj.service;

import javax.swing.Icon;

/**
 * 
 * @author 郭智勇
 *
 * Store_management_system
 * IconTxt.java
 * 下午3:45:43
 */
public class IconTxt {
	

	public IconTxt(String txt, Icon icon) {
		this.txt = txt;
		this.icon = icon;
	}
	
	public Icon getIcon() {
		return icon;
	}

	public String toString() {
		return txt.toString();
	}

	
	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}


	private Icon icon;

	private String txt="";


}
