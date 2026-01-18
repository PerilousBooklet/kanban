package gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import main.Main;

/**
 * Sidebar
 */
public class SideBar extends JPanel{
  
  private static final FlowLayout sideBarLayout = new FlowLayout(FlowLayout.LEADING, Main.panelGap, Main.panelGap);
  
  public SideBar() {
    this.setBackground(ColorPalette.BACKGROUND2);
    this.setPreferredSize(Main.panelSize);
    this.setLayout(sideBarLayout);
  }
  
}
