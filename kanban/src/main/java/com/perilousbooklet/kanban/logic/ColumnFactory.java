package com.perilousbooklet.kanban.logic;

import com.perilousbooklet.kanban.App;
import com.perilousbooklet.kanban.gui.Board;
import com.perilousbooklet.kanban.gui.Column;

/**
 * ColumnFactory
 */
public class ColumnFactory {
	
	public Column createColumn(String columnTitleText, Board board) {
		return new Column(columnTitleText, App.mediator, board);
	}
	
}
