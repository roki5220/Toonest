package hr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao.WebtoonDao;
import pj.toon.vo.WebtoonVo;

@WebServlet("/GenreListController.do")
public class GenreListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GenreListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		int spage = 1;
		String page = request.getParameter("page");
		if (page != null) {
			spage = Integer.parseInt(page);
		}

		HashMap<String, Object> listOpt = new HashMap<String, Object>();

		String genre = request.getParameter("genre");

		listOpt.put("genre", genre);
		listOpt.put("start", spage * 10 - 9);

		WebtoonDao dao = new WebtoonDao();
		int listCount = dao.getGenreListCount(listOpt);

		ArrayList<WebtoonVo> list = dao.getGenreList(listOpt);
		request.setAttribute("list", list);

		int maxPage = (int) (listCount / 10.0 + 0.9);
		int startPage = (int) (spage / 5.0 + 0.8) * 5 - 4;
		int endPage = startPage + 4;
		if (endPage > maxPage) {
			endPage = maxPage;
		}


		request.setAttribute("genre", genre);
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		String viewPage = "jsp_hr/genrePage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
