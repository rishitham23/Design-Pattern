package designpatterns;
import java.util.ArrayList;
@SuppressWarnings("hiding")
public class ProductIterator<Product> implements ListIterator {

	
	ArrayList<Product> list;
	int ObjNum = -1;
	public ProductIterator(ArrayList<Product> list) {

		this.list = list;
	}

	public boolean hasNext() {
		if (ObjNum >= list.size() - 1) {
			return false;
		} else {
			return true;
		}
	}
	public Object Next() {
		if (hasNext()) {
			ObjNum++;
			return (Object) list.get(ObjNum);
		} else {
			return null;
		}
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

}
