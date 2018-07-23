package emp.service;

import java.util.ArrayList;

import emp.dto.empDTO;

public interface empService {
	int insert(String name, String id, String pass);
	empDTO login(String id, String pass);
}
