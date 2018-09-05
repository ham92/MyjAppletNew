package test;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JApplet;
import javax.swing.JFrame;
import sun.nio.cs.StandardCharsets;

public class AppletComm extends Applet implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	Button b;
	TextField tf;
	Label la;
	Button b2;

	public void init() {

		// setBackground(Color.blue);
		la = new Label("label");
		la.setBounds(50, 60, 150, 20);
		tf = new TextField();
		tf.setBounds(30, 40, 150, 20);
		b = new Button("Click");
		b2 = new Button("Click2");
		b.setBounds(80, 150, 70, 40);
		b2.setBounds(100, 200, 70, 40);
		add(b);
		add(b2);
		add(tf);
		add(la);

		b.addActionListener(new ButtonActionListener());
		b2.addActionListener(new ButtonActionListener2());
		// setLayout(null);

	}

	@Override
	public void run() {

		System.out.println(getCodeBase().getHost());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tf.setText("Welcome Hamzah");
	}

	class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String urlParameters = "param1=Mohammad&param2=Ali&param3=Abu-Odeh";
				byte[] postData = urlParameters.getBytes("UTF-8");
				int postDataLength = postData.length;
				String request = "http://localhost:8080/MyJApplet/Controller";
				URL url = new URL(request /* + "?" + urlParameters */ );
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setInstanceFollowRedirects(false);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setRequestProperty("charset", "utf-8");
				conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
				conn.setUseCaches(false);

				try {

					DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
					wr.write(postData);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				conn.connect();
				conn.getContentLength();
				System.out.println("Done..");// conn.getResponseCode());
			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				System.out.println("Exeption");
			}
		}
	}

	class ButtonActionListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				System.out.println("ded2");
				System.exit(0);

			} catch (Exception ee) {
				System.out.println(ee.getMessage());
				System.out.println("Exeption");
			}
		}
	}

}
