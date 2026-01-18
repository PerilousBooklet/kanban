package gui;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Main;

/**
 * Item
 */
public class Item extends JPanel {
	
	// Logger
	private static final Logger logger = Logger.getLogger(Item.class.getName());
	
	// Item content
	private String text = "";

	// Word wrap logic
	// TODO: check for excessive word length and split word
	private List<String> wrapText(Graphics g, String text, int maxWidth) {
		FontMetrics fm = g.getFontMetrics();
		List<String> lines = new ArrayList<>();
		String[] words = text.split(" ");
		StringBuilder line = new StringBuilder();
		for (String word : words) { 
			if (fm.stringWidth(line + word) < maxWidth) {
				if (line.length() > 0) {
					line.append(" ");
				}
				line.append(word);
			} else {
				lines.add(line.toString());
				line = new StringBuilder(word);
			}
		}
		lines.add(line.toString());
		return lines;
	}
	
	// How to draw the text on the Item
	// TODO: extend Item height to fit text
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		// Enable text anti-aliasing
    g2d.setRenderingHint(
    	RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_ON
		);
    g2d.setRenderingHint(
    	RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON
		);
		
		g2d.setFont(Main.mainFont);
		
		int panelWidth = this.getWidth();
		int x = 20;
		int y = 25;
		List<String> lines = wrapText(g2d, Item.this.text, panelWidth - 2 * x);
		for (String line : lines) {
			g2d.drawString(line, x, y);
			y += g2d.getFontMetrics().getHeight();
		}
	}
	
	// Item text access methods
	public String getItemText() {
		return this.text;
	}
	public void setItemText(String text) {
		this.text = text;
	}
	
	// Unsupported Characters Check
	public static boolean isValidInput(String input) {
    return input.matches("[a-zA-Z0-9:,.\"\'?! ]+");
	}
	
	/**
	 * Item constructor
	 */
	public Item(String text, Column column) {
		
		// Item properties
		this.setBackground(ColorPalette.BACKGROUND4);
    this.setPreferredSize(new Dimension(Column.columnSize.width - 20, 100));
		
		// When clicking on an Item instance
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Get mouse cursor position
    	  Point clickPosition = e.getPoint();
    	  // Check if the mouse cursor has clicked inside the Item instance
    	  if (Item.this.contains(clickPosition)) {
          // When clicking with the left mouse button (BUTTON1): modify the Item instance's text
          if (e.getButton() == MouseEvent.BUTTON1) {
    	      // Ask for new text and set Item instance text
    	      // Check for unsupported characters in the input text
    	      try {
						  String currentText = Item.this.text;
						  String input = (String)JOptionPane.showInputDialog(Main.frame, "New text here...", currentText);
						  // input must be not-null and valid
						  if (input != null && isValidInput(input)) {
							  Item.this.setItemText(input);
						  } else {
							  logger.warning("Invalid input provided!");
						  }
    	      } catch (Exception ex) {
    	    	  ex.printStackTrace();
    	      }
    	      logger.info("Item text: " + Item.this.text);
    	      // Redraw Item instance
    	      Item.this.revalidate();
    	      Item.this.repaint();
          }
          // When clicking with the right mouse button (BUTTON3): delete the Item instance
          if (e.getButton() == MouseEvent.BUTTON3) {
            // Confirm deletion
            Object[] options = { "Yes", "No" };
            int n = JOptionPane.showOptionDialog(
							Item.this, 
							"Delete this Item?", 
							"Warning", 
							JOptionPane.DEFAULT_OPTION, 
							JOptionPane.WARNING_MESSAGE, 
							null, 
							options, 
							options[0]
						);
            // Delete the Item instance
            if (n == 0) {
            	column.getColumnContent().remove(Item.this);
            	column.revalidate();
							column.repaint();
            	logger.info("Item deleted");
            }
          }
    	  }
			}
		});
	}
	
}
