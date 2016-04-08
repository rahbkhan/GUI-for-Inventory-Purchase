//package FootballStore;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class inventoryTable extends AbstractTableModel {
	private boolean DEBUG = false;

	DecimalFormat df = new DecimalFormat("#.00");
	
	public String[] columnNames = { "Product", "Price($)", "Quantity" };
	private Object[][] data = {
			{ "Under Armour Spikes",  df.format(new Double(100)), new SpinnerNumberModel(0, 0, 20, 1) }, 
			{ "Nike Spikes", df.format(new Double(100)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Under Armour Gloves",  df.format(new Double(20)), new SpinnerNumberModel(0, 0, 20, 1) }, 
			{ "Nike Gloves",  df.format(new Double(20)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Under Armour Jersey", df.format(new Double(50)), new SpinnerNumberModel(0, 0, 20, 1) }, 
			{ "Nike Jersey",  df.format(new Double(50)), new SpinnerNumberModel(0, 0, 20, 1) }, 
			{ "Under Armour Pants",  df.format(new Double(40)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Nike Pants",  df.format(new Double(40)), new SpinnerNumberModel(0, 0, 20, 1) }, 
			{ "Under Armour Pads",  df.format(new Double(150)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Nike Pads",  df.format(new Double(150)), new SpinnerNumberModel(0, 0, 20, 1) },	
			{ "Under Armour Helmets",  df.format(new Double(90)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Nike Helmets",  df.format(new Double(90)), new SpinnerNumberModel(0, 0, 20, 1) },	
			{ "Under Armour Socks",  df.format(new Double(10)), new SpinnerNumberModel(0, 0, 20, 1) },	
			{ "Nike Socks",  df.format(new Double(10)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Under Armour Mouthpiece",  df.format(new Double(15)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Nike Mouthpiece",  df.format(new Double(15)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Under Armour Football",  df.format(new Double(35)), new SpinnerNumberModel(0, 0, 20, 1) },
			{ "Nike Football",  df.format(new Double(35)), new SpinnerNumberModel(0, 0, 20, 1) }	
			
		};

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void setValueAt(Object value, int row, int col) {

		if (DEBUG) {
			System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of "
					+ value.getClass() + ")");
		}

		data[row][col] = value;
		// fireTableCellUpdated(row, col);

		if (DEBUG) {
			System.out.println("New value of data:");
			printDebugData();
		}
	}

	private void printDebugData() {
		int numRows = getRowCount();
		int numCols = getColumnCount();

		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + data[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

}

class SpinnerRenderer extends JSpinner implements TableCellRenderer {
	public SpinnerRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setModel((SpinnerModel) value);
		return this;
	}
}

class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
	protected JSpinner spinner;

	public SpinnerEditor() {
		spinner = new JSpinner();
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		spinner.setModel((SpinnerModel) value);

		return spinner;
	}

	public Object getCellEditorValue() {
		SpinnerModel sm = spinner.getModel();
		return sm;
	}
}