package designpatterns;
public class Product {

	String pName;
	private int nProductCategory;
	
	private Trading trading;

	private ClassProductList classProductList;
	
	public Product(String productName, int category) {
		this.pName= productName;
		this.nProductCategory=category;
	}


	public String getProductName() {

		return pName;
	}

	

	public void setProductName(String theProductName) {

		this.pName = theProductName;
	}

	

	public int getProductCategory() {

		return nProductCategory;
	}

	

	public void setProductCategory(int theNProductCategory) {

		this.nProductCategory = theNProductCategory;
	}

	public void accept(NodeVisitor visitor) {

		System.out.println("Accept the Method in Product class category");
		visitor.visitProduct(this);
	}
}
