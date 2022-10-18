package designpatterns;

import java.io.IOException;

public class PTBSSystem {
	static Facade facade = new Facade();
	

	public static void main(String[] args) throws IOException {
	
		boolean logout = false;
		UserInfoItem userinfoitem = new UserInfoItem();
		System.out.println("Facade Design");
		System.out.println("Making the additional modules simpler for a cleaner interface.");
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
