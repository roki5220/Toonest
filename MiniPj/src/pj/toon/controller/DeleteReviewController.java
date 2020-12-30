package pj.toon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao.WebtoonDao;


@WebServlet("/DeleteReview.do")
public class DeleteReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteReviewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		WebtoonDao dao = new WebtoonDao();
		
		int review_no = Integer.parseInt(request.getParameter("rno"));
		
		int toon_no = dao.selectReview(review_no);
		
		dao.deleteReview(review_no);
		dao.deleteKeyword(review_no);
		
		String viewPage = "/MiniPj/DetailController.do?toon_no=" + toon_no;
		response.sendRedirect(viewPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
