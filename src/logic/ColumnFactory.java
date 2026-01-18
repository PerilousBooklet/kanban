package logic;

import main.Main;
import gui.Board;
import gui.Column;

public class ColumnFactory {
	
	public Column createColumn(String columnTitleText, Board board) {
		return new Column(columnTitleText, Main.mediator, board);
	}
	
}
