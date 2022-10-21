package dp;

import java.io.IOException;

public class PTBSMain {
	static Facade facade = new Facade();
	

	public static void main(String[] args) throws IOException {
	
		boolean logout = false;
		UserInfoItem userinfoitem = new UserInfoItem();
		//Facade Design

		boolean loginResult = facade.login(userinfoitem);
		if (loginResult) {
			facade.createUser(userinfoitem);
			facade.createProductList();
			facade.AttachProductToUser();
			facade.SelectProduct();

			while (!logout) {
				facade.productOperation();
			}
		}

	}
		

}
