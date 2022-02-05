package dialogs;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class ExampleDialogTableDataProvider implements TableDataProvider {

	private static final String[] HEADERS = new String[] { "User", "Password", "Admin" };

	@Override
	public String[] getColumnHeaders() {
		return HEADERS;
	}

	@Override
	public List<Object[]> getTableData() {
		List<Object[]> result = new ArrayList<>();

		List<User> users = ApplicationSession.getInstance().getDatabase().findAllUsers();

		for (User user : users) {
			result.add(new Object[] { user.getName(), user.getPassword(), user.isAdmin() });
		}

		return result;
	}

}
