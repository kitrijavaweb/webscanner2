package emp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dto.empDTO;

import static util.DBUtil.*;
import static emp.dao.Query.*;
public class empDAOImpl implements empDAO {

	@Override
	public int insert(String name, String id, String pass, Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(INSERT_REGISTER);
		con = DBconnect();
		ptmt.setString(1, name);
		ptmt.setString(2, id);
		ptmt.setString(3, pass);
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}

	@Override
	public empDTO login(String id, String pass, Connection con) throws SQLException {
		empDTO result=null;
		PreparedStatement ptmt = con.prepareStatement(SELECT_LOGIN);
		con = DBconnect();
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()){
			result= new empDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4));
		}
		close(ptmt);
		return result;
	}


}
