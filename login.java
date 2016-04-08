//package FootballStore;

import javax.swing.*;
//import javax.swing.text.MaskFormatter;
//import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
//import java.util.Arrays;

public class login implements ActionListener {
	// Declare all of the necessary objects.
	JFrame frame;
	JPanel panel;
	JButton Submit, Cancel;
	JLabel username, password;
	JTextField txtUsername, txtPassword;

	// Retrieve the resolution from the computer in order to display the Frame
	// at that resolution
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int WIDTH = gd.getDisplayMode().getWidth();
	int HEIGHT = gd.getDisplayMode().getHeight();

	public login() throws ParseException {

		// Create all of the necessary labels.
		username = new JLabel("Username:", JLabel.CENTER);
		password = new JLabel("Password:", JLabel.CENTER);

		// MaskFormatter phoneNumberFormat = new MaskFormatter("(###)
		// ###-####"); //format for the phone number
		// Create all of the necessary text fields.
		txtUsername = new JTextField(10);
		txtPassword = new JTextField(10);

		// create the layout of the panel.
		GridLayout layout = new GridLayout(0, 2);
		panel = new JPanel();
		panel.setLayout(layout);

		// Add the Labels and text fields to the panel.
		panel.add(username);
		panel.add(txtUsername);

		panel.add(password);
		panel.add(txtPassword);

		// Create the buttons and then add them to the panel.
		Submit = new JButton("Submit");
		Submit.addActionListener(this);
		panel.add(Submit, BorderLayout.SOUTH);

		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		panel.add(Cancel, BorderLayout.SOUTH);

		// Create the frame and add the panel to it.
		frame = new JFrame("first Gui");

		frame.add(panel, BorderLayout.CENTER);

		frame.pack();

		// Format the frame and then display it.
		frame.setSize(300, 300);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) {
			if (e.getSource() == Submit) {
				System.out.println("Submit was clicked");
				// verify();
			}
			if (e.getSource() == Cancel) {
				// System.out.println("Cancel was clicked");
				frame.dispose();
				try {
					new launchPage();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

}
