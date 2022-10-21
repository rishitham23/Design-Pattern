package dp;

public class Reminder {
	ClassProductList Product_List;
	
	public Reminder() {

	}


	public void checkProductRemainder(ClassProductList Product_List) {

		ReminderVisitor visitor = new ReminderVisitor(new Reminder());
		visitor.visitFacade(PTBSMain.facade);
	}

}
