package com.perilousbooklet.kanban.logic;

import com.perilousbooklet.kanban.gui.Column;

/**
 * ColumnFactory
 */
public class ColumnFactory {
	
	public Column createColumn(String columnTitleText) {
		return new Column(columnTitleText);
	}
	
}
