package designpatterns;



public abstract class ProductMenu {


	private Product theSelectedProduct;

	

	ProductCategory nProductCategory;
	public enum ProductCategory {
		MeatProductMenu, ProduceProductMenu
	}


	public ProductMenu(Product theSelectedProduct, ProductCategory category) {
		this.theSelectedProduct=theSelectedProduct;
		this.nProductCategory=category;
		
	}
	
	public Product getProduct() {

		return theSelectedProduct;
	}

	

	public void setProduct(Product theSelectedProduct) {

		this.theSelectedProduct = theSelectedProduct;
	}

	public ProductCategory getProductCategory() {

		return nProductCategory;
	}


	public void setProductCategory(ProductCategory theNProductCategory) {

		this.nProductCategory = theNProductCategory;
	}
	
	
	
	

	public abstract void showMenu();

	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

}
