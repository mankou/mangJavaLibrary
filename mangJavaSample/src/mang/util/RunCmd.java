package mang.util;
/**
 * create:17:02 2012-8-24
 * last modify:17:02 2012-8-24
 * @author mang
 * ���ܣ�java�������ϵͳ����ʾ�������������windows��cmd����ִ����RuncmdTest.bat
 * ִ��˵����ִ��ʱ��RuncmdTest.bat������ d:\test\run·���·�����ȷִ�С�Ҫ���Ҳ���·��. RuncmdTest.batĿǰ���ڱ���ĿlibĿ¼�¡�����������ɼ򵥵Ķ��ƣ�һ�������ס�
 * */

import java.io.IOException;

public class RunCmd {
	
	public static void main(String[] args) {
		/*
		 *�ο��� Java����ϵͳ������ִ�г���ķ������� http://developer.51cto.com/art/200909/149554.htm
		 *����ԭ���ǣ�����ͨ�� Runtime.getRuntime() �����뵱ǰJava Ӧ�ó�����ص�����ʱ����Ȼ�����run.exec(cmd)  ����һ��������ִ�����cmdΪҪִ�е����
		 *����˵�����ο��л�����ΰ�ִ�н�����������̨  ������洢�в�����ִ���ļ��ȡ��ɽ�һ���ھ� 
		 * */
		/*
		 * ���ֱ��д�� cmd ="path"�����г����û��Ӧ.���������cmd.exeִ������Ҳ���е���ġ�
		 * �������linux��ִ�о͵��� /bin/sh /c path ��
		 * */
		String cmd="cmd.exe /c start D:\\test\\run\\RuncmdTest.bat"; 
		Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ���� 
		try {
			Process p = run.exec(cmd);// ������һ��������ִ������   
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
