package designpatterns;
public class Trading {

	private OfferingList offeringList;

	private Product product;

	public void accept(NodeVisitor visitor) {
		System.out.println("Accept Trading Class Method.");
		visitor.visitTrading(this);

	}

}
