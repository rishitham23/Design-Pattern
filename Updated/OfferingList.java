package designpatterns;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class OfferingList extends ArrayList<Offering> {

	private OfferingIterator offeringIterator;

	private Offering[] offering;

	private Trading trading;

}
