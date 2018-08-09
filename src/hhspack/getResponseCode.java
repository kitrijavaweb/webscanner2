package hhspack;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class getResponseCode {
	public static void main(String[] args) throws Exception {
		byte[] b = new byte[1024];
		String url="http://14.36.28.181/kitri/main/main.web";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.println("Post 응답 코드 " + con.getResponseCode());
		InputStream error=con.getErrorStream();
		error.read(b);
		System.out.println(new String(b));
		error.close();
	}
}
