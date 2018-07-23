package emp.dao;

public class Query {
	public static final String INSERT_REGISTER="insert into member2 values(?,?,?,'/template/userPage.jsp')";
	public static final String SELECT_LOGIN="SELECT * FROM member2 WHERE ID LIKE ? AND PASS LIKE ?";
}
