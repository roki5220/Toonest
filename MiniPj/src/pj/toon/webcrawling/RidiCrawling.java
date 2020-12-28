package pj.toon.webcrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pj.toon.dao.WebtoonDao;
import pj.toon.vo.WebtoonVo;

public class RidiCrawling {
	public static void main(String[] args) {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		crawl(list);
	}
	
	public static ArrayList<WebtoonVo> crawl(ArrayList<WebtoonVo> list) {
//		setList(list, "1607", "일상");	//스포츠,학원 장르인데 일상에 넣을지 고민
		setList(list, "1603", "드라마");	//드라마
		setList(list, "1605", "액션");	//액션
		setList(list, "1606", "판타지");	//판타지
		setList(list, "1610", "스릴러");	//스릴러
		setList(list, "1601", "로맨스");	//로맨스(순정)

		for (WebtoonVo v : list) {
			System.out.println(v.getToon_name());
			System.out.println(v.getToon_writer());
			System.out.println(v.getToon_site());
			System.out.println(v.getToon_pic());
			System.out.println(v.getToon_genre());
		}
		WebtoonDao dao = new WebtoonDao();
		dao.insert(list);
		return list;
	}

	public static void setList(ArrayList<WebtoonVo> list, String genre, String genreStr) {
		String url = "https://ridibooks.com/category/bestsellers/" + genre;
		Document doc = null;
		int count = 0;
		// Document에 페이지의 전체 소스 저장
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(doc.html());

		Elements elements = doc.select("div.book_macro_wrapper.js_book_macro_wrapper");
		Iterator<Element> title = elements.select("span.title_text.js_highlight_helper").iterator();
		Iterator<Element> writer = elements.select("p.book_metadata.author").iterator();
		Iterator<Element> img = elements.select(".thumbnail.lazyload").iterator();
		Iterator<Element> link = elements.select("a.title_link.trackable").iterator();
		
		while(title.hasNext() && count < 20) {
			WebtoonVo vo = new WebtoonVo();
			vo.setToon_name(title.next().text());
			vo.setToon_writer(writer.next().text());
			vo.setToon_link("https://ridibooks.com" + link.next().attr("href"));
			vo.setToon_pic("https:" + img.next().attr("data-src"));
			vo.setToon_site("리디북스");
			vo.setToon_genre(genreStr);
			list.add(vo);
			count++;
		}
	}
}
