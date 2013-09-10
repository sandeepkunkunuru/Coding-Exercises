package visualiq;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;


public class HiveJdbcClient {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive://192.168.0.106:10000/default", "", "");
		Statement stmt = con.createStatement();

		// show tables
		String tableName = "testHiveDriverTable";
		String sql = "show tables '" + tableName + "'";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		if (res.next()) {
		  System.out.println(res.getString(1));
		}

		res = stmt.executeQuery("select * from fact_report limit 10");

		try {
			while (res.next()) {
				System.out.println(res.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.print(e.toString());
		}
		System.out.print("test success");
	}
}