package pattern;

import static pattern.Query.*;
import static util.DBUtil.DBconnect;
import static util.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class PatternDAOImpl implements PatternDAO {

	@Override
	public int insert(String name, String pattern, Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(INSERT_PATTERN);
		con = DBconnect();
		ptmt.setString(1, name);
		ptmt.setString(2, pattern.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("-", "&#45;"));
		result=ptmt.executeUpdate();
		System.out.println("PatternDAO ====>" +result);
		close(ptmt);
		return result;
	}

	@Override
	public ArrayList<PartternDTO> getPattern(Connection con) throws SQLException {
		PreparedStatement ptmt  = con.prepareStatement(SELECT_PATTERN);
		ArrayList<PartternDTO> patterninfo = new ArrayList<PartternDTO>();
		PartternDTO e =null;
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			e= new PartternDTO(rs.getString(1), rs.getString(2));
			System.out.println("ÆÐÅÏ¸í ======>: "+rs.getString(1));
			patterninfo.add(e);
		}
		close(rs);
		close(con);
		return patterninfo;
	}

	@Override
	public int delete(String pattern,Connection con) throws SQLException {
		int result=0;
		PreparedStatement ptmt = con.prepareStatement(DELETE_PATTERN);
		con = DBconnect();
		ptmt.setString(1, pattern.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("-", "&#45;"));
		result=ptmt.executeUpdate();
		close(ptmt);
		return result;
	}
}
