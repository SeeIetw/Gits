package tw.org.iii.myclasses;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private FoodDB foodDB;
	private MyModel myModel;
	public MyTable() throws SQLException{
		foodDB = new FoodDB();
		foodDB.queryData(null);
		
		myModel = new MyModel();
		setModel(myModel); //integrate data
		myModel.setColumnIdentifiers(foodDB.getHeader());
		
	}
	public void delRow() {
		myModel.removeRow(getSelectedRow());
		repaint();
	}
	private class MyModel extends DefaultTableModel{
		
		@Override
		public void removeRow(int row) {
			super.removeRow(row);
			foodDB.delRow(row+1);
		}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return foodDB.getColumns();
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return foodDB.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDB.updateData(row+1, column+1, (String)aValue);
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return column > 0;
		}
		
	}
	
	
}
