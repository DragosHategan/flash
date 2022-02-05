package model;

public class Book {
	private String name;

	public Book(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}
}
