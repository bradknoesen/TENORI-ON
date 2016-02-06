import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//code goes here
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnL_1 = new JButton("L1");
		btnL_1.setBounds(10, 72, 45, 25);
		frame.getContentPane().add(btnL_1);
		
		JButton btnL_2 = new JButton("L2");
		btnL_2.setBounds(10, 112, 45, 25);
		frame.getContentPane().add(btnL_2);
		
		JButton btnL_3 = new JButton("L3");
		btnL_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnL_3.setBounds(10, 152, 45, 25);
		frame.getContentPane().add(btnL_3);
		
		JButton btnL_4 = new JButton("L4");
		btnL_4.setBounds(10, 192, 45, 25);
		frame.getContentPane().add(btnL_4);
		
		JButton btnOn = new JButton("ON");
		btnOn.setBounds(190, 11, 50, 25);
		frame.getContentPane().add(btnOn);
		
		JButton btnR_1 = new JButton("R1");
		btnR_1.setBounds(380, 72, 45, 25);
		frame.getContentPane().add(btnR_1);
		
		JButton btnR_2 = new JButton("R2");
		btnR_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnR_2.setBounds(380, 112, 45, 25);
		frame.getContentPane().add(btnR_2);
		
		JButton btnR_3 = new JButton("R3");
		btnR_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnR_3.setBounds(380, 152, 45, 25);
		frame.getContentPane().add(btnR_3);
		
		JButton btnR_4 = new JButton("R4");
		btnR_4.setBounds(380, 192, 45, 25);
		frame.getContentPane().add(btnR_4);
		
		JButton button = new JButton("");
		button.setBounds(65, 50, 15, 15);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(90, 50, 15, 15);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(115, 50, 15, 15);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(140, 50, 15, 15);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(165, 50, 15, 15);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(190, 50, 15, 15);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(215, 50, 15, 15);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(240, 50, 15, 15);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBounds(265, 50, 15, 15);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setBounds(290, 50, 15, 15);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBounds(315, 50, 15, 15);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setBounds(337, 50, 15, 15);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setBounds(360, 50, 15, 15);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setBounds(380, 50, -134, 103);
		frame.getContentPane().add(button_13);
	}
}
