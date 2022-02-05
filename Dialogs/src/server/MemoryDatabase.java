package server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.User;

public class MemoryDatabase implements Serializable, Database {
	private static final long serialVersionUID = 2L;

	private List<User> users = new ArrayList<>();
	private List<Book> books = new ArrayList<>();

	public MemoryDatabase() {
		init();
	}

	private void init() {
		addUser("ghita", "ghita", false);
		addUser("ion", "ion", true);
		addBook("Arta negocierii");
		addBook("Teste de bac");
		addBook("Creierul idiot");
	}

	@Override
	public User addUser(String name, String password, boolean admin) {
		User user = new User(name, password, admin);
		users.add(user);
		return user;
	}

	@Override
	public void addBook(String name) {
		Book book = new Book(name);
		books.add(book);
	}

	@Override
	public List<User> findAllUsers() {
		return users;
	}

	@Override
	public List<Book> findAllBooks() {
		return books;
	}

}
