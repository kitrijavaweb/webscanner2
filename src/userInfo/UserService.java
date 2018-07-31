package userInfo;

import java.util.ArrayList;

public interface UserService {
	ArrayList<UserDTO> userInfo();
	int delete(String id);
}
