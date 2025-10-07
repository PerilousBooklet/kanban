package com.perilousbooklet.kanban.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.perilousbooklet.kanban.App;
import com.perilousbooklet.kanban.logic.ColumnFactory;

public class AddColumnButton extends AddButton {
  
  // Logger
	private static final Logger logger = Logger.getLogger(AddButton.class.getName());
	
	// Unsupported Characters Check
	public boolean isValidInput(String input) {
    return input.matches("[a-zA-Z0-9 ]+");
	}
  
  public AddColumnButton(Board board) {
    super();
    // When the button is pressed
    this.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	  ColumnFactory columnFactory = new ColumnFactory();
				try {
					String columnTitleText = (String)JOptionPane.showInputDialog(App.frame, "Choose a title: ");
					if (columnTitleText != null && isValidInput(columnTitleText)) {
						logger.info("Column title: " + columnTitleText);
						board.add(columnFactory.createColumn(columnTitleText, board));
						logger.info("AddButton created and added to column.");
						board.revalidate();
						board.repaint();
						// Ensure the + button stays at the bottom of the FlowLayout
						board.remove(board.getAddColumnButton());
						board.add(board.getAddColumnButton());
						logger.info("AddButton repositioned at the right of the board.");
						board.revalidate();
						board.repaint();
					} else {
						logger.warning("Invalid input provided!");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
      }
    });
    
  }
  
}
