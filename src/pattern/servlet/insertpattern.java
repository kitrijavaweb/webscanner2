package pattern.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class insertpattern {
	 public static ArrayList<String> insert() throws Exception{
	        // ���� ���� file�� �����
		 String[] splitedStr;
		 ArrayList<String> patternData= new ArrayList<String>();
	        File file = new File("C:\\pattern.txt");
	 
	            // BufferedReader ������ file�� �ִ´�
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	 
	            // ������ ���پ� �о� �ֱ� ���� ���� line
	            String line = null;
	            // �� �پ� �о line�� ���� �� null�� �ƴϸ� ����
	            while( (line = reader.readLine()) != null ) {
	 
	                // �ʱ�ȭ
	            	splitedStr = null;
	 
	                // ���� �������� �߶� splitedStr �� �ִ´�
	            	splitedStr = line.split("\t");
	 
	                // �迭�� �� ���� ��ŭ �ݺ��Ѵ�
	                for (int i = 0; i < splitedStr.length; i++) {
	                        // ������ ������ �����ϰ� �ٽ� �Է��Ѵ�
	                    patternData.add(splitedStr[i].trim());
	                }
	            }
	            reader.close();
	        return patternData;
	    }
}
