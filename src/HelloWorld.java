

import java.applet.Applet;
import java.awt.Graphics;

/*
<applet code="HelloWorld" width=200 height=60>
</applet>
*/

// HelloWorld class extends Applet
public class HelloWorld extends Applet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding paint() method
	@Override
	public void paint(Graphics g) 
	{
		g.drawString("Hello World, Ya Al-Welcome", 20, 20);
	}
	
}
