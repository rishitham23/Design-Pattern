package designpatterns;

public class UserInfoItem {
	private String userName;
	private String password;

	public enum UserType {
		BUYER, SELLER
	}

	UserType userTypes;

	

	public String getUserName() {

		return userName;
	}

	
	public void setUserName(String userName) {

		this.userName = userName;
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

	

	public void setUserType(UserType userType) {

		this.userTypes = userType;
	}

}
