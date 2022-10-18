package designpatterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	public boolean validateCredentials(UserInfoItem userinfoitem) throws IOException {

		BufferedReader br = null;
		if (userinfoitem.userTypes.equals(UserInfoItem.UserType.BUYER)) {
			br = new BufferedReader(new FileReader("/Users/vhps/Desktop/designpatterns/src/BuyerInfo.txt/"
					+ ""));
		} else if (userinfoitem.userTypes.equals(UserInfoItem.UserType.SELLER)) {
			br = new BufferedReader(new FileReader("/Users/vhps/Desktop/designpatterns/src/SellerInfo.txt/"));
		}
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] credentials = line.split(":");
			if (credentials[0].equals(userinfoitem.getUserName())
					&& credentials[1].equals(userinfoitem.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
