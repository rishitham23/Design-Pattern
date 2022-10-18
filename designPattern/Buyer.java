package designPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Buyer extends Person {
	
	Buyer(ProductMenu prodMenu){
		super(prodMenu);
	}

	public void showMenu() {
		System.out.print("Product Menu created For Buyer");
		
	}

	public ProductMenu CreateProductMenu(Object Obj, String SelectProduct,String ProductLevel) {
	Map<Object ,Set<String>> BuyerProduct = new HashMap<Object,Set<String>>();
	Set<String> setA = new HashSet<String>();
	setA.add((SelectProduct.concat("-")).concat(ProductLevel));
	BuyerProduct.put(Obj, setA);
	System.out.println(" ");
	System.out.println("Sample Output: "+BuyerProduct);
	return null;
	}

}