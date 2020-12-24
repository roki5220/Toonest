package WebCrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pj.toon.vo.WebtoonVo;

public class NaverCrawling {
	public static void main(String[] args) {
		crawl();
	}
	public static ArrayList<WebtoonVo> crawl() {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		setList(list, "daily", 1);
		setList(list, "drama", 2);
		setList(list, "action", 3);
		setList(list, "fantasy", 4);
		setList(list, "thrill", 5);
		setList(list, "pure", 6);

		for (WebtoonVo v : list) {
			System.out.println(v.getToon_title());
			System.out.println(v.getToon_writer());
			System.out.println(v.getToon_link());
			System.out.println(v.getG_no());
			System.out.println(v.getToon_pic());
		}
		
		return list;
	}

	public static void setList(ArrayList<WebtoonVo> list, String genre, int num) {
		String url = "https://comic.naver.com/webtoon/genre.nhn?genre=" + genre;
		Document doc = null;
		// Document에 페이지의 전체 소스 저장
		int count = 1;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(doc.text());
		Elements elements = doc.select("ul.img_list li");
		Iterator<Element> title = elements.select(".thumb a").iterator();
		Iterator<Element> link = elements.select("dt a").iterator();
		Iterator<Element> writer = elements.select("dd.desc").iterator();
		Iterator<Element> img = elements.select(".thumb img[src$=jpg]").iterator();
		
		while (title.hasNext() && count <= 20) {
			WebtoonVo vo = new WebtoonVo();
			ArrayList<Integer> g_no = new ArrayList<Integer>();
			vo.setToon_title(title.next().attr("title"));
			vo.setToon_writer(writer.next().text());
			vo.setToon_link("https://comic.naver.com" + link.next().attr("href"));
			vo.setToon_pic(img.next().attr("src"));
			g_no.add(num);
			vo.setG_no(g_no);
			vo.setToon_site("naver");
			list.add(vo);
			count++;
			//완결여부는 일단 생략.. 모르겠음
		}
	}

}