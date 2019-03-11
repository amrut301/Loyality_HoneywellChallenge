package com.loyality.bo.constants;

/**
 * @author amrmalaj
 *
 */
public enum CategoryType {
	
	MEN(1), WOMEN(2), UNISEX(3), CLOTHES(4), ACCESSORIES(5), ELECTRONICS(6);
	int priority;
	private CategoryType(int priority) {
	this.priority=priority;
	}
	public int getPriority() {
		return priority;
	}
}
