package com.perilousbooklet.kanban.gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import com.perilousbooklet.kanban.App;

/**
 * Sidebar
 */
public class SideBar extends JPanel{
  
  private static final FlowLayout sideBarLayout = new FlowLayout(FlowLayout.LEADING, App.flowMargin, App.flowMargin);
  
  public SideBar() {
    this.setBackground(ColorPalette.BACKGROUND2);
    this.setPreferredSize(App.panelSize);
    this.setLayout(sideBarLayout);
  }
  
}
