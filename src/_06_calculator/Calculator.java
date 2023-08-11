package _06_calculator;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements MouseListener {
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JTextField text_1;
	JTextField text_2;
	int text1;
	int text2;
	JLabel label;
	public int add(int num1, int num2) {
		return (num1 + num2);
	}
	public int subtract(int num1, int num2) {
		return (num1 - num2);
	}
	public int multiply(int num1, int num2) {
		return (num1 * num2);
	}
	public int divide(int num1, int num2) {
		return (num1 / num2);
	}
	public void run() {
		JFrame frame = new JFrame();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		label = new JLabel();
		JPanel panel = new JPanel();
		text_1 = new JTextField(10);
		text_2 = new JTextField(10);
		frame.setVisible(true);
		frame.add(panel);
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);
		button1.setText("Add");
		button2.setText("Subtract");
		button3.setText("Multiply");
		button4.setText("Divide");
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(text_1);
		panel.add(text_2);
		text1 = Integer.parseInt(text_1.getText());
		text2 = Integer.parseInt(text_2.getText());
		
		frame.pack();
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == button1) {
			label.setText(add(text1, text2) + "");
		}
		else if(buttonPressed == button2) {
			label.setText(subtract(text1, text2) + "");
		}
		else if(buttonPressed == button3) {
			label.setText(multiply(text1, text2) + "");
		}
		else if(buttonPressed == button4) {
			label.setText(divide(text1, text2) + "");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
