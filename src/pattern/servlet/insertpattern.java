package pattern.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class insertpattern {
	 public static ArrayList<String> insert() throws Exception{
	        // 파일 변수 file을 만든다
		 String[] splitedStr;
		 ArrayList<String> patternData= new ArrayList<String>();
	        File file = new File("C:\\pattern.txt");
	 
	            // BufferedReader 변수에 file을 넣는다
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	 
	            // 파일을 한줄씩 읽어 넣기 위한 변수 line
	            String line = null;
	            // 한 줄씩 읽어서 line에 넣은 후 null이 아니면 실행
	            while( (line = reader.readLine()) != null ) {
	 
	                // 초기화
	            	splitedStr = null;
	 
	                // 탭을 기준으로 잘라서 splitedStr 에 넣는다
	            	splitedStr = line.split("\t");
	 
	                // 배열에 들어간 길이 만큼 반복한다
	                for (int i = 0; i < splitedStr.length; i++) {
	                        // 양쪽의 공백을 제거하고 다시 입력한다
	                    patternData.add(splitedStr[i].trim());
	                }
	            }
	            reader.close();
	        return patternData;
	    }
}
