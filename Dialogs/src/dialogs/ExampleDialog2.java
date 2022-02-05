package dialogs;

public class ExampleDialog2 extends AbstractDialog {

	TableDataProvider tableDataProvider = new ExampleDialogTableDataProvider();

	public ExampleDialog2() {
		super("My dialog");
	}

	@Override
	public TableDataProvider getTableDataProvider() {
		return tableDataProvider;
	}

}
