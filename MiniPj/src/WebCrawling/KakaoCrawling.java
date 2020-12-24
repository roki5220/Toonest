package WebCrawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pj.toon.vo.WebtoonVo;

public class KakaoCrawling {
	public static void main(String[] args) {
		crawl();
	}
	public static ArrayList<WebtoonVo> crawl() {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		setList(list, "mon");

		for (WebtoonVo v : list) {
			System.out.println(v.getToon_title());
			System.out.println(v.getToon_writer());
			System.out.println(v.getToon_link());
			System.out.println(v.getG_no());
		}
		
		return list;
	}

	public static void setList(ArrayList<WebtoonVo> list, String day) {
		String url = "https://page.kakao.com/ranking/today?categoryUid=10&subCategoryUid=116";
		Document doc = null;
		// Document에 페이지의 전체 소스 저장
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc.html());
	}
}
