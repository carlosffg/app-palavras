package service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PesquisarService {
	
	public static ArrayList<String> crawl(int level, String url, ArrayList<String> visited) {
		try {
			Connection conn = Jsoup.connect(url);
			Document doc = conn.get();
			
			if(conn.response().statusCode() == 200) {
				visited.add(url); 
			}
			
			ArrayList<String> ps = new ArrayList<String>();
			if(doc != null ) {
				for(Element p : doc.select("p")) {
					if(p.hasClass("adicional sinonimos")) {
						ps.addAll(p.select("a").eachText());
					}
					
				}
				for(Element div : doc.select("div")) {
					if(div.hasClass("palavras-relacionadas card")) {
						ps.addAll(div.select("a").eachText());
					}
					
				}
			
			}			
			return ps;
		} catch(IOException e) {
			return null;
		}
	}
	
}
