/**
 * {create:2011年12月14日22时02分28秒}{last modify:2011年12月14日22时02分34秒}
 * @author mang
 * @version 1.0
 * 功能:创建XML文档,参数中要给出Document实例,文件路径
*/
package mang.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXML {
	
	protected static void write(Document document,String path){
		try {
			// 创建格式化类
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 设置编码格式，默认UTF-8
			format.setEncoding("UTF-8");
			// 创建输出流，此处要使用Writer，需要指定输入编码格式，使用OutputStream则不用
			FileOutputStream fos = new FileOutputStream(path);
			// 创建xml输出流
			XMLWriter writer = new XMLWriter(fos, format);
			// 生成xml文件
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
