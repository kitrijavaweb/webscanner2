package login;

import static util.DBUtil.DBconnect;
import static util.DBUtil.close;

import java.sql.Connection;
import java.sql.SQLException;



public class LoginServiceImpl implements LoginService {

	@Override
	public int insert(String id,String pass, String name,String Sort,String email) {
		int result=0;
		LoginDAO dao = new LoginDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.insert(id, pass, name, Sort, email, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public int resgisterCheck(String id) {
		int result=0;
		LoginDAO dao = new LoginDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.resgisterCheck(id, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public LoginDTO loginCheck(String id, String pass) {
		LoginDTO user = null;
		LoginDAO dao = new LoginDAOImpl();
		Connection con =null;
		try{
			con =DBconnect();
			user =dao.loginCheck(id, pass, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
	}
}
