package designPattern;

public abstract class ListIterator {
	
	public abstract boolean hasNext();
	public abstract Object next();
	public abstract void remove(String productname);
	public abstract void moveToHead();
	
	public abstract ListIterator createIterator();

}
