/**
 * @author mang
 * create:23:33 2012-7-25 
 * last modify:23:33 2012-7-25
 * 功能：StringTokenizer类的练习，StringTokenizer是一个用来分隔String的应用类，相当于VB的split函数
 * */
package mang.string;
import java.util.StringTokenizer;


public class wordToken {
	static public void main(String args[]){
		String s ="wo shi zhong guo ren ";
		/*
		**构造函数
		public StringTokenizer(String str)
		public StringTokenizer(String str, String delim)
		public StringTokenizer(String str, String delim, boolean returnDelims)
		第一个参数就是要分隔的String，第二个是分隔字符集合，第三个参数表示分隔符号是否作为标记返回，如果不指定分隔字符，默认的是：”\t\n\r\f”
		*/
		StringTokenizer itr = new StringTokenizer(s);
		while( itr.hasMoreElements() ){
			System.out.println( itr.nextToken());
		}
		
		String s2 = new String("The=Java=platform=is=the=ideal=platform=for=network=computing");
		StringTokenizer st = new StringTokenizer(s2,"=",false);//第三种构造函数举例，
		System.out.println( "Token Total: " + st.countTokens() );
		
		while( st.hasMoreElements() ){
		System.out.println( st.nextToken() );
		}
	}

}
