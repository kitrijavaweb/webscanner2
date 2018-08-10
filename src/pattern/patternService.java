package pattern;

import java.util.ArrayList;

public interface patternService {
	int insert(String name,String pattern);
	ArrayList<PartternDTO> getPattern();
	int delete(String pattern);
}
