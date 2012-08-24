package mang.util;
/**
 * create:17:02 2012-8-24
 * last modify:17:02 2012-8-24
 * @author mang
 * 功能：java程序调用系统命令示例。这里调用了windows的cmd命令执行了RuncmdTest.bat
 * 执行说明：执行时把RuncmdTest.bat拷备到 d:\test\run路径下方能正确执行。要不找不见路径. RuncmdTest.bat目前放在本项目lib目录下。该批处理完成简单的定制，一看就明白。
 * */

import java.io.IOException;

public class RunCmd {
	
	public static void main(String[] args) {
		/*
		 *参考自 Java调用系统命令或可执行程序的方法介绍 http://developer.51cto.com/art/200909/149554.htm
		 *基本原理是，首先通过 Runtime.getRuntime() 返回与当前Java 应用程序相关的运行时对象，然后调用run.exec(cmd)  另启一个进程来执行命令（cmd为要执行的命令）
		 *其它说明：参考中还有如何把执行结果输出到控制台  用数组存储有参数的执行文件等。可进一步挖掘 
		 * */
		/*
		 * 如果直接写成 cmd ="path"则运行程序后没反应.批处理得由cmd.exe执行启动也是有道理的。
		 * 那如果在linux下执行就得用 /bin/sh /c path 了
		 * */
		String cmd="cmd.exe /c start D:\\test\\run\\RuncmdTest.bat"; 
		Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象 
		try {
			Process p = run.exec(cmd);// 启动另一个进程来执行命令   
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
