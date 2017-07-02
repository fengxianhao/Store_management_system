package com.hkj.service;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * 
 * @author 郭智勇
 *
 * Store_management_system
 * MyTableModel.java
 * 下午3:31:30
 */
public class MyTableModel implements TableModel {
	public MyTableModel(Object[][] obj, String[] columnsName) {
		super();
		this.obj = obj;
		this.columnsName = columnsName;
	}

	Object[][] obj;
	String[] columnsName;

	public void setObj(Object[][] obj) {
		this.obj = obj;
	}
	
	public int getColumnCount() {
		return columnsName.length;
	}

	public int getRowCount() {
		return obj.length;
	}

	public String getColumnName(int col) {
		return columnsName[col];
	}

	public Object getValueAt(int row, int col) {
		return obj[row][col];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/**
	 * 全部单元格不可编辑
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		obj[row][col] = value;
		fireTableCellUpdated(row, col);
	}

	private void fireTableCellUpdated(int row, int col) {
	}

	public void addTableModelListener(TableModelListener l) {
	}

	public void removeTableModelListener(TableModelListener l) {
	}
}
