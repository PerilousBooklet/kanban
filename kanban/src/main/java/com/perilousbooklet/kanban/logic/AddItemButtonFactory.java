package com.perilousbooklet.kanban.logic;

import com.perilousbooklet.kanban.gui.AddItemButton;
import com.perilousbooklet.kanban.gui.Column;

public class AddItemButtonFactory {
  
  public AddItemButton createAddItemButton(Column column) {
    return new AddItemButton(column);
  }
  
}
