package emp.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.dto.empDTO;

public interface empDAO {
	int insert(String name, String id, String pass,Connection con)throws SQLException;
	empDTO login(String id,String pass, Connection con)throws SQLException;
}
