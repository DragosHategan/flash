package dialogs;

import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookTableDataProvider implements TableDataProvider {

	@Override
	public String[] getColumnHeaders() {
		return new String[] { "Name" };
	}

	@Override
	public List<Object[]> getTableData() {
		List<Object[]> result = new ArrayList<>();

		List<Book> books = ApplicationSession.getInstance().getDatabase().findAllBooks();

		for (Book b : books) {
			result.add(new Object[] { b.getName() });
		}

		return result;
	}

}
