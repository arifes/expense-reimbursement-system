package pojo;

public class UserPojo {
	private int UserId;
	private String FirstName;
	private String LastName;
	private String Password;
	private String Role; //boolean due to only 2 possibilities? 
	private String emailAdress;
	
	public UserPojo() {
	}

	public UserPojo(int userId, String firstName, String lastName, String password, String role, String emailAdress) {
		super();
		UserId = userId;
		FirstName = firstName;
		LastName = lastName;
		Password = password;
		Role = role;
		this.emailAdress = emailAdress;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	

	@Override
	public String toString() {
		return "UserPojo [UserId=" + UserId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Password="
				+ Password + ", Role=" + Role + ", emailAdress=" + emailAdress + "]";
	}
	
		


}
