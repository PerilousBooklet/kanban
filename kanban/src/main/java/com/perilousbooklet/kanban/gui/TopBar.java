package com.perilousbooklet.kanban.gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.perilousbooklet.kanban.App;

/**
 * Topbar
 */
public class TopBar extends JPanel{
  
  private static final GridBagLayout layoutTopBar = new GridBagLayout();

  public TopBar() {
    this.setBackground(ColorPalette.BACKGROUND3);
    this.setPreferredSize(App.panelSize);
    this.setLayout(layoutTopBar);
  }
  
}
