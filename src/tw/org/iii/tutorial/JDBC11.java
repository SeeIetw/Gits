package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.json.JSONString;
import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC11 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/northwind";
	public static void main(String[] args) {
		String sql = 
				"select e.FirstName, e.LastName, sum(od.UnitPrice * od.Quantity) sum "
				+ "from orders o "
				+ "join employees e on (o.EmployeeID = e.EmployeeID) "
				+ "join orderdetails od on (o.OrderID = od.OrderID) "
				+ "GROUP by e.EmployeeID "
				+ "ORDER by sum desc";
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			JSONStringer js = new JSONStringer();
			JSONWriter jw = js.array();
			int rank =1;
			while(rs.next()) {
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("LastName");
				double sum = rs.getDouble("sum");
				
				js.object();
				jw.key("rank").value(rank++);
				jw.key("firstname").value(firstname);
				jw.key("lastname").value(lastname);
				jw.key("sum").value(sum);
				js.endObject();
			}
			jw.endArray();
			System.out.println(jw.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
