/**
 * {create:2011年12月14日22时08分30秒}{last modify:2011年12月14日22时08分36秒}
 * @author mang
 * @version 1.0
 * 功能:创建一个XML文件
 * 说明:代码来自于dom4j从基础到精通.docx*/
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
		// 设置文档DocType，这里为了举例，添加hibernate的DocType
		document.addDocType("hibernate-configuration",
						"-//Hibernate/Hibernate Configuration DTD 3.0//EN",				"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd");
		// 文档增加节点，即根节点，一个文档只能有一个根节点，多加出错
		Element root = document.addElement("skills");
		// 添加注释
		root.addComment("第一个技能");
		// 根节点下添加节点
		Element first = root.addElement("skill");
		// 节点添加属性
		first.addAttribute("name", "独孤九剑");
		// 节点下添加节点
		Element info = first.addElement("info");
		// 节点设置内容数据
		info.setText("为独孤求败所创，变化万千，凌厉无比。其传人主要有风清扬、令狐冲。");

		// 同理增加其他节点，内容，属性等
		Element second = root.addElement("skill");
		second.addAttribute("name", "葵花宝典");
		Element info2 = second.addElement("info");
		info2.setText("宦官所创，博大精深，而且凶险至极。练宝典功夫时，首先要自宫净身。");
		
		/**
		 * 第二种方法增加节点，内容，属性等。先创建节点，属性，然后使用add加入。
		 */
		// 创建节点
		Element third = DocumentHelper.createElement("skill");
		// 将节点加入到根节点中
		root.add(third);
		// 创建属性，第一个参数指定了拥有者，也可以为null，指定拥有者
		Attribute name = DocumentHelper.createAttribute(third, "name", "北冥神功");
		// 将属性加入到节点上
				third.add(name);
				// 创建子节点并加入到节点中
				Element info3 = DocumentHelper.createElement("info");
				info3.setText("逍遥派的顶级内功之一，能吸人内力转化为自己所有，威力无穷。");
				third.add(info3);

				try {
					// 创建格式化类
					OutputFormat format = OutputFormat.createPrettyPrint();
					// 设置编码格式，默认UTF-8
					format.setEncoding("UTF-8");
					// 创建输出流，此处要使用Writer，需要指定输入编码格式，使用OutputStream则不用
					FileOutputStream fos = new FileOutputStream("d:/test/dom4j/skills.xml");
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
