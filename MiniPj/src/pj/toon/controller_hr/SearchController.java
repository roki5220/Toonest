package pj.toon.controller_hr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao_hr.WebtoonDao;
import pj.toon.vo.WebtoonVo;

@WebServlet("/SearchController.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("searchBox");
		System.out.println(search);
		WebtoonDao dao = new WebtoonDao();
		ArrayList<WebtoonVo> list = dao.search(search);
		
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		String viewPage = "jsp_hr/searchPage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
