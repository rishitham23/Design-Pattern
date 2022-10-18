package designpatterns;
public class Reminder {
	ClassProductList theProductList;
	
	public Reminder() {

	}


	public void checkProductRemainder(ClassProductList theProductList) {

		ReminderVisitor visitor = new ReminderVisitor(new Reminder());
		visitor.visitFacade(PTBSSystem.facade);
	}

}
