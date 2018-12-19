package edu.csuft.wuyue.spider;
/**
 * 抓取影片信息
 * @author wynomoon
 *
 */

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable {
	/**
	 * 页面路径(URl)
	 */
	String url;
	/**
	 * 存储抓取的数据
	 */
	ArrayList<Film>list;
	/**
	 * 创建爬虫
	 * @param url
	 * @param list
	 */
	public Spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}
  	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//获得执行该任务的线程的名称
		String name=Thread.currentThread().getName();
		System.out.println(name+"线程，处理"+url);
		
		//JSOUP
		try {
			Document doc= Jsoup.connect(url).get();
			//从文档（树）中查找节点
			Elements es= doc.select(".grid_view .item");
			
//			//目标 URL
//			String url="https://movie.douban.com/top250";
//			//使用JSOUP抓取文档
			
//			try {
//				Document doc=Jsoup.connect(url).get();
////				String title =doc.title();
////				String data =doc.data();
////				System.out.println(title);
////				System.out.println(data);
//				
//				Elements es= doc.select(".grid_view .item");
//				//System.out.println(es.size());
//				
//				//创建一个影片的列表
//				ArrayList<Film> list=new ArrayList<>();
			
			
			//
			for(Element e :es) {
				
				Film f=new Film();
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster=e.select("img").first().text();
				f.info=e.select(".bd p").first().text();
				f.title=e.select(".title").first().text();
				f.rating=Double.parseDouble(e.select(".rating_num").first().text());
				String num=e.select(".star span").last().text();
				f.num=Integer.parseInt(num.substring(0, num.length()-3));
				f.quote=e.select(".inq").first().text();
				//f.url=e.select(".pic a").first().text();
				
			//	System.out.println(name+":"+f);
				list.add(f);
	
			}
			
			System.out.println(name+"线程，完成"+url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
