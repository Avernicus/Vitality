package org.cyberpwn.vitality.util;

/**
 * Colored circle spinner
 * 
 * @author cyberpwn
 */
public class PhantomSpinner
{
	private ProgressSpinner s;
	private ProgressSpinner c;
	
	public PhantomSpinner()
	{
		s = new ProgressSpinner();
		c = new ProgressSpinner(C.LIGHT_PURPLE.toString(), C.LIGHT_PURPLE.toString(), C.LIGHT_PURPLE.toString(), C.DARK_PURPLE.toString(), C.DARK_GRAY.toString(), C.DARK_GRAY.toString(), C.DARK_GRAY.toString(), C.DARK_PURPLE.toString());
	}
	
	public String toString()
	{
		return c.toString() + s.toString();
	}
}
