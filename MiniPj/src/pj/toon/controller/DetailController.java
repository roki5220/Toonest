package pj.toon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao.WebtoonDao;

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

