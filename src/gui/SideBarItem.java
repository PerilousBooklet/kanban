package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import main.Main;

public class SideBarItem extends JPanel {
  
  public SideBarItem() {
    
    // SideBarItem Properties
    this.setBackground(ColorPalette.BACKGROUND4);
    this.setPreferredSize(new Dimension(30, 30));
    
    // When the mouse cursor presses a Board's SideBarItem
    this.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    	  // Get mouse cursor position
    	  Point clickPosition = e.getPoint();
    	  // Check if the mouse cursor has clicked inside the SideBarItem
    	  if (Main.sidebarItem.contains(clickPosition)) {
    	    System.out.println("Mouse clicked inside the " + Main.sidebarItem.getName() + " panel at: " + clickPosition);
    	    // TODO: check for current Board
    	    // TODO: load something in the panelBoard
					// FIX: load correspondent board after click on correspondent sidebaritem instance
    	  }
    	}
    });
    
  }
  
}
