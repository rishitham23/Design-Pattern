package designPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Seller extends Person {

	public Seller(ProductMenu theProductMenu) {
		super(theProductMenu);
		// TODO Auto-generated constructor stub
	}

	public void showMenu() {

	}

	public ProductMenu CreateProductMenu(Object Obj, String SelectProduct,String ProductLevel) {
		Map<Object ,Set<String>> SellerProduct = new HashMap<Object,Set<String>>();
		Set<String> setP = new HashSet<String>();
		setP.add((SelectProduct.concat("-")).concat(ProductLevel));
		SellerProduct.put(Obj, setP);
		System.out.println(" ");
		System.out.println("Sample Output: "+SellerProduct);
		return null;
	}

}