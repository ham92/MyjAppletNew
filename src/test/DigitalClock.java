package test;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DigitalClock extends Applet implements Runnable {

	Thread t = null;
	int hours = 0, minutes = 0, seconds = 0;
	String timeString = "";

	public void init() {
		setBackground(Color.green);
	}

	public void start() {
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			while (true) {

				Calendar cal = Calendar.getInstance();
				hours = cal.get(Calendar.HOUR_OF_DAY);
				if (hours > 12)
					hours -= 12;
				
				minutes = cal.get(Calendar.MINUTE);
				seconds = cal.get(Calendar.SECOND);

				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
				Date date = cal.getTime();
				timeString = formatter.format(date);

				repaint();
			
				t.sleep(1000); // interval given in milliseconds
			
			}
		} catch (Exception e) {
		}
	}

	public void paint(Graphics g) {

		g.setColor(Color.blue);
		g.drawString(timeString, 50, 50);
		g.drawLine(20,20, 70, 77);
		t.suspend();
		 
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		t.resume();
	}
}