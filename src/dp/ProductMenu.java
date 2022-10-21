package dp;



public abstract class ProductMenu {


	private Product selectedProduct;

	

	ProductCategory nProductCategory;
	public enum ProductCategory {
		MeatProductMenu, ProduceProductMenu
	}


	public ProductMenu(Product selectedProduct, ProductCategory prod_Category) {
		this.selectedProduct=selectedProduct;
		this.nProductCategory=prod_Category;
		
	}
	
	public Product getProduct() {

		return selectedProduct;
	}

	

	public void setProduct(Product selectedProduct) {

		this.selectedProduct = selectedProduct;
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
