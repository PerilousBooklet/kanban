package com.perilousbooklet.kanban.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.perilousbooklet.kanban.App;
import com.perilousbooklet.kanban.logic.AddItemButtonFactory;

/**
 * Column
 */
public class Column extends JPanel {
  
	// FIX: make these two attributes private and access them with getters an setters
  public static final Font titleFont = new Font("Serif", Font.PLAIN, 20);
  public static final Dimension columnSize = new Dimension(300, App.appHeight - App.panelSize.height - App.flowMargin * 10);
  private JPanel columnContent;
	
	/**
	 * Default constructor
	 */
	public Column(String columnTitleText) {
    // Column components
    BorderLayout layoutColumn = new BorderLayout();
    GridBagLayout layoutColumnTitle = new GridBagLayout();
    FlowLayout layoutColumnContent = new FlowLayout(FlowLayout.LEADING, App.flowMargin, App.flowMargin);
    JPanel columnTitle = new JPanel();
    JLabel columnTitleLabel = new JLabel();
    columnContent = new JPanel();
		// Column properties
    this.setPreferredSize(columnSize);
    this.setLayout(layoutColumn);
		// Column title
		columnTitle.setBackground(ColorPalette.BACKGROUND2);
    columnTitle.setPreferredSize(new Dimension(columnSize.width - 20, 50));
    columnTitle.setLayout(layoutColumnTitle);
    columnTitleLabel.setFont(titleFont);
    columnTitleLabel.setForeground(ColorPalette.FOREGROUND2);
    columnTitleLabel.setText(columnTitleText);
		// Column content
		columnContent.setLayout(layoutColumnContent);
		columnContent.setBackground(ColorPalette.BACKGROUND5);

    // Assemble the components
    columnTitle.add(columnTitleLabel);
    this.add(columnTitle, BorderLayout.NORTH);
    this.add(columnContent, BorderLayout.CENTER);
    
    // Create AddItemButton
    AddItemButtonFactory addItemButtonFactory = new AddItemButtonFactory();
    columnContent.add(addItemButtonFactory.createAddItemButton(Column.this));
	}

	// Getter method to access columnContent
  public JPanel getColumnContent() {
    return columnContent;
  }
	
}
