package dp;

public class Product {

	String pName;
	private int nProductCategory;
	
		
	public Product(String productName, int prod_Category) {
		this.pName= productName;
		this.nProductCategory=prod_Category;
	}


	public String getProductName() {

		return pName;
	}

	

	public void setProductName(String product_Name) {

		this.pName = product_Name;
	}

	

	public int getProductCategory() {

		return nProductCategory;
	}

	

	public void setProductCategory(int product_Category) {

		this.nProductCategory = product_Category;
	}

	public void accept(NodeVisitor visitor) {

		visitor.visitProduct(this);            //accepts the method in product class
	}
}
