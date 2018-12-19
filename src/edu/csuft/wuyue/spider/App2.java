package edu.csuft.wuyue.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App2 {
public static void main(String[] args) {
	String url="https://movie.douban.com/subject/1292052/";
	
	try {
		Document d=Jsoup.connect(url).get();
		Element e=d.getElementById("content");
		String name =e.select("h1 span").text();
		String year=e.select(".year").text();
		
		String director =e.select("#info span").get(0).selectFirst(".attrs a").text();
		String script =e.select("#info .attrs").get(1).text();
		String actor =e.select("#info .actor .attrs").text();
		
		System.out.println(name);
		System.out.println(year);
		System.out.println(director);
		System.out.println(script);
		System.out.println(actor);
	
		System.out.printf("%s,%s,%s,%s,%s",
				name,
				year,
				director,
				script,
				actor
				
				);
	
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
}
