package designpatterns;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList classProductList;

	Person thePerson;

	public boolean login(UserInfoItem userinfodetail) throws IOException {
		System.out.println("Enter Username: ");
		Scanner sc = new Scanner(System.in);
		String userName = sc.next();
		userinfodetail.setUserName(userName);
		System.out.println("Enter Password: ");
		String password = sc.next();
		userinfodetail.setPassword(password);
		while (true) {
			System.out.println("Choose any one of the option: ");
			System.out.println("1. Customer Login ");
			System.out.println("2. Seller Login ");
			UserType = sc.nextInt();
			if (UserType == 1) { 
				userinfodetail.setUserType(userinfodetail.userTypes.BUYER);
				break;
			} else if (UserType == 2) {
				userinfodetail.setUserType(userinfodetail.userTypes.SELLER);
				break;
			} else {
				System.out.println("Incorrect selection");
			}
		}
		System.out.println("Logging In as " + userinfodetail.getUserType());
		Login login = new Login();
		boolean loginattempt = login.validateCredentials(userinfodetail);
		if (loginattempt) {
			System.out.println("Login Successful");
			return true;
		} else {
			System.out.println("Login Failed");
			return false;
		}
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {
		System.out.println("Visitor Design");
		System.out.println(" Perform some functionalities on \r\n"
				+ "struture without altering the lements of the class \n");
		Reminder remind = new Reminder();
		remind.checkProductRemainder(classProductList);

	}

	/**
	 *  
	 */
	public void createUser(UserInfoItem userinfoitem) {
		System.out.println("Creat types of user" + userinfoitem.getUserType());
		if (userinfoitem.getUserType() == UserInfoItem.UserType.BUYER) {
			
			thePerson = new Buyer();

		} else {
			
			thePerson = new Seller();
		}
		thePerson.setUserName(userinfoitem.getUserName());

	}

	public void createProductList() throws IOException {
		try {
			try {
				System.out.println("Creat list of products for the user" + thePerson.getUserName());
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		classProductList.readProductFromFile();

	}

	
	public void AttachProductToUser() throws IOException{
		try {
			System.out.println("Attaching products to the user " + thePerson.getUserName());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("src\\UserProduct.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] nameNdProduct = line.split(":");
			if (nameNdProduct[0].equals(thePerson.getUserName())) {
				for (Product c : classProductList) {
					if (c.getProductName().equals(nameNdProduct[1])) {
						thePerson.addProduct(c);
					}
				}
			}
		}

	}

	public Product SelectProduct() {
		System.out.println("Iterator Design");
		System.out.println(
				"It iterates over the product list to get the product chosen by the user :" + thePerson.getUserName());
		ProductIterator pi = new ProductIterator(thePerson.getProductList());
		int i = 0;
		while (pi.hasNext()) {
			System.out.println(i + ". " + pi.Next().getProductName());
			i++;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Select any product :");
		int selection = sc.nextInt();
		System.out.println("0. MeatProductMenu");
		System.out.println("1. ProduceProductMenu");
		System.out.println("Select product category between 0 or 1:");
		nProductCategory = sc.nextInt();
		theSelectedProduct = new Product(thePerson.getProductList().get(selection).getProductName(),nProductCategory);
		thePerson.setSelectedProduct(theSelectedProduct);
		System.out.println(
				"Product opted is " + theSelectedProduct.getProductName() + " " + ProductMenu.ProductCategory.values()[nProductCategory]);
		
		return theSelectedProduct;
	}

	public void productOperation() {
		int i = 1;
		System.out.println("Select Functionality");
		System.out.println(i + ". Load producs");
		i++;
		System.out.println(i + ". Show the products");
		i++;
		System.out.println(i + ". Choose another product");
		i++;
		if (thePerson instanceof Buyer) {
			System.out.println(i + ". Remind");
			i++;
		}
		System.out.println(i + ". Logout");
		Scanner sc = new Scanner(System.in);
		int selectedOperation = sc.nextInt();
		switch (selectedOperation) {
		case 1:
			selectedOperation = 1; {
			System.out.println("Factory Design");
			System.out.println("Initiating product menu based on the category of the product selected\n");
			thePerson.CreateProductMenu();
			break;
		}
		case 2:
			selectedOperation = 2; {
			if (thePerson.productMenu != null) {
				System.out.println("Bridge Design");
				System.out.println("Displays products based on product category selected and login \n");
				thePerson.productMenu.showMenu();
			} else {
				System.out.println("Factory Design");
				System.out.println("Initiating product menu based on the category of the product selected\n");
				thePerson.CreateProductMenu();
			}
			break;
		}
		case 3:
			selectedOperation = 3; {
			SelectProduct();
			break;
		}
		case 4:
			selectedOperation = 4; {
			if (i == 5) {
				remind();
			} else {
				System.out.println("Log out successful");
				System.exit(0);
			}
			break;
		}
		case 5:
			selectedOperation = 5;
			selectedOperation = 4; {
			System.out.println("Log out successful");
			System.exit(0);
			break;
		}
		}

	}

}
