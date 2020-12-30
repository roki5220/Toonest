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

@WebServlet("/ReviewInsertController.do")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewInsertController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		WebtoonDao dao = new WebtoonDao();
		ReviewVo vo = new ReviewVo();

		int toon_no = Integer.parseInt(request.getParameter("toon_no"));
		/* int review_no = Integer.parseInt(request.getParameter("review_no")); */

		vo.setReview_content(request.getParameter("reviewContent"));
		vo.setReview_star(Integer.valueOf(request.getParameter("rating")));
		vo.setToon_no(Integer.valueOf(toon_no));
		vo.setNickname(request.getParameter("nick_name"));
		vo.setPassword(request.getParameter("password"));

		int n = dao.INSERT_REVIEW(vo);
		
		if(!request.getParameterValues("keyword").equals(null)) {
			String[] arrayKeyword = request.getParameterValues("keyword");
			System.out.println("keyword 테이블 입력");
			for (String keyword : arrayKeyword) {
				
				dao.insertKeyword(toon_no, keyword);
			}
			
		}
		if (n != 0) {
			String viewPage = "/MiniPj/DetailController.do?toon_no=" + toon_no;
			response.sendRedirect(viewPage);
		} else {
			System.out.println("댓글 등록 실패");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
