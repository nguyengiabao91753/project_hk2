package entity;

public class Account {
	private int Account_id ;
	private String Username;
	private String Password;
	private int id;
	private String username;
	private String password;
	private int status;
	
	public Account() {
		
	}
	/**
	 * @param account_id
	 * @param usserName
	 * @param password
	 */
	public Account(int account_id, String Username, String password) {
		super();
		this.Account_id = account_id;
		this.Username = Username;
		this.Password = password;
	}

	public int getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(int account_id) {
		Account_id = account_id;
	
	}
	public Account(int id, String username, String password, int status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String usserName) {
		Username = usserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	

	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {

		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status + "]";
	}


	
}
