package login;

public interface LoginService {
	int insert(String id,String pass, String name,String Sort,String email);
	int resgisterCheck(String id);
	LoginDTO loginCheck(String id, String pass);
}
