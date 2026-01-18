package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;
import java.util.logging.Logger;

import javax.swing.JPanel;

import main.Main;
import logic.AddItemButtonFactory;
import logic.MediatorGUI;

public class Column extends JPanel {
  
  // Logger
	private static final Logger logger = Logger.getLogger(MediatorGUI.class.getName());
  
  // ?
  public static Dimension columnSize = new Dimension(300, Main.appHeight - Main.panelSize.height - Main.panelGap * 10 + 30);
  private JPanel columnContent;
  private ColumnTitle columnTitle;
  
  // GUI Components Communication
  private MediatorGUI mediator;
	
	public Column(String columnTitleText, MediatorGUI mediator, Board board) {
    // GUI Components Communication
    this.mediator = mediator;
    
    // Column components
    BorderLayout layoutColumn = new BorderLayout();
    FlowLayout layoutColumnContent = new FlowLayout(FlowLayout.LEADING, Main.panelGap, Main.panelGap);
    columnTitle = new ColumnTitle(columnTitleText);
    columnContent = new JPanel();
		// Column properties
    this.setPreferredSize(columnSize);
    this.setLayout(layoutColumn);
    this.setName("column-" + UUID.randomUUID().toString());
		// Column content
		columnContent.setLayout(layoutColumnContent);
		columnContent.setBackground(ColorPalette.BACKGROUND5);
    
    // Assemble the components
    this.add(columnTitle, BorderLayout.NORTH);
    this.add(columnContent, BorderLayout.CENTER);
    
    // Create AddItemButton
    columnContent.add(new AddItemButtonFactory().createAddItemButton(Column.this));

    // When clicked, send a message to the mediator
    this.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    	  // Tell the mediator which specific Column is requesting manipulation
    	  mediator.setColumn(Column.this);
    	  mediator.setColumnTitleLabel(Column.this.columnTitle.columnTitleLabel);
    	  // Modify columnTitleLabel (left mouse button)
    	  if (e.getButton() == MouseEvent.BUTTON1) {
          mediator.notify(Column.this, "panelClickedLMB");
        }
        // Remove column (right mouse button)
        if (e.getButton() == MouseEvent.BUTTON3) {
          mediator.notify(Column.this, "panelClickedRMB");
        }
    	}
    });
	}
  
  public JPanel getColumnContent() {
    return columnContent;
  }
  
}
