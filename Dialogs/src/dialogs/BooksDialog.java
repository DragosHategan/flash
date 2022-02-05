package dialogs;

public class BooksDialog extends AbstractDialog {

	TableDataProvider tableDataProvider = new BookTableDataProvider();

	public BooksDialog() {
		super("Books");
	}

	@Override
	public TableDataProvider getTableDataProvider() {
		return tableDataProvider;
	}

}
