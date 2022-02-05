package server;

import java.util.List;

import model.Book;
import model.User;

public interface Database {
	public User addUser(String name, String password, boolean admin);

	public List<User> findAllUsers();

	public List<Book> findAllBooks();

	void addBook(String name);
}

