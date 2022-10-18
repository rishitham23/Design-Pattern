package designPattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ptbs {

	private static Object ProductList;

	public static void main(String[] args) throws IOException {
		
		System.out.println("Facade ");
		Facade facade = new Facade();
		Map<String,Object> authResponse = facade.login();
		if((boolean) authResponse.get("loginStatus")) {
			System.out.println("Welcome "+authResponse.get("thePerson"));
			System.out.println(" 0  to continue \n 1 to logout");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int consoleLog = sc.nextInt();
			if(consoleLog == 1) {
				System.out.println("Logged out Successfully");
				facade.login();
			}else if(consoleLog == 0){
				System.out.println("Iterator ");
				String inputProductFile = "./src/ProductInfo.txt";
				FileReader ProductInfoFile;
				String[] productList = new String[15];
				int i = 0;
				try {
					ProductInfoFile = new FileReader(inputProductFile);
					@SuppressWarnings("resource")
					BufferedReader ProdRead = new BufferedReader(ProductInfoFile);
				    String product = ProdRead.readLine();
				    while (product != null) {
				    	productList[i] = product;
				    	i++;
				    	product = ProdRead.readLine();
				    }
				} catch (FileNotFoundException e) {
					System.out.println("Error,try again!");
				}
				ProductIterator ci = new ProductIterator(ProductList);
				System.out.println("Select the  Produc: ");
				ci.createIterator();
				while(ci.hasNext()) {
					ci.next().forEach((key, value) -> System.out.println(" "+key + " : " + value));
				}
				int ProductChoice = sc.nextInt();
				String selectedProduct = productList[ProductChoice-1];
				System.out.println("select Product Level "+selectedProduct);
				System.out.println(" 0 : ProduceProductMenu \n 1 : MeatProductMenu");
				int choice = sc.nextInt();
				String ProductLevel = (choice == 1) ? "MeatProductMenu" : "ProduceProductMenu";
				System.out.println("You selected '"+selectedProduct+"' with Product level '"+ProductLevel+"' for seller '"+authResponse.get("thePerson")+"'");
				System.out.println("Choose one  ");
				System.out.println(" 0 : Create Product Menu \n 1 : Show Menu \n 2 : Reminder \n 3 : Logout");
				int option = sc.nextInt();
				if(option == 0) {
					System.out.println(" Factory ");
					
					if(true) {
						new Seller(null).CreateProductMenu(authResponse.get("thePerson"),selectedProduct, ProductLevel);
					}else {
						new Buyer(null).CreateProductMenu(authResponse.get("thePerson"),selectedProduct, ProductLevel);
					}
				}else if(option == 1) {
				 System.out.println("Show Product Menu");
				}else if(option == 2) {
					System.out.println("Reminder");
				}else if(option == 3) {
					System.out.println("Logged out Successfully!");
					facade.login();
				}else {
					System.out.println("Invalid option");
				}
				System.out.println("\nDo you want to proceed?");
				System.out.println(" 0 : NO \n 1 : YES");
				int confirm = sc.nextInt();
				if(confirm == 0) {
					System.out.println("Cancelled.");
				}else if(confirm == 1) {
					System.out.println("Bridge");
					System.out.println("Create Product menu ");
					System.out.println("Send product level to the user type");
					
					 Person seller = new Seller(new MeatProductMenu());
				     seller.ProductMenu();

				     System.out.println("\nVisitor");
				}else {
					System.out.println("Invalid option, please try again!");
				}
			}else {
				System.out.println("Invalid option, please try again!");
			}
		}
		
	}
}
