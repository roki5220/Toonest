package WebCrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pj.toon.vo.NaverVo;

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
		
		ArrayList<NaverVo> list = new ArrayList<NaverVo>();
		while(writer.hasNext()) {
			NaverVo vo = new NaverVo();
			vo.setToon_title(title.next().text());
			vo.setToon_writer(writer.next().text());
			vo.setG_name("dramaUrl");
			System.out.println(title.next().text());
			System.out.println(writer.next().text());
			list.add(vo);
		}
	}
	
}


