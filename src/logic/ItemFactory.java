package logic;

import gui.Column;
import gui.Item;

/**
 * ItemFactory
 */
public class ItemFactory {
	
	public Item createItem(String string, Column column) {
		return new Item(string, column);
	}
	
}
