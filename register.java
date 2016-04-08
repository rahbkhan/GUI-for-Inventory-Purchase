//package FootballStore;

import javax.swing.*;
//import javax.swing.text.MaskFormatter;
//import javax.swing.text.MaskFormatter;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Formatter;
//import java.util.Arrays;

public class register implements ActionListener {
	// Declare all of the necessary objects.
	JFrame frame;
	JPanel panel;
	JButton Submit, Cancel;
	JLabel firstName, lastName, email, phoneNumber, address, userName, password, password2;
	JTextField txtFirstName, txtLastName, txtEmail, txtPhoneNumber, txtAddress, txtuserName, txtPassword, txtPassword2;

	// Retrieve the resolution from the computer in order to display the Frame
	// at that resolution
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int WIDTH = gd.getDisplayMode().getWidth();
	int HEIGHT = gd.getDisplayMode().getHeight();

	public register() throws ParseException {

		// Create all of the necessary labels.
		firstName = new JLabel("First Name:");
		lastName = new JLabel("Last Name:");
		email = new JLabel("Email:");
		userName = new JLabel("Username:");
		password = new JLabel("Password: ");
		password2 = new JLabel("Reenter password: ");
		phoneNumber = new JLabel("Phone Number:");
		address = new JLabel("Address:");

		
		// Create all of the necessary text fields.
		txtFirstName = new JTextField(10);
		txtLastName = new JTextField(10);
		txtEmail = new JTextField(10);
		txtuserName = new JTextField(10);
		txtPassword = new JPasswordField(10);
		txtPassword2 = new JPasswordField(10);

		// txtPhoneNumber = new JTextField(10);
		txtPhoneNumber = new JTextField(10);
		txtAddress = new JTextField(10);

		// create the layout of the panel.
		GridLayout layout = new GridLayout(0, 2);
		panel = new JPanel();
		panel.setLayout(layout);

		// Add the Labels and text fields to the panel.
		panel.add(firstName);
		panel.add(txtFirstName);

		panel.add(lastName);
		panel.add(txtLastName);

		panel.add(email);
		panel.add(txtEmail);

		panel.add(userName);
		panel.add(txtuserName);

		panel.add(password);
		panel.add(txtPassword);
		

		panel.add(password2);
		panel.add(txtPassword2);
		
		
		panel.add(phoneNumber);
		panel.add(txtPhoneNumber);

		panel.add(address);
		panel.add(txtAddress);

		// Create the buttons and then add them to the panel.
		Submit = new JButton("Submit");
		Submit.addActionListener(this);
		panel.add(Submit, BorderLayout.SOUTH);

		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		panel.add(Cancel, BorderLayout.SOUTH);

		// Create the frame and add the panel to it.
		frame = new JFrame("first Gui");

		frame.add(panel);
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
				verify();
				
			}
			if (e.getSource() == Cancel) {
				// verify();
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

	void verify() {

		String EmailPattern = "[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}";
		if ((txtFirstName.getText().matches("[a-zA-Z ]+") == false)
				 || (txtLastName.getText().matches("[a-zA-Z ]+") == false)) {
			clear();
		} else if (txtEmail.getText().matches(EmailPattern) == false) {
			
			clear();
		} else if (txtPhoneNumber.getText().matches("[0-9]+") == false || txtPhoneNumber.getText().length() != 10) {
			
			clear();
		} else if (txtPassword.getText().equals(txtPassword2)) {
			
			clear();
		}
	}

	void clear() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtEmail.setText("");
		txtPhoneNumber.setText("");
		txtAddress.setText("");
		txtuserName.setText("");
		txtPassword.setText("");
		txtPassword2.setText("");
	}

}
