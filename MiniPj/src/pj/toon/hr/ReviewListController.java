package pj.toon.hr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao.WebtoonDao;
import pj.toon.vo.WebtoonVo;


@WebServlet("/ReviewList.do")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		WebtoonDao dao = new WebtoonDao();
		WebtoonVo vo = new WebtoonVo();
		int toon_no = Integer.parseInt(request.getParameter("toon_no"));
		
		vo.setToon_no(toon_no);
		vo = dao.select_detail(vo);
		System.out.println(vo);
		
		request.setAttribute("vo", vo);
		
		//-----------------------------------------------------
		
		int spage = 1;
		String page = request.getParameter("page");
		if (page != null) {
			spage = Integer.parseInt(page);
		}


		ReviewVo rVo = new ReviewVo();
		rVo.setToon_no(toon_no);
		int start = spage * 3 - 2;

		WebtoonDaoHr rDao = new WebtoonDaoHr();
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

		String viewPage = "jsp_hr/body_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
