package logic;

import gui.AddColumnButton;
import gui.Board;

public class AddColumnButtonFactory {
  
  public AddColumnButton createAddColumnButton(Board board) {
    return new AddColumnButton(board);
  }
  
}
