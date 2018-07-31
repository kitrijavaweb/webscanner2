package login;

public class Query {
	public static final String INSERT_REGISTER="insert into user2 values(?,?,?,?,?)";
	public static final String SELECT_USERID="SELECT * FROM USER2 WHERE USERID=?";
	public static final String SELECT_LOGIN="SELECT * FROM USER2 WHERE USERID=? AND USERPASSWORD=?";
}
