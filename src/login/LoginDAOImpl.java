package login;

import static login.Query.*;
import static util.DBUtil.DBconnect;
import static util.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAOImpl implements LoginDAO {

	@Override
	public int insert(String id,String pass, String name,String Sort,String email, Connection con) throws SQLException{
	int result=0;
	PreparedStatement ptmt = con.prepareStatement(INSERT_REGISTER);
	con = DBconnect();
	ptmt.setString(1, id);
	ptmt.setString(2, pass);
	ptmt.setString(3, name);
	ptmt.setString(4, Sort);
	ptmt.setString(5, email);
	result=ptmt.executeUpdate();
	close(ptmt);
	return result;
}

	@Override
	public int resgisterCheck(String id, Connection con) throws SQLException {
		int result= 0;
		PreparedStatement ptmt = con.prepareStatement(SELECT_USERID);
		con = DBconnect();
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			result =0;
		}else{
			result =1;
		}
		close(ptmt);
		return result;
	}

	@Override
	public LoginDTO loginCheck(String id, String pass, Connection con) throws SQLException {
		LoginDTO result=null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_LOGIN);
		con = DBconnect();
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			result= new LoginDTO(rs.getString(1), 
					rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
			System.out.println(result);
		}
		close(ptmt);
		return result;
	}
}
