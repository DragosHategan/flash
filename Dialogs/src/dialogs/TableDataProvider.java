package dialogs;

import java.util.List;

public interface TableDataProvider {
	String[] getColumnHeaders();

	List<Object[]> getTableData();
}
