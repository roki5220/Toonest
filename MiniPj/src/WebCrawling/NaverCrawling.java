package WebCrawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverCrawling {
	public static void main(String[] args) {
		String dramaUrl = "https://comic.naver.com/webtoon/genre.nhn?genre=drama";
		Document doc = null;
		//Document에 페이지의 전체 소스 저장
		
		try {
			doc = Jsoup.connect(dramaUrl).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements element = doc.select("ul.img_list");
		Iterator<Element> title = element.select("dt a").iterator();
		Iterator<Element> writer = element.select("dd.desc").iterator();
		
		while(writer.hasNext()) {
			System.out.println(title.next().text());
			System.out.println(writer.next().text());
		}
		System.out.println("fff");
	}
}
