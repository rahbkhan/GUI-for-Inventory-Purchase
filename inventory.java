//package FootballStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;



public class inventory implements ActionListener {

	JFrame frame;
	JPanel panel;
	JPanel tablePanel;
	JPanel BottomPanel;
	JTable table;
	JLabel label;
	JButton add;
	JButton cancel;

	public inventory() throws ParseException {
		panel = new JPanel();
		// panel.setSize(100,500);

		panel.setLayout(new GridLayout());

		label = new JLabel("Inventory");
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// label.setSize(100, 100);
		label.setBackground(Color.RED);
		panel.add(label, BorderLayout.NORTH);

		tablePanel = new JPanel();
		// tablePanel.setSize(150,500);
		panel.setLayout(new GridLayout());

		table = new JTable(new inventoryTable());
		table.setPreferredScrollableViewportSize(new Dimension(450, 100));
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.getColumn("Quantity").setCellRenderer(new SpinnerRenderer());
	    table.getColumn("Quantity").setCellEditor(new SpinnerEditor());
		
		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		tablePanel.add(scrollPane, BorderLayout.CENTER);

		BottomPanel = new JPanel();
		// BottomPanel.setSize(100, 500);
		// BottomPanel.setLayout(new GridLayout());

		add = new JButton("ADD");
		add.addActionListener(this);
		add.setSize(new Dimension(25, 25));
		BottomPanel.add(add, BorderLayout.EAST);

		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setSize(25, 25);
		BottomPanel.add(cancel, BorderLayout.WEST);

		frame = new JFrame("Inventory Page");

		frame.add(panel, BorderLayout.NORTH);
		frame.add(tablePanel, BorderLayout.NORTH);
		frame.add(BottomPanel, BorderLayout.SOUTH);

		frame.pack();

		// Format the frame and then display it.
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(0, 1));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) {
			if (e.getSource() == add) {
				System.out.println("ADD was clicked");
			}
			if (e.getSource() == cancel) {

				try {
					frame.dispose();
					new launchPage();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
