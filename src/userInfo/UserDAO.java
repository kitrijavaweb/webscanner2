package userInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
	ArrayList<UserDTO> userInfo(Connection con)throws SQLException;
	int delete(String id,Connection con)throws SQLException;
}
