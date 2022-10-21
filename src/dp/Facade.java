package dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Facade {
	private  List<Product> productList;

	private int User_choice;

	private Product selectedProduct;

	private int nProductCategory;

	private ClassProductList classProductList;

	Person thePerson;

	@SuppressWarnings("static-access")
	public boolean login(UserInfoItem userinfodetail) throws IOException {
		System.out.println("Enter User Name: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String user_name = sc.next();
		userinfodetail.setUserName(user_name);
		System.out.println("Enter Password: ");
		String password = sc.next();
		userinfodetail.setPassword(password);
		while (true) {
			System.out.println("Choose an option: ");
			System.out.println("0. Login as Buyer ");
			System.out.println("1. Login as Seller ");
			User_choice = sc.nextInt();
			if (User_choice == 0) { 
				userinfodetail.setUserType(userinfodetail.userTypes.BUYER);
				break;
			} else if (User_choice == 1) {
				userinfodetail.setUserType(userinfodetail.userTypes.SELLER);
				break;
			} else {
				System.out.println("selection incorrect");
			} 
			
		}
		System.out.println("Logging as " + userinfodetail.getUserType());
		Login login = new Login();
		boolean loginattempt = login.validateCredentials(userinfodetail);
		if (loginattempt) {
			System.out.println("Login Success");
			return true;
		} else {
			System.out.println("Login Fail");
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

	public void remind() {                                       //visitor design  
		Reminder remind = new Reminder();                           
		remind.checkProductRemainder(classProductList);

	}

	public void createUser(UserInfoItem userinfoitem) {
		System.out.println("Create types of user" + userinfoitem.getUserType());
		if (userinfoitem.getUserType() == UserInfoItem.UserType.BUYER) {
			
			thePerson = new Buyer();

		} else {
			
			thePerson = new Seller();
		}
		thePerson.setUserName(userinfoitem.getUserName());

	}

	public List<Product> createProductList() {
		productList = new ArrayList<Product>();
		try {
			String filepath="C:/Users/rmalempa/Desktop/Rishitha/SER 515/IndividualAssignment/src/database/ProductInfo.txt/";
	        File f = new File(filepath);
	        FileReader fr= new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				Product c = new Product(line,0);
				productList.add(c);
			}
			fr.close();
			System.out.println("Create list of products for " + thePerson.getUserName());
			return productList;
			}
		catch (Exception e)
		{
		  e.printStackTrace();
		}
        return null;
	}

	
	public void AttachProductToUser() throws IOException{
		try {
			System.out.println("Attaching products to " + thePerson.getUserName());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		String filepath="C:/Users/rmalempa/Desktop/Rishitha/SER 515/IndividualAssignment/src/database/UserProduct.txt/";
        File f = new File(filepath);
        FileReader fr= new FileReader(f);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
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

	@SuppressWarnings("unchecked")
	public Product SelectProduct() {                   //Iterator design
		@SuppressWarnings("rawtypes")
		ProductIterator pi = new ProductIterator(thePerson.getProductList());
		int a = 0;
		while (pi.hasNext()) {
			System.out.println(a + ")" + pi.Next().getProductName());
			a++;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a product:");
		int selection = sc.nextInt();
		System.out.println("0. MeatProductMenu");
		System.out.println("1. ProduceProductMenu");
		nProductCategory = sc.nextInt();
		selectedProduct = new Product(thePerson.getProductList().get(selection).getProductName(),nProductCategory);
		thePerson.setSelectedProduct(selectedProduct);
		sc.close();
		System.out.println(
				"Selected product is " + selectedProduct.getProductName() + " from category " + ProductMenu.ProductCategory.values()[nProductCategory]);
		
		return selectedProduct;
	}
	
	

	public void productOperation() {
		int i = 1;
		System.out.println("Select Functionality");
		System.out.println(i + ")" + "Load products");
		i++;
		System.out.println(i + ")" + "Show the products selected");
		i++;
		System.out.println(i + ")" + "Add another product");
		i++;
		if (thePerson instanceof Buyer) {
			System.out.println(i + ")" + "Remind");
			i++;
		}
		System.out.println(i + ")" + "Logout");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int selectedOperation = sc.nextInt();
		switch (selectedOperation) {
		case 1:
			selectedOperation = 1; {                //for Factory Design
			thePerson.CreateProductMenu();
			break;
		}
		case 2:
			selectedOperation = 2; {
			if (thePerson.productMenu != null) {       //Bridge Design
				thePerson.productMenu.showMenu();
			} else {
				thePerson.CreateProductMenu(); //Processing product menu based on the category of the selected product
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
				System.out.println("Logout successful for the username" + thePerson.getUserName());
				System.exit(0);
			}
			break;
		}
		case 5:
			selectedOperation = 5;
			selectedOperation = 4; {
			System.out.println("Logout success for" + thePerson.getUserName());
			System.exit(0);
			break;
		}
		}
		

	}

}
