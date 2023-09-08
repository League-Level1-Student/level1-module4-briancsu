package _99_extra._01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySuprise implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		button1 = new JButton();
		button2 = new JButton();
		panel.add(button1);
		panel.add(button2);
		button1.setText("Treat");
		button2.setText("Trick");
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			showPictureFromTheInternet("https://www.the-sun.com/wp-content/uploads/sites/6/2022/11/OFF-LI-SKULL.jpg?w=620");
		}
		else if(e.getSource() == button2){
			showPictureFromTheInternet("https://www.daysoftheyear.com/cdn-cgi/image/dpr=1%2Cf=auto%2Cfit=cover%2Cheight=465%2Cq=70%2Csharpen=1%2Cwidth=1000/wp-content/uploads/puppy-day-e1574071869348.jpg");
		}
	}
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
}
