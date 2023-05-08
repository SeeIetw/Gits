package tw.org.iii.myclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class FoodDB {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_QUERT = "SELECT * FROM food";
	
	private Connection conn;
	private ResultSet rs;
	private String[] fieldNames;
	public FoodDB() throws SQLException{
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		conn = DriverManager.getConnection(url, prop);
	}
	public void queryData(String sql) throws SQLException {
		if(sql==null) {sql = SQL_QUERT;}
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for(int i=0;i<fieldNames.length;i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
		}
		
	}
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public int getColumns() {
		return fieldNames.length;
	}
	//row, col are 1-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row);
			return rs.getString(fieldNames[col-1]);
			
		} catch (Exception e) {
			return "X";
		}
	}
	public void updateData(int row, int col, String avalue) {
		try {
			rs.absolute(row);
			rs.updateString(fieldNames[col-1], avalue);
			rs.updateRow();
		} catch (Exception e) {
			System.out.println("Update failed");
		}
	}
	public String[] getHeader() {
		return fieldNames;
	}
	//1-base
	public void delRow(int row) {
		try {
			rs.absolute(row);
			rs.deleteRow();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
