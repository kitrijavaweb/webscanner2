package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static Connection DBconnect(){
		Connection con = null;		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 立加吝");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 立加 角菩");
		}
		return con;
		
	}
	public static void close(Connection con){
		try{
			if(con!=null) con.close();
		}catch(SQLException e){
			e.getStackTrace();
		}
	}
	public static void close(Statement stmt){
		try{
			if(stmt!=null) stmt.close();
		}catch(SQLException e){
			e.getStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try{
			if(rs!=null) rs.close();
		}catch(SQLException e){
			e.getStackTrace();
		}
	}
}