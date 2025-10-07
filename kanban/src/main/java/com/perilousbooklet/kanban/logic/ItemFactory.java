package com.perilousbooklet.kanban.logic;

import com.perilousbooklet.kanban.gui.Column;
import com.perilousbooklet.kanban.gui.Item;

/**
 * ItemFactory
 */
public class ItemFactory {
	
	public Item createItem(String string, Column column) {
		return new Item(string, column);
	}
	
}
