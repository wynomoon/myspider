package edu.csuft.wuyue.spider;


public class Film implements Comparable<Film> {
/**
 * 影片名称
 */
String title;
	
/**
 * 相关信息
 */
String info;

/**
 * 影片评分
 */
Double rating;

/**
 * 评分人数
 */
int num;

/**
 * 排名
 */
int id;

/**
 * 海报
 */
String poster;

/**
 * 短评
 */
String quote;



public String toCSV() {
	return String.format("%d,%s,%d,%.1f\n",
			id,
			title,
			num,
			rating
			);
}



@Override
public String toString() {
	return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
			+ ", poster=" + poster + ", quote=" + quote + "]";
}


@Override
public int compareTo(Film o) {
	// TODO Auto-generated method stub
	return id-o.id;
}




}
