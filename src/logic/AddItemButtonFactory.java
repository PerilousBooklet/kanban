package logic;

import gui.AddItemButton;
import gui.Column;

public class AddItemButtonFactory {
  
  public AddItemButton createAddItemButton(Column column) {
    return new AddItemButton(column);
  }
  
}
