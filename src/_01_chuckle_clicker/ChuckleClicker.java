package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
JButton button1;
JButton button2;
	public void makeButtons() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setVisible(true);
		button1 = new JButton();
		button2 = new JButton();
		button1.setText("JOKE");
		button2.setText("PUNCHLINE");
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel.add(button1);
		panel.add(button2);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			JOptionPane.showMessageDialog(null, "Hello");
		}
		else if(e.getSource() == button2) {
			JOptionPane.showMessageDialog(null, "Hi");
		}

	}
}
