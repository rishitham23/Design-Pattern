package designpatterns;



public abstract interface ListIterator {
	

	public abstract boolean hasNext();

	abstract public Object Next();

	public abstract void MoveToHead();

	public abstract void Remove();

}
