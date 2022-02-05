package dialogs;

import server.Database;
import server.MemoryDatabase;

public class ApplicationSession {
	//
	private static ApplicationSession instance;
	private Database database;

	private ApplicationSession() {
		database = new MemoryDatabase();
	}

	public static ApplicationSession getInstance() {
		if (instance == null) {
			instance = new ApplicationSession();
		}
		return instance;
	}

	public Database getDatabase() {
		return database;
	}
}
