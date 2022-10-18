package designpatterns;
public class ProduceProductMenu extends ProductMenu {

	public ProduceProductMenu(Product theSelectedProduct, ProductCategory category) {
		super(theSelectedProduct, category);
		
	}

	public void showMenu() {
		System.out.println("Display Produce Product Menu");

	}

	public void showAddButton() {
		System.out.println("Add");

	}

	public void showViewButton() {
		System.out.println("View");

	}

	public void showRadioButton() {
		System.out.println("Radio");

	}

	public void showLabels() {
		System.out.println("Labels");

	}

	public void showComboxes() {
		System.out.println("Comboxes");

	}

}
