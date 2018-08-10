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
			//1. JDBC����̹��ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε�����");
			
			//2. Ŀ�ؼ� ����
			Connection con = 
					DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��:"+con);
			
			for(int i=0;i<ip.insert().size();i++) {
				sql = sql + " into pattern ";
				sql = sql+ "values('BruteForce','"+ip.insert().get(i)+"') ";
			}
			sql = sql+"select * from dual";
			//3. SQL���� �����ϱ� ���� ��ü�� ����
			PreparedStatement ptmt = con.prepareStatement(sql);
			int result = ptmt.executeUpdate();
			System.out.println(result+"�� ���� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
