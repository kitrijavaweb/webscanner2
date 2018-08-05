package hhspack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testcrawl {
	public static void main(String[] args) {
		try {
			String url = "";
			HashMap<String, String> hash_LinkList = new HashMap<>();
			url = "http://www.douzone.com/";
			Document doc = Jsoup.connect(url).get();

			String title = doc.title();
			// 첫 페이지 A태그 관련 href 가져오기
			Elements links = doc.select("a[href]");
			List<String> url_array = new ArrayList<String>();
			int i = 0;
			url_array.add(url);
			hash_LinkList.put(url, title);
			// Iterator<String> keySetIterator = h.keySet().iterator();
			// A태그의 링크가 없을까지 반복작업
			while ((i <= hash_LinkList.size())) {
				try {
					// facebook 이라는 단어가 포함되면 삭제
					url = url_array.get(i).toString();
					doc = Jsoup.connect(url).get();
					title = doc.title();
					links = doc.select("a[href]").not("a[href='#']").not("a[href='#none']").not("a[href='#btn']").not("a[href='#container']");
					for (int j = 0; j < links.size(); j++) {
						if (links.get(j).toString().contains("facebook")) {
							links.get(j).clearAttributes();
						} else if (!links.get(j).toString().contains("http")) {
							String getUrl="http://14.36.28.181"+links.get(j).attr("href");
							System.out.println(getUrl);
						}
					}
					// .not("a[href='http://www.facebook.com/kr.kitri?fref=ts']")
					for (Element link : links) {
						String res = hash_LinkList.putIfAbsent(link.attr("href"), link.text());
						if (res == null) {
							url_array.add(link.attr("href"));
							System.out.println("URL: " + link.attr("href"));
							System.out.println("TITLE: " + link.text());
						}
					}
				} catch (Exception e) {
					// System.out.println("\n" + e);
				}

				i++;

			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
}
