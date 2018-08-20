package pattern;

public class Query {
	public static final String INSERT_PATTERN="insert all into pattern values(?,?) select * from dual";
	public static final String SELECT_PATTERN="select * from pattern";
	public static final String SELECT_GET_PATTERN="select * from pattern where name like ?";
	public static final String DELETE_PATTERN="delete pattern where parttern = ?";
}
