package gui;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import main.Main;

public class TopBar extends JPanel{
  
  private static final GridBagLayout layoutTopBar = new GridBagLayout();

  public TopBar() {
    this.setBackground(ColorPalette.BACKGROUND3);
    this.setPreferredSize(Main.panelSize);
    this.setLayout(layoutTopBar);
  }
  
}
