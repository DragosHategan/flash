package model;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String password;
	private boolean admin;

	public User(String name, String password, boolean admin) {
		super();
		this.name = name;
		this.password = password;
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return admin;
	}
}
