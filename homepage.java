//package FootballStore;

import java.awt.*;
import javax.swing.*;
import java.io.*;
//import java.util.logging.*;
import javax.imageio.*;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class homepage {
	JFrame frame;
	JPanel panel;
	JLabel label;
	private Image image;
	ImageIcon thisImage;
	

	public homepage() {
		GridLayout layout = new GridLayout(0, 2);
		panel = new JPanel();
		panel.setLayout(layout);

		try {
			image = ImageIO.read(homepage.class.getResource("Coupon.jpg"));

		} catch (IOException ex) {
			// handle exception...
		}

		label = new JLabel();
		label.setLayout(layout);

		thisImage = new ImageIcon(image);

		
		label.setIcon(new ImageIcon(image));

		panel.add(label);

		frame = new JFrame("Home Page!");
		frame.add(panel);
		frame.pack();

		frame.setSize(300, 300);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
