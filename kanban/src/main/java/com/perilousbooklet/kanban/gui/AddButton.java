package com.perilousbooklet.kanban.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
		
	}
}
