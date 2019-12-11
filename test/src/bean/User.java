package bean;

public class User {
	private int id;
	private String user;
	private String password;
	private String role="0";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	public User(int id, String user, String password, String role) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.role = role;
	}
	public User(int id, String user, String password) {
		this.id = id;
		this.user = user;
		this.password = password;
	}
	
	public User() {}
}
