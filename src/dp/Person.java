package dp;

public abstract class Person {



	ProductMenu productMenu;
	
	private String userName;
	
	Product selectedProduct;
	
	ClassProductList classProductList;



	public abstract void showMenu();

	public void showAddButton() {

	}

	
	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}


	public Person() {

		classProductList = new ClassProductList();
	}

	public abstract void CreateProductMenu(); 
	
	public void addProduct(Product product) {

		classProductList.add(product);
	}
	
	

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}
	
	
	public ClassProductList getProductList() {

		return classProductList;
	}



	public ProductMenu getCourseMenu() {

		return productMenu;
	}

	

	public void setProductMenu(ProductMenu theProductMenu) {

		this.productMenu = theProductMenu;
	}
	
	

	public Product getSelectedProduct() {

		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {

		this.selectedProduct = selectedProduct;
	}

}
