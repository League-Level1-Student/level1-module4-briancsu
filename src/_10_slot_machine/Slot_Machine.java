package _10_slot_machine;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slot_Machine implements ActionListener {
	JButton button;
	JLabel [] labels = new JLabel[3];
	ImageIcon slot1;
	ImageIcon slot2;
	ImageIcon slot3;
	JPanel panel;
	JFrame frame;
	public void run() {
		slot1 = new ImageIcon ("src/_10_slot_machine/slot1.jpeg");
		slot2 = new ImageIcon ("src/_10_slot_machine/slot2.jpeg");
		slot3 = new ImageIcon ("src/_10_slot_machine/slot3.jpeg");
		
		frame= new JFrame();
		panel = new JPanel();
		button = new JButton();
		frame.setVisible(true);
		frame.add(panel);
		for(int i = 0; i < 3; i++) {
			labels[i] = new JLabel(slot1);
			panel.add(labels[i]);
		}
		
		
		panel.add(button);
		button.addActionListener(this);
		frame.pack();
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			reroll();
			if(labels[0].getIcon().equals(labels[1].getIcon()) && labels[2].getIcon().equals(labels[1].getIcon()) ) {
				JOptionPane.showMessageDialog(null, "YOU WIN");
			}
	}
	public void reroll() {
		Random ran = new Random();
		for(int i = 0; i < labels.length; i ++) {
			
			int random = ran.nextInt(3);
			if(random == 0) {
				labels[i].setIcon(slot1);
			}
			else if(random == 1) {
				labels[i].setIcon(slot2);
			}
			else if(random == 2) {
				labels[i].setIcon(slot3);
			}
		}
	}
	
    
}
