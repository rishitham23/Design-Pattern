package dp;

public class ReminderVisitor extends NodeVisitor {

	Reminder m_Reminder;
	
	public ReminderVisitor(Reminder reminder) {

		this.m_Reminder = reminder;
	}

	ClassProductList classProductList;
	

	public void visitProduct(Product product) {

	}

	public void visitTrading(Trading trading) {

	}

	public void visitFacade(Facade facade) {
		//visits facade in reminder class
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ProductIterator productList = new ProductIterator(facade.thePerson.classProductList);

		while (productList.hasNext()) {
			Object product = productList.Next();
			System.out.println("for product " + product.getProductName());
			product.accept(this);
		}

	}

}
