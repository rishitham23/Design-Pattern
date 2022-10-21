package dp;
public class Seller extends Person {

	public void showMenu() {

	}
	@Override
	public void CreateProductMenu() {
           //Loads seller's product menu
		if (selectedProduct.getProductCategory() == ProductMenu.ProductCategory.valueOf("MeatProductMenu").ordinal()) {
			productMenu = new MeatProductMenu(selectedProduct, ProductMenu.ProductCategory.MeatProductMenu);
		} else {
			productMenu = new ProduceProductMenu(selectedProduct, ProductMenu.ProductCategory.ProduceProductMenu);
		}
	}

}
