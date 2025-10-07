package com.perilousbooklet.kanban.logic;

import com.perilousbooklet.kanban.gui.AddColumnButton;
import com.perilousbooklet.kanban.gui.Board;

public class AddColumnButtonFactory {
  
  public AddColumnButton createAddColumnButton(Board board) {
    return new AddColumnButton(board);
  }
  
}
