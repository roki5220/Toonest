package pj.toon.controller;

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

@WebServlet("/SearchController.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 현재 페이지 번호
		int spage = 1;
		String page = request.getParameter("page");

		// 처음 게시판을 클릭했을 때는 page가 null이므로 1페이지가 뜸
		if (page != null) {
			spage = Integer.parseInt(page);
		}

		HashMap<String, Object> listOpt = new HashMap<String, Object>();

		String searchBox = null;
		if (request.getParameter("searchBox") != null) {
			searchBox = request.getParameter("searchBox");
			request.setAttribute("searchBox2", searchBox);
		} else {
			searchBox = request.getParameter("searchBox2");
			request.setAttribute("searchBox2", searchBox);
		}
		
		listOpt.put("searchBox", searchBox);
		listOpt.put("start", spage * 15 - 14);

		WebtoonDao dao = new WebtoonDao();
		int listCount = dao.getListCount(listOpt);

		ArrayList<WebtoonVo> list = dao.getSearchList(listOpt);
		request.setAttribute("list", list);

		int maxPage = (int) (listCount / 15.0 + 0.94);
		int startPage = (int) (spage / 5.0 + 0.8) * 5 - 4;
		int endPage = startPage + 4;
		if (endPage > maxPage) {
			endPage = maxPage;
		}

		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("search", searchBox);

		String viewPage = "jsp/searchPage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
