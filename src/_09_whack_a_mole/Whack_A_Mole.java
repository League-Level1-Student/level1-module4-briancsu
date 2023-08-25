package _09_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Whack_A_Mole implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton mole;
	int hit;
	int missed;
	Date currentTime;
	Random random = new Random();
	public void run () {
		currentTime = new Date();
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);
		frame.setTitle("Whack - A - Mole");
		int ran = new Random().nextInt(24);
		drawButtons(ran);
		frame.setSize(300, 325);
	}
	public void drawButtons(int num) {
		panel.removeAll();
		for(int i = 0; i < 24; i ++) {
			if(i == num) {
				mole = new JButton();
				mole.setText("MOLE");
				mole.addActionListener(this);
				panel.add(mole);
			}
			else {
				JButton button = new JButton();
				button.setText(" ");
				button.addActionListener(this);
				panel.add(button);
			}
		}
		frame.pack();
		frame.setSize(300, 325);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(mole)) {
			hit++;
			playSound("bell.wav");
			if(hit == 10) {
				endGame(currentTime, hit);
				System.exit(0);
			}
		}
		else {
			missed ++;
			if(missed == 1) {
				speak("Do better");
			}
			else if(missed == 2) {
				speak("Not twice!");
			}
			else if(missed == 3) {
				speak("You are doing worse");
			}
			else if(missed == 4) {
				speak("There is no hope");
			}
			else if(missed == 5) {
				speak("You are done");
				System.exit(0);
			}
			
		}

		drawButtons(random.nextInt(24));
	}
	private void playSound(String fileName) { 
	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	    sound.play();
	}
	 static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }
	 private void endGame(Date timeAtStart, int molesWhacked) { 
		    Date timeAtEnd = new Date();
		    JOptionPane.showMessageDialog(null, "Your whack rate is "
		            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
		                  + " moles per second.");
		}
}
