/**
 * create:2011��12��8��
 * last modify:2011��12��8��
 * @author mang
 * ���ܣ�����ip��ַ*/
package mang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PraseIP {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str = "con.202.201.14.104";
		String str ="confine.127.0.0.1";
//		String str="abc$31.8zhe";
		  
//		  String reg = "[^0-9.]";
		  String reg="\\d+\\.\\d+\\.\\d+\\.\\d+";
		  Pattern p = Pattern.compile(reg);
		  Matcher m = p.matcher(str);
		  System.out.println(m);
		  
//		  System.out.println(m.replaceAll("").trim());
		  if(m.find()){System.out.println(m.group());}


	}

}
