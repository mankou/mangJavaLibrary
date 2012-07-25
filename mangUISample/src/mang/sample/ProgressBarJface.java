/**
 * @author mang
 * create:2011年11月30日 lastModify:2011年11月30日
 * 
 * 该文件是在Jface程序（这里指用windowsbuilder 生成的jface程序）基础上实现进度条*/
package mang.sample;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.decorators.FullTextDecoratorRunnable;

public class ProgressBarJface extends ApplicationWindow {

	private static ProgressBarJface app;//用于指向自己，见代码40行
	

	public static ProgressBarJface getApp() {
		return app;
	}

	public void setApp(ProgressBarJface app) {
		this.app = app;
	}

	/**
	 * Create the application window.
	 */
	public ProgressBarJface() {
		super(null);
		app=this;
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
//		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		/*创建进度条的代码参考自《Jface核心169页 进度条》但其中display.asyncExec()来自于《Jface核心301页 带有状态栏 的主程序窗口》
		 * */
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		final ProgressBar progressBar = new ProgressBar(container,SWT.HORIZONTAL);
		progressBar.setMaximum(100);
		progressBar.setMinimum(1);
		final int maximun = progressBar.getMaximum();
		final int minimus = progressBar.getMinimum();
		
		Runnable runnable = new Runnable(){//匿名内部
			public void run(){
				for(int i = minimus;i<maximun;i++){
					try{
						Thread.sleep(100);						
					}catch(InterruptedException e){
						System.out.println("wrong");
					}
					/*得到display的方法来自于《Jface核心301页 》*/
					ProgressBarJface.getApp().getShell().getDisplay().asyncExec(new Runnable(){
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
		
		return container;

	}



	

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ProgressBarJface window = new ProgressBarJface();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("进度条");
		newShell.setSize(150,60);
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
