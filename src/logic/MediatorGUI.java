package logic;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import main.Main;
import gui.Board;
import gui.Column;
import gui.ColumnTitleLabel;
import gui.Item;

public class MediatorGUI implements Mediator {
  
  // GUI Components
  
  // Board
  private Board board;
  // Column
  private Column column;
  private ColumnTitleLabel columnTitleLabel;
  // Item
  private Item item;

  
  // Logger
	private static final Logger logger = Logger.getLogger(MediatorGUI.class.getName());

  
  // GUI Components Communication
  @Override
  public void notify(Component sender, String event) {
    // TODO: use the switch instead
    // Board
    if ( sender == Main.addBoardButton && "buttonClickedLMB".equals(event) ) {
      addBoard();
    }
    
    // Column
    if ( sender == column && "panelClickedLMB".equals(event) ) {
      modifyColumnTitleLabel(columnTitleLabel);
    }
    if ( sender == column && "panelClickedRMB".equals(event) ) {
      removeColumn(column);
    }
    
    // Item
    // ...
  }

  
  // ===========
  // == Board ==
  // ===========
  public void setBoard(Board board) {
    this.board = board;
  }
  @Override
  public void addBoard() {
		
  }

  
  // ============
  // == Column ==
  // ============
  public void setColumn(Column column) {
    this.column = column;
  }
  public void setColumnTitleLabel(ColumnTitleLabel columnTitleLabel) {
    this.columnTitleLabel = columnTitleLabel;
  }
  @Override
  public void modifyColumnTitleLabel(ColumnTitleLabel columnTitleLabel) {
    // Get ColumnTitleLabel text
    String currentText = columnTitleLabel.getText();
    String input = (String)JOptionPane.showInputDialog(column, "New text here...", currentText);
    // input must be not-null and valid
    if (input != null && Item.isValidInput(input)) {
      // Modify the text
      columnTitleLabel.setText(input);
      columnTitleLabel.revalidate();
      columnTitleLabel.repaint();
      logger.info("Modified ColumnTitleLabel of " + column.getClass().getName());
    } else {
      logger.warning("Invalid input provided!");
    }
  }
  @Override
  public void removeColumn(Column column) {
    // Get Board instance reference
    Board parentBoard = (Board)column.getParent();
    if (parentBoard == null) {
      logger.warning("Parent Board is null! Check the component hierarchy!");
    } else {
      logger.info("Parent Board name: " + parentBoard.getName());
      // Remove Column instance
      String[] options = { "Yes", "No" };
      int n = JOptionPane.showOptionDialog(column, "Delete this Column?", "Warning", JOptionPane.DEFAULT_OPTION, 
        JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			// Confirm deletion
			if (n == 0) {
			  parentBoard.remove(column);
        parentBoard.revalidate();
        parentBoard.repaint();
        logger.info("Removed " + column.getName());
			}
    }
  }

  
  // ==========
  // == Item ==
  // ==========
  public void setItem(Item item) {
    this.item = item;
  }
  
}
