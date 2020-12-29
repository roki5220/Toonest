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

@WebServlet("/ToonView.do")
public class ToonViewcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToonViewcontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebtoonDao dao = new WebtoonDao();
		WebtoonVo vo = new WebtoonVo();

		vo.setToon_no(Integer.valueOf(request.getParameter("toon_no")));

		vo = dao.viewWeb(vo);

		request.setAttribute("vo", vo);

		String viewPage = vo.getToon_link();
		response.sendRedirect(viewPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
