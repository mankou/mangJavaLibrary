/**
 * @author mang
 * create:2011年11月30日 lastModify:2011年11月30日
 * 
 * 该文件是在SWT程序（这里指用windowsbuilder 生成的SWT程序，本例中有稍许改动，主要是把一些局部变量改为成员变量）实现进度条*/
package mang.sample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarSWT {

	Display display;
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProgressBarSWT window = new ProgressBarSWT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		/*实现进度条的代码来自于《JFace核心169页》*/
		shell = new Shell(display,SWT.NO_TRIM);
		shell.setSize(150, 60);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout());
		final ProgressBar progressBar = new ProgressBar(shell,SWT.HORIZONTAL);
		progressBar.setMaximum(100);
		progressBar.setMinimum(1);
		final int maximun = progressBar.getMaximum();
		final int minimus = progressBar.getMinimum();
		
		Runnable runnable = new Runnable(){
			public void run(){
				for(int i = minimus;i<maximun;i++){
					try{
						Thread.sleep(100);						
					}catch(InterruptedException e){
						System.out.println("wrong");
					}
					
					display.asyncExec(new Runnable(){
						public void run(){
							if(progressBar.isDisposed())
								return;
							progressBar.setSelection(progressBar.getSelection()+1);
						
						};
					});
				
				}
			}
		};
		
		new Thread(runnable).start();
		

	}

}
