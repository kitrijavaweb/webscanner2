package userInfo;

import static util.DBUtil.DBconnect;
import static util.DBUtil.close;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserServiceImpl implements UserService {

	@Override
	public ArrayList<UserDTO> userInfo() {
		UserDAO dao = new UserDAOImpl();
		ArrayList<UserDTO> userlist =null;
		Connection con = null;
		try {
			con = DBconnect();
			userlist =dao.userInfo(con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return userlist;
	}

	@Override
	public int delete(String id) {
		int result=0;
		System.out.println("삭제확인");
		UserDAO dao = new UserDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.delete(id, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}
}
