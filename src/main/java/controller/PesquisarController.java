package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import model.Palavra;
import model.Staging;
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
		
		Document doc = PesquisarService.crawl(0, "https://www.dicio.com.br/"+palavra.getPalavra(), new ArrayList<String>());
		
		ArrayList<String> ps = new ArrayList<String>();
		if(doc != null ) {
			
			Staging staging = new Staging();
			staging.setPalavra(p);
			staging.setDoc(doc);
			staging.salvar();
			
			for(Element par : doc.select("p")) {
				if(par.hasClass("adicional sinonimos")) {
					ps.addAll(par.select("a").eachText());
				}
				
			}
			for(Element div : doc.select("div")) {
				if(div.hasClass("palavras-relacionadas card")) {
					ps.addAll(div.select("a").eachText());
				}
				
			}
		
		}		
		
		palavra.salvar();
		
		request.setAttribute("palavra", palavra.getPalavra());
		request.setAttribute("result", doc);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	}

}
