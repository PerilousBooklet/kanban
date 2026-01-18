package gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import logic.Mediator;

public class ColumnTitle extends JPanel {
  
  private GridBagLayout layoutColumnTitle = new GridBagLayout();
  
  // GUI Components Communication
  private Mediator mediator;
  
  // ?
  ColumnTitleLabel columnTitleLabel;
  
  public ColumnTitle(String columnTitleText) {
    // Properties
    this.setBackground(ColorPalette.BACKGROUND2);
    this.setPreferredSize(new Dimension(Column.columnSize.width - 20, 50));
    this.setLayout(layoutColumnTitle);
    columnTitleLabel = new ColumnTitleLabel(columnTitleText);
    this.add(columnTitleLabel);
  }
  
}
