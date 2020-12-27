package pj.toon.webcrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pj.toon.vo.WebtoonVo;

public class DaumCrawling {
	public static void main(String[] args) {
		crawl();
	}
	
	public static ArrayList<WebtoonVo> crawl() {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		setList(list, "mon");

		for (WebtoonVo v : list) {
			System.out.println(v.getToon_name());
			System.out.println(v.getToon_writer());
			System.out.println(v.getToon_site());
//			System.out.println(v.getG_no());
		}
		
		return list;
	}

	public static void setList(ArrayList<WebtoonVo> list, String day) {
		String url = "http://webtoon.daum.net/search/total?q=%23로맨스#page=1";
		Document doc = null;
		// Document에 페이지의 전체 소스 저장
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc);
		
		Elements elements = doc.select("ul.list_wt");
		Iterator<Element> title = elements.select("strong.tit_wt").iterator();
		Iterator<Element> writer = elements.select("span.txt_info").iterator();
		Iterator<Element> img = elements.select("img.img_thumb").iterator();
		Iterator<Element> link = elements.select("a.link_wt").iterator();
		// http://webtoon.daum.net/webtoon/view/dogcollar
		// /webtoon/view/baengnodiner
		
//		while(title.hasNext()) {
//			WebtoonVo vo = new WebtoonVo();
//			String wlink = "http://webtoon.daum.net" + link.next().attr("href");
//			ArrayList<Integer> g_no = new ArrayList<Integer>();
//			vo.setToon_name(title.next().text());
//			vo.setToon_writer(writer.next().text());
//			vo.setToon_pic(img.next().attr("src"));
//			vo.setToon_site(wlink);
//			
//			secondLink(wlink);
//			
//			System.out.println("while");
//			
//		}
	}
	
	public static void secondLink(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("secondLink");
		Elements elements = doc.select("a.link_genre");
		String genre = "";
		for(Element e : elements) {
			genre = genre + " " + e.text();
		}
		
		System.out.println(genre);
		
	}
}
