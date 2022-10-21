package dp;

public class Buyer extends Person {

	public void showMenu() {

	}
	@Override
	public void CreateProductMenu() {                                //Product menu is loaded
		if (selectedProduct.getProductCategory() == ProductMenu.ProductCategory.valueOf("MeatProductMenu").ordinal()) {
			productMenu = new MeatProductMenu(selectedProduct, ProductMenu.ProductCategory.MeatProductMenu);
		} else {
			productMenu = new ProduceProductMenu(selectedProduct, ProductMenu.ProductCategory.ProduceProductMenu);
		}
	}

}
