/**
 * @author mang
 * create:23:33 2012-7-25 
 * last modify:23:33 2012-7-25
 * ���ܣ�StringTokenizer�����ϰ��StringTokenizer��һ�������ָ�String��Ӧ���࣬�൱��VB��split����
 * */
package mang.string;
import java.util.StringTokenizer;


public class wordToken {
	static public void main(String args[]){
		String s ="wo shi zhong guo ren ";
		/*
		**���캯��
		public StringTokenizer(String str)
		public StringTokenizer(String str, String delim)
		public StringTokenizer(String str, String delim, boolean returnDelims)
		��һ����������Ҫ�ָ���String���ڶ����Ƿָ��ַ����ϣ�������������ʾ�ָ������Ƿ���Ϊ��Ƿ��أ������ָ���ָ��ַ���Ĭ�ϵ��ǣ���\t\n\r\f��
		*/
		StringTokenizer itr = new StringTokenizer(s);
		while( itr.hasMoreElements() ){
			System.out.println( itr.nextToken());
		}
		
		String s2 = new String("The=Java=platform=is=the=ideal=platform=for=network=computing");
		StringTokenizer st = new StringTokenizer(s2,"=",false);//�����ֹ��캯��������
		System.out.println( "Token Total: " + st.countTokens() );
		
		while( st.hasMoreElements() ){
		System.out.println( st.nextToken() );
		}
	}

}
