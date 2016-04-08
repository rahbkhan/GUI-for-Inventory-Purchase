//package FootballStore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;

//import java.util.logging.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class launchPage implements ActionListener {

	JFrame frame;
	JPanel panel;
	JButton Login, Register, viewInventory;
	JLabel welcome;

	public launchPage() throws ParseException {

		panel = new JPanel();
		panel.setSize(300, 300);
		panel.setLayout(new GridLayout(0, 1, 10, 20));

		welcome = new JLabel("Welcome");
		welcome.setFont(new Font("Serif", Font.BOLD, 22));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(welcome, BorderLayout.CENTER);

		Login = new JButton("Login");
		Login.addActionListener(this);
		panel.add(Login, BorderLayout.SOUTH);

		Register = new JButton("Register");
		Register.addActionListener(this);
		panel.add(Register, BorderLayout.SOUTH);

		viewInventory = new JButton("View Inventory");
		viewInventory.addActionListener(this);
		panel.add(viewInventory, BorderLayout.SOUTH);

		// Create the frame and add the panel to it.
		frame = new JFrame("Launch Page");

		frame.add(panel);
		frame.pack();

		// Format the frame and then display it.
		frame.setSize(300, 300);
		frame.setLayout(new GridLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) {
			if (e.getSource() == Login) {
				try {
					frame.dispose();
					new login();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == Register) {

				try {
					frame.dispose();
					new register();
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == viewInventory) {
				try {
					frame.dispose();
					new inventory();

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}
}
