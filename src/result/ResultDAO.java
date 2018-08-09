package result;

import java.sql.Connection;
import java.sql.SQLException;

public interface ResultDAO {
	int result(String id,String des,String sol,String link,Connection con)throws SQLException;
}
