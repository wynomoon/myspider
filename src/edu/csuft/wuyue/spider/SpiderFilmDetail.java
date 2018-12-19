package edu.csuft.wuyue.spider;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SpiderFilmDetail implements Runnable {

	String url;
	List<Film> list;
	
	
	
	public SpiderFilmDetail(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Document
	}

}
