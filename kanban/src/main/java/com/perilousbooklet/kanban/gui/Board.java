package com.perilousbooklet.kanban.gui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.perilousbooklet.kanban.App;

/**
 * Board
 */
public class Board extends JPanel{

	// Board Components
	public static JLabel boardTitle = new JLabel("Board 1");
	private static final FlowLayout layoutBoard = new FlowLayout(FlowLayout.LEADING, App.flowMargin, App.flowMargin);
	
	public Board() {
	  // Board Properties
	  this.setBackground(ColorPalette.BACKGROUND1);
    this.setPreferredSize(App.panelSize);
    this.setLayout(layoutBoard);
    // Board Title Properties
    boardTitle.setVerticalAlignment(JLabel.CENTER);
    boardTitle.setFont(new Font("Serif", Font.PLAIN, 20));
    boardTitle.setForeground(ColorPalette.FOREGROUND1);
	}
	
}
