package pattern.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultiInsertOracle {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "insert all ";
		insertpattern ip = new insertpattern();
		try {
			//1. JDBC드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공");
			
			//2. 커넥션 설정
			Connection con = 
					DriverManager.getConnection(url, user, password);
			System.out.println("연결성공:"+con);
			
			for(int i=0;i<ip.insert().size();i++) {
				sql = sql + " into pattern ";
				sql = sql+ "values('BruteForce','"+ip.insert().get(i)+"') ";
			}
			sql = sql+"select * from dual";
			//3. SQL문을 실행하기 위한 객체를 생성
			PreparedStatement ptmt = con.prepareStatement(sql);
			int result = ptmt.executeUpdate();
			System.out.println(result+"개 삽입 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
