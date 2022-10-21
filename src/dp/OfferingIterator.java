package dp;

import java.util.ArrayList;

@SuppressWarnings("hiding")
public class OfferingIterator<Offering> implements ListIterator {


	ArrayList<Offering> list;
	int Obj_Num = -1;
	public OfferingIterator(ArrayList<Offering> list) {

		this.list = list;
	}


	public boolean hasNext() {
		if (Obj_Num >= list.size() - 1) {
			return false;
		} else {
			return true;
		}
	}

	public Object Next() {
		if (hasNext()) {
			Obj_Num++;
			return (Object) list.get(Obj_Num);
		} else {
			return null;
		}
	}

	public void moveToHead() {

	}

	public void remove() {

	}


}
