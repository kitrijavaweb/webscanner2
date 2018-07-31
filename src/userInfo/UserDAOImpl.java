package userInfo;

import static userInfo.Query.*;
import static util.DBUtil.DBconnect;
import static util.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<UserDTO> userInfo(Connection con) throws SQLException {
		PreparedStatement ptmt  = con.prepareStatement(SELECT_USERINFO);
		ArrayList<UserDTO> joininfo = new ArrayList<UserDTO>();
		UserDTO e =null;
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			e= new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5));
			System.out.println("GetID"+rs.getString(1));
			joininfo.add(e);
		}
		close(rs);
		close(con);
		return joininfo;
	}

	@Override
	public int delete(String id, Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(DELETE_EMP);
		con = DBconnect();
		ptmt.setString(1, id);
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}
}
