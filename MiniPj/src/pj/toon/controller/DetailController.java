package pj.toon.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao.WebtoonDao;
import pj.toon.vo.ReviewVo;
import pj.toon.vo.WebtoonVo;

@WebServlet("/DetailController.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		WebtoonDao dao = new WebtoonDao();
		WebtoonVo vo = new WebtoonVo();
		int toon_no = Integer.parseInt(request.getParameter("toon_no"));
		String toon_name = request.getParameter("toon_name");
		
		vo.setToon_no(toon_no);
		vo.setToon_name(toon_name);
		vo = dao.select_detail(vo);
		System.out.println(vo.getAvg_star());
		
		//===============================
		
		int spage = 1;
		String page = request.getParameter("page");
		if (page != null) {
			spage = Integer.parseInt(page);
		}


		ReviewVo rVo = new ReviewVo();
		rVo.setToon_no(toon_no);
		int start = spage * 3 - 2;

		WebtoonDao rDao = new WebtoonDao();
		int listCount = rDao.getReviewCount(rVo, start);

		ArrayList<ReviewVo> list = rDao.getReviewList(rVo, start);
		
		for(ReviewVo v : list) {
			System.out.println(v.getNickname());
		}
		
		request.setAttribute("list", list);

		int maxPage = (int) (listCount / 3.0 + 0.7);
		int startPage = (int) (spage / 5.0 + 0.8) * 5 - 4;
		int endPage = startPage + 4;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		System.out.println("maxpage: "+ maxPage);


		request.setAttribute("toon_no", toon_no);
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		//====================================
		
		request.setAttribute("vo", vo);
		String viewPage = "jsp/body_detail.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

