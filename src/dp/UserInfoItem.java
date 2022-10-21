package dp;

public class UserInfoItem {
	private String user_Name;
	private String password;

	public enum UserType {
		BUYER, SELLER
	}

	UserType userTypes;

	

	public String getUserName() {

		return user_Name;
	}

	
	public void setUserName(String user_Name) {

		this.user_Name = user_Name;
	}

	
	public String getPassword() {

		return password;
	}

	
	public void setPassword(String password) {

		this.password = password;
	}

	

	public UserType getUserType() {

		return userTypes;
	}

	

	public void setUserType(UserType user_Type) {

		this.userTypes = user_Type;
	}

}
