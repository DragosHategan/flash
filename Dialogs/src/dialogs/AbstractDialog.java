package dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public abstract class AbstractDialog {

	protected String title;
	protected List<AbstractButton> actions = new ArrayList<>();

	public AbstractDialog(String title) {
		this.title = title;
		createActions();
		// addColumn("name", String.class, 100, ...)
	}

	public abstract TableDataProvider getTableDataProvider();

	public void open(Display display) {
		Shell shell = new Shell(display);
		shell.setText(title);
		shell.setLayout(new FormLayout());

		Button previous = null;
		for (AbstractButton action : actions) {
			action.create(shell, previous);
			previous = action.getButton();
		}

		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		FormData data = new FormData();
		data.height = 200;
		data.top = new FormAttachment(previous, 0, SWT.BOTTOM);
		data.right = new FormAttachment(100);
		data.left = new FormAttachment(0);
		data.bottom = new FormAttachment(100);

		table.setLayoutData(data);
		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(Arrays.toString(table.getSelection()));
				for (AbstractButton b : actions) {
					b.enableByTableSelection(table.getSelection());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		String[] titles = getTableDataProvider().getColumnHeaders();
		for (String title : titles) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(title);
		}

		List<Object[]> tableData = getTableDataProvider().getTableData();

		for (Object[] d : tableData) {
			TableItem item = new TableItem(table, SWT.NONE);
			for (int i = 0; i < d.length; i++) {
				if (d[i] instanceof String) {
					item.setText(i, d[i].toString());
				} else {
					item.setText(i, d[i].toString());
				}
			}

			// for (Column c : columns) {
			// item.setText(c.getValue())
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		shell.dispose();
	}

	protected void createActions() {

	}

	public String getTitle() {
		return title;
	}

	public void addAction(AbstractButton action) {
		actions.add(action);
	}

}
