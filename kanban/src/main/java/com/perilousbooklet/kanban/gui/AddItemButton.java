package com.perilousbooklet.kanban.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import com.perilousbooklet.kanban.logic.ItemFactory;

public class AddItemButton extends AddButton {

	// Logger
	private static final Logger logger = Logger.getLogger(AddItemButton.class.getName());
  
  /**
   * Constructor
   */
  public AddItemButton(Column column) {
    super();
    
    // When the button is pressed
    this.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
          logger.info("AddItemButton pressed.");
          // Create a new Item and reload the JPanel
					ItemFactory itemFactory = new ItemFactory();
					Item newItem = itemFactory.createItem("", column);
					// Check if the Item is null
					if (newItem != null) {
            column.getColumnContent().add(newItem);
            logger.info("Item created and added to column.");
					} else {
						logger.warning("Item creation failed. Item is null.");
					}
					// Reload column
					column.revalidate();
					column.repaint();
					// Ensure the + button stays at the bottom of the FlowLayout
					column.getColumnContent().remove(AddItemButton.this);
					column.getColumnContent().add(AddItemButton.this);
					logger.info("AddItemButton repositioned at the bottom of the column.");
					column.revalidate();
					column.repaint();
    	}
    });
    
  }
  
}
