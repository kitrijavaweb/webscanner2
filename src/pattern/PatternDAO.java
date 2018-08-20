package pattern;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PatternDAO {
	int insert(String name,String pattern,Connection con)throws SQLException;
	ArrayList<PartternDTO> getPattern(Connection con) throws SQLException;
	ArrayList<PartternDTO> getSQLPattern(String name,Connection con) throws SQLException;
	int delete(String pattern,Connection con) throws SQLException;
}
