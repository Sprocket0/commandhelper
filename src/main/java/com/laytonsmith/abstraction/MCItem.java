
package com.laytonsmith.abstraction;

/**
 *
 * @author Layton
 */
public interface MCItem extends MCEntity {
	
	public MCItemStack getItemStack();
	public int getPickupDelay();
	public void setItemStack(MCItemStack stack);
	public void setPickupDelay(int delay);
}
