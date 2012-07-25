/**
 * {create:2011��12��14��22ʱ02��28��}{last modify:2011��12��14��22ʱ02��34��}
 * @author mang
 * @version 1.0
 * ����:����XML�ĵ�,������Ҫ����Documentʵ��,�ļ�·��
*/
package mang.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXML {
	
	protected static void write(Document document,String path){
		try {
			// ������ʽ����
			OutputFormat format = OutputFormat.createPrettyPrint();
			// ���ñ����ʽ��Ĭ��UTF-8
			format.setEncoding("UTF-8");
			// ������������˴�Ҫʹ��Writer����Ҫָ����������ʽ��ʹ��OutputStream����
			FileOutputStream fos = new FileOutputStream(path);
			// ����xml�����
			XMLWriter writer = new XMLWriter(fos, format);
			// ����xml�ļ�
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
