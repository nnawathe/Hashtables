package hashtable;

public class Node<T>
{
	//Stores value in node
	private T value;
	//Stores next node in Linked List
	private Node<T> next;
	
public Node()
{
	value = null;
	next = null;
}

/**
 * Parameterized constructor
 * @param value: value to be stored in node
 * 		  next: next node in list
 */
public Node(T value, Node<T> next)
{
	this.value = value;
	this.next = next;
}

//Returns value stored in node
public T getValue()
{
	return value;
}

//Returns next node in Linked List
public Node<T> getNext()
{
	return next;
}

//Sets the next node in the Linked List
public void setNext(Node<T> next)
{
	this.next = next;
}
}