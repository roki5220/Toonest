package pj.toon.webcrawling;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import pj.toon.dao.WebtoonDao;
import pj.toon.vo.WebtoonVo;

public class KakaoCrawling {
	public static void main(String[] args) {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		crawl(list);
	}
	public static ArrayList<WebtoonVo> crawl(ArrayList<WebtoonVo> list) {
//		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		
		setList(list, "17469", "드라마");	//드라마
		setList(list, "19587", "로맨스");	//로맨스
		setList(list, "17588", "액션");	//액션
//		setList(list, "19656", "판타지");	//로판->로맨스,판타지
		setList(list, "19656", "로맨스");
		setList(list, "8809", "판타지");	//소년 -> 판타지
		
		for (WebtoonVo v : list) {
			System.out.println(v.getToon_name());
			System.out.println(v.getToon_writer());
			System.out.println(v.getToon_site());
			System.out.println(v.getToon_pic());
			System.out.println(v.getToon_genre());	//여기서 출력했을 때 값이 안 나옴 -> TODO 값 들어갔는지 확인해야함
		}
		WebtoonDao dao = new WebtoonDao();
		dao.insert(list);
		return list;
	}

	public static void setList(ArrayList<WebtoonVo> list, String genre, String genreStr) {
		// 드라마 116, 로맨스 121, 액션 112, 소년 115(거의 판타지), 로판 69 => 뭐를 판타지로 넣지..?
		String url = "https://page.kakao.com/theme/list?themeId="+genre;
		Document doc = null;
		int count = 20;
		// Document에 페이지의 전체 소스 저장
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element ele = doc.select("script#__NEXT_DATA__").first();
		String jsonStr = ele.html();
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(jsonStr);
			String props = (String) obj.get("props").toString();
			obj = (JSONObject) parser.parse(props);
			String str = (String) obj.get("initialState").toString();
			obj = (JSONObject) parser.parse(str);
			str = (String) obj.get("theme").toString();
			obj = (JSONObject) parser.parse(str);
			str = (String) obj.get("data").toString();
			obj = (JSONObject) parser.parse(str);
			str = (String) obj.get("seriesList").toString();
			JSONArray arr = (JSONArray) parser.parse(str);
			if(arr.size() < 20) {
				count = arr.size();
			}
			for(int i = 0; i < count; i++) {
				WebtoonVo vo = new WebtoonVo();
				str = (String) arr.get(i).toString();
				obj = (JSONObject) parser.parse(str);
				String title = (String) obj.get("title").toString();
				String writer = (String) obj.get("author").toString();
				String link = (String) obj.get("url").toString();
				link.substring(1);
				link = "https://page.kakao.com" + link;
				vo.setToon_name(title);
				vo.setToon_writer(writer);
				vo.setToon_link(link);
				Document docIn = null;
				try {
					docIn = Jsoup.connect(link).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				Element element = docIn.select("img.css-1ithwm4").first();
				String img = element.attr("src");
				vo.setToon_pic(img);
				vo.setToon_site("카카오페이지");
				vo.setToon_genre(genreStr);
				list.add(vo);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
