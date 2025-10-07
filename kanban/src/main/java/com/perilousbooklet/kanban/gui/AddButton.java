package com.perilousbooklet.kanban.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.perilousbooklet.kanban.App;
import com.perilousbooklet.kanban.logic.BoardFactory;
import com.perilousbooklet.kanban.logic.ColumnFactory;
import com.perilousbooklet.kanban.logic.SideBarItemFactory;

/**
 * Button
 */
public class AddButton extends JButton {

	// Logger
	private static final Logger logger = Logger.getLogger(AddButton.class.getName());
	
	// Utility resize method for the + icon
	private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
	}

	// Unsupported Characters Check
	public boolean isValidInput(String input) {
    return input.matches("[a-zA-Z0-9 ]+");
	}
	
	/**
	 * Constructor
	 */
	public AddButton() {
		
		// Properties
		this.setPreferredSize(new Dimension(30,30));
    this.setOpaque(false);
    this.setBorderPainted(false);
    this.setBackground(Color.WHITE);
    
		// Icon
		// TODO: try/catch if image exists
		String iconFilePath = "/com/perilousbooklet/kanban/resources/add.jpg";
		ImageIcon addButtonIcon = new ImageIcon(this.getClass().getResource(iconFilePath));
		logger.info("Loaded AddButton icon from " + iconFilePath);
		this.setIcon(resizeIcon(addButtonIcon, 30, 30));
		
		// TODO: refactor to AddBoardButton
		// TODO: refactor to AddColumnButton
		// When a + button is pressed
    this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add a board
				if (e.getSource() == App.addBoardButton) {
					// TODO: check for invalid input (like for the Column below)
					SideBarItemFactory sidebarItemFactory = new SideBarItemFactory();
					App.panelSideBar.add(sidebarItemFactory.createSideBarItem());
					logger.info("SideBarItem added.");
					App.panelSideBar.revalidate();
					App.panelSideBar.repaint();
					BoardFactory boardFactory = new BoardFactory();
					App.frame.add(boardFactory.createBoard(), BorderLayout.CENTER);
					logger.info("Board added.");
					App.frame.revalidate();
					App.frame.repaint();
					// Ensure the + button stays at the bottom of the FlowLayout
					App.panelSideBar.remove(App.addBoardButton);
					App.panelSideBar.add(App.addBoardButton);
					App.panelSideBar.revalidate();
					App.panelSideBar.repaint();
				}
				// Add a column
				if (e.getSource() == App.addColumnButton) {
					ColumnFactory columnFactory = new ColumnFactory();
					try {
						String inputDialogText = (String)JOptionPane.showInputDialog(App.frame, "Choose a title: ");
						if (inputDialogText != null && isValidInput(inputDialogText)) {
							logger.info("Column title: " + inputDialogText);
							// TODO: check for current Board
							App.panelBoard.add(columnFactory.createColumn(inputDialogText));
							logger.info("AddButton created and added to column.");
							App.panelBoard.revalidate();
							App.panelBoard.repaint();
							// Ensure the + button stays at the bottom of the FlowLayout
							App.panelBoard.remove(App.addColumnButton);
							App.panelBoard.add(App.addColumnButton);
							logger.info("AddButton repositioned at the right of the board.");
							App.panelBoard.revalidate();
							App.panelBoard.repaint();
						} else {
							logger.warning("Invalid input provided!");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
	}
}
