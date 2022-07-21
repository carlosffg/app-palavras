package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Palavra;
import service.PesquisarService;

@WebServlet("/pesquisarController")
public class PesquisarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesquisarController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("palavra");
		
		Palavra palavra = new Palavra();
		palavra.setPalavra(p);
				
		ArrayList<String> result = PesquisarService.crawl(0, "https://www.dicio.com.br/"+palavra.getPalavra(), new ArrayList<String>());
				
		palavra.salvar();
		
		request.setAttribute("palavra", palavra.getPalavra());
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	}

}
