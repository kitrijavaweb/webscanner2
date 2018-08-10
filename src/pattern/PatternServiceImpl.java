package pattern;

import static util.DBUtil.DBconnect;
import static util.DBUtil.close;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;




public class PatternServiceImpl implements patternService {

	@Override
	public int insert(String name, String pattern) {
		int result=0;
		PatternDAO dao = new PatternDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.insert(name, pattern, con);
			System.out.println("service =====> "+ result);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<PartternDTO> getPattern() {
		PatternDAO dao = new PatternDAOImpl();
		ArrayList<PartternDTO> Partternlist =null;
		Connection con = null;
		try {
			con = DBconnect();
			Partternlist =dao.getPattern(con);
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			close(con);
		}
		return Partternlist;
	}

	@Override
	public int delete(String pattern) {
		int result=0;
		PatternDAO dao = new PatternDAOImpl();
		Connection con =null;
		try{
			con = DBconnect();
			result=dao.delete(pattern, con);
		}catch(SQLException e){
			
		}finally{
			close(con);
		}
		return result;
	}
}
