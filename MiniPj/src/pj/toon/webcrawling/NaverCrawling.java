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

public class NaverCrawling {
	public static void main(String[] args) {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		crawl(list);
	}
	public static ArrayList<WebtoonVo> crawl(ArrayList<WebtoonVo> list) {
//		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		//일상, 드라마, 액션, 판타지, 스릴러, 로맨스
		setList(list, "daily", "일상");
		setList(list, "drama", "드라마");
		setList(list, "action", "액션");
		setList(list, "fantasy", "판타지");
		setList(list, "thrill", "스릴러");
		setList(list, "pure", "로맨스");

//		for (WebtoonVo v : list) {
//			if(v.getToon_name().equals(null)) {
//				System.out.println("===========================================");
//			}
//			System.out.println(v.getToon_name());
//			System.out.println(v.getToon_writer());
//			System.out.println(v.getToon_link());
//			System.out.println(v.getToon_genre());
//			System.out.println(v.getToon_pic());
//			System.out.println();
//		}
		
		WebtoonDao dao = new WebtoonDao();
		dao.insert(list);
		return list;
	}

	public static void setList(ArrayList<WebtoonVo> list, String genre, String genreStr) {
		String url = "https://comic.naver.com/webtoon/genre.nhn?genre=" + genre;
		Document doc = null;
		// Document에 페이지의 전체 소스 저장
		int count = 1;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.println(doc.text());
		Elements elements = doc.select("ul.img_list li");
		Iterator<Element> title = elements.select(".thumb a").iterator();
		Iterator<Element> link = elements.select("dt a").iterator();
		Iterator<Element> writer = elements.select("dd.desc").iterator();
		Iterator<Element> img = elements.select(".thumb img[src$=jpg]").iterator();
		
		while (title.hasNext() && count <= 20) {
			WebtoonVo vo = new WebtoonVo();
			vo.setToon_name(title.next().attr("title"));
			vo.setToon_writer(writer.next().text());
			vo.setToon_link("https://comic.naver.com" + link.next().attr("href"));
			vo.setToon_pic(img.next().attr("src"));
			vo.setToon_genre(genreStr);
			vo.setToon_site("네이버");
			list.add(vo);
			count++;
			//완결여부는 일단 생략.. 모르겠음
		}
		
		
	}

}