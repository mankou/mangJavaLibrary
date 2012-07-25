/**
 * @author mang
 * create:2011��11��30�� lastModify:2011��11��30��
 * 
 * ���ļ�����SWT��������ָ��windowsbuilder ���ɵ�SWT���򣬱�����������Ķ�����Ҫ�ǰ�һЩ�ֲ�������Ϊ��Ա������ʵ�ֽ�����*/
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
		/*ʵ�ֽ������Ĵ��������ڡ�JFace����169ҳ��*/
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
