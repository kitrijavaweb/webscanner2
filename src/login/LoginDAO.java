package login;

import java.sql.Connection;
import java.sql.SQLException;

public interface LoginDAO {
	int insert(String id,String pass, String name,String Sort,String email,Connection con)throws SQLException;
	int resgisterCheck(String id, Connection con) throws SQLException;
	LoginDTO loginCheck(String id, String pass, Connection con)throws SQLException;
}
