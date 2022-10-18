package designPattern;

public abstract class Person {

	private ProductMenu theProductMenu;
	public Person (ProductMenu ProMenu) {
		
		this.theProductMenu = ProMenu;
	}

	private ProductMenu productMenu;

	public void showMenu() {

	}

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}
	
	public void ProductMenu() {
		// TODO Auto-generated method stub
		
	}

}
