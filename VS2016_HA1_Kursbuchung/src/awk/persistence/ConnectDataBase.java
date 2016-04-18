package awk.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDataBase {
	
public static Connection ConnectDB(){
		
		String url = "jdbc:oracle:thin:@l4asrv-oracle.wi.hs-osnabrueck.de:1521:orcl";
		String user = "VS2016_24";
		String password = "NewYork99";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection (url, user, password);
			System.out.println("Verbindung zur Datenbank wurde hergestellt!\n");
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Verbindung zur Datenbank konnte nicht hergestellt werden!\n");
		}
		return null;
	}
	
	public static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}
	
	public static void executeUpdateStatement(Connection conn, String aStatement) throws SQLException{
		System.out.println(aStatement);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(aStatement);
	}
	
	public static ResultSet executeQueryStatement(Connection conn, String aStatement) throws SQLException{
		ResultSet aResultSet = null;
		System.out.println(aStatement);
		Statement stmt = conn.createStatement();
		aResultSet = stmt.executeQuery(aStatement);
		
		return aResultSet;
	}

}
