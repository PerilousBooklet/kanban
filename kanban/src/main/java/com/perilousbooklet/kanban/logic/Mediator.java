package com.perilousbooklet.kanban.logic;

import java.awt.Component;

import com.perilousbooklet.kanban.gui.Column;
import com.perilousbooklet.kanban.gui.ColumnTitleLabel;

public interface Mediator {
  
  // GUI Components Communication
  void notify(Component sender, String event);
  
  // GUI Manipulation
  
  // Board
  void addBoard();
  // void loadBoard();
  // void removeBoard();
  // void modifyBoardTitle();
  
  // Column
  // void addColumn(Board board);
  void removeColumn(Column column);
  void modifyColumnTitleLabel(ColumnTitleLabel columnTitleLabel);
  // void addItemButton()
  
  // Item
  // void addItem(Column column);
  // void removeItem(Item item);
  // void modifyItem(Item item);
}
