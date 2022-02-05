package dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MainMenu {

	private List<AbstractDialog> dialogs = new ArrayList<>();

	public static void main(String[] args) {
		MainMenu mm = new MainMenu();
		mm.run();
	}

	private void run() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Main menu");
		Menu bar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(bar);

		configureDialogs();

		createMenu(display, bar);

		shell.setSize(600, 400);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private void createMenu(Display display, Menu bar) {
		for (AbstractDialog dialog : dialogs) {
			MenuItem item = new MenuItem(bar, SWT.PUSH);
			item.addListener(SWT.Selection, e -> {
				dialog.open(display);
			});
			item.setText(dialog.getTitle());
		}
	}

	private void configureDialogs() {
		dialogs.add(new ExampleDialog());
		dialogs.add(new ExampleDialog2());
		dialogs.add(new BooksDialog());
	}

}