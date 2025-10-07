package com.perilousbooklet.kanban.gui;

import java.awt.Font;

import javax.swing.JLabel;

public class ColumnTitleLabel extends JLabel {
  
  public static final Font titleFont = new Font("Serif", Font.PLAIN, 20);
  private String text;
  
  public ColumnTitleLabel(String text) {
    this.text = text;
    this.setFont(titleFont);
    this.setForeground(ColorPalette.FOREGROUND2);
    this.setText(text);
  }

  // ?
  public String getText() {
    return this.text;
  }
  public void setText(String text) {
    this.text = text;
  }
  
}
