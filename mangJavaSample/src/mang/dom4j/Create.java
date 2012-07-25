/**
 * {create:2011��12��14��22ʱ08��30��}{last modify:2011��12��14��22ʱ08��36��}
 * @author mang
 * @version 1.0
 * ����:����һ��XML�ļ�
 * ˵��:����������dom4j�ӻ�������ͨ.docx*/
package mang.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Create {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		// �����ĵ�DocType������Ϊ�˾��������hibernate��DocType
		document.addDocType("hibernate-configuration",
						"-//Hibernate/Hibernate Configuration DTD 3.0//EN",				"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd");
		// �ĵ����ӽڵ㣬�����ڵ㣬һ���ĵ�ֻ����һ�����ڵ㣬��ӳ���
		Element root = document.addElement("skills");
		// ���ע��
		root.addComment("��һ������");
		// ���ڵ�����ӽڵ�
		Element first = root.addElement("skill");
		// �ڵ��������
		first.addAttribute("name", "���¾Ž�");
		// �ڵ�����ӽڵ�
		Element info = first.addElement("info");
		// �ڵ�������������
		info.setText("Ϊ��������������仯��ǧ�������ޱȡ��䴫����Ҫ�з��������塣");

		// ͬ�����������ڵ㣬���ݣ����Ե�
		Element second = root.addElement("skill");
		second.addAttribute("name", "��������");
		Element info2 = second.addElement("info");
		info2.setText("�¹�������������������������������书��ʱ������Ҫ�Թ�����");
		
		/**
		 * �ڶ��ַ������ӽڵ㣬���ݣ����Եȡ��ȴ����ڵ㣬���ԣ�Ȼ��ʹ��add���롣
		 */
		// �����ڵ�
		Element third = DocumentHelper.createElement("skill");
		// ���ڵ���뵽���ڵ���
		root.add(third);
		// �������ԣ���һ������ָ����ӵ���ߣ�Ҳ����Ϊnull��ָ��ӵ����
		Attribute name = DocumentHelper.createAttribute(third, "name", "��ڤ��");
		// �����Լ��뵽�ڵ���
				third.add(name);
				// �����ӽڵ㲢���뵽�ڵ���
				Element info3 = DocumentHelper.createElement("info");
				info3.setText("��ң�ɵĶ����ڹ�֮һ������������ת��Ϊ�Լ����У��������");
				third.add(info3);

				try {
					// ������ʽ����
					OutputFormat format = OutputFormat.createPrettyPrint();
					// ���ñ����ʽ��Ĭ��UTF-8
					format.setEncoding("UTF-8");
					// ������������˴�Ҫʹ��Writer����Ҫָ����������ʽ��ʹ��OutputStream����
					FileOutputStream fos = new FileOutputStream("d:/test/dom4j/skills.xml");
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
