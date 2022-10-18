package designPattern;

public class Product {
	
	String ProductName;

	private ClassProductList classProductList;

	private Trading trading;
	
	
	public Product(String ProductName) {
		this.ProductName = ProductName;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public int accept(NodeVisitor visitor) {
		return visitor.visitProduct();
		
	}

}
