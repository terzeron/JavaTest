package net.terzeron.design_pattern;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator {  

	private ArrayList<MenuItem> menuItems;  

	private int position = 0;  

	public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {  
		this.menuItems = menuItems;  
	}  

	public boolean hasNext() {  
		if (position >= menuItems.size() || menuItems.get(position) == null) {
			return false;  
		} else {  
			return true;  
		}  
	}  

	public Object next() {  
		return menuItems.get(position++);
	}    
}  
