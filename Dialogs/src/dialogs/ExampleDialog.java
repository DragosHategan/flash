package dialogs;

import org.eclipse.swt.widgets.TableItem;

public class ExampleDialog extends AbstractDialog {

	TableDataProvider tableDataProvider = new ExampleDialogTableDataProvider();

	public ExampleDialog() {
		super("Example dialog");
	}

	@Override
	public TableDataProvider getTableDataProvider() {
		return tableDataProvider;
	}

	@Override
	protected void createActions() {
		super.createActions();

		addAction(createAddAction());
		addAction(createEditAction());
		addAction(createDeleteAction());
	}

	private AbstractButton createDeleteAction() {
		return new AbstractButton("Delete") {
			@Override
			public void doAction() {
				System.out.println("Delete");
			}

			@Override
			public void enableByTableSelection(TableItem[] selection) {
				getButton().setEnabled(selection.length > 0);
			}
		};
	}

	private AbstractButton createEditAction() {
		return new AbstractButton("Edit") {
			@Override
			public void doAction() {
				System.out.println("Edit");
			}

			@Override
			public void enableByTableSelection(TableItem[] selection) {
				getButton().setEnabled(selection.length == 1);
			}
		};
	}

	private AbstractButton createAddAction() {
		return new AbstractButton("Add") {
			@Override
			public void doAction() {
				System.out.println("Add");
			}
		};
	}

}
