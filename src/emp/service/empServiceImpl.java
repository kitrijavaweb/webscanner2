package emp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dao.empDAO;
import emp.dao.empDAOImpl;
import emp.dto.empDTO;

import static util.DBUtil.*;

public class empServiceImpl implements empService{

	@Override
	public int insert(String name, String id, String pass) {
		int result=0;
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.insert(name, id, pass, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public empDTO login(String id, String pass) {
		empDTO user = null;
		empDAO dao = new empDAOImpl();
		Connection con =null;
		try{
			con =DBconnect();
			user =dao.login(id, pass, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return user;
	}

}