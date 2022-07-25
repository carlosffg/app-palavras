package service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PesquisarService {
	
	public static Document crawl(int level, String url, ArrayList<String> visited) {
		try {
			Connection conn = Jsoup.connect(url);
			Document doc = conn.get();
			
			if(conn.response().statusCode() == 200) {
				visited.add(url); 
			}
				
			return doc;
		} catch(IOException e) {
			return null;
		}
	}
	
}
