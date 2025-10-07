package com.perilousbooklet.kanban.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.UUID;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.perilousbooklet.kanban.App;
import com.perilousbooklet.kanban.logic.AddColumnButtonFactory;

/**
 * Board
 */
public class Board extends JPanel{
  
  // ?
  public static JLabel boardTitle = new JLabel("Board 1");
  AddColumnButton addColumnButton;
  
  /**
	 * Default constructor
	 */
  public Board() {
    
    // Board Properties
    FlowLayout layoutBoard = new FlowLayout(FlowLayout.LEADING, App.flowMargin, App.flowMargin);
    
    boardTitle.setVerticalAlignment(JLabel.CENTER);
    boardTitle.setFont(new Font("Serif", Font.PLAIN, 20));
    boardTitle.setForeground(ColorPalette.FOREGROUND1);
    
    this.setBackground(ColorPalette.BACKGROUND1);
    this.setPreferredSize(App.panelSize);
    this.setLayout(layoutBoard);
    this.setName("board-" + UUID.randomUUID().toString());
    
    // Board components
    AddColumnButtonFactory addColumnButtonFactory = new AddColumnButtonFactory();
    addColumnButton = addColumnButtonFactory.createAddColumnButton(Board.this);
    
    // Assemble the components
    this.add(addColumnButton);
  }
  
  // ?
  public AddColumnButton getAddColumnButton() {
    return this.addColumnButton;
  }
  
}
