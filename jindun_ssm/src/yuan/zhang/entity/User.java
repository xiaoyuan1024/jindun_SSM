package yuan.zhang.entity;

public class User {
	private String username;
	private String password;
	private int LTID;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, int LTID) {
		super();
		this.username = username;
		this.password = password;
		this.LTID = LTID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLTID() {
		return LTID;
	}
	public void setLTID(int LTID) {
		this.LTID = LTID;
	}
}
