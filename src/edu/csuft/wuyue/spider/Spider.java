package edu.csuft.wuyue.spider;
/**
 * ץȡӰƬ��Ϣ
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
	 * ҳ��·��(URl)
	 */
	String url;
	/**
	 * �洢ץȡ������
	 */
	ArrayList<Film>list;
	/**
	 * ��������
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
		//���ִ�и�������̵߳�����
		String name=Thread.currentThread().getName();
		System.out.println(name+"�̣߳�����"+url);
		
		//JSOUP
		try {
			Document doc= Jsoup.connect(url).get();
			//���ĵ��������в��ҽڵ�
			Elements es= doc.select(".grid_view .item");
			
//			//Ŀ�� URL
//			String url="https://movie.douban.com/top250";
//			//ʹ��JSOUPץȡ�ĵ�
			
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
//				//����һ��ӰƬ���б�
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
			
			System.out.println(name+"�̣߳����"+url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
