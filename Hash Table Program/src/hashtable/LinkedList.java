package hashtable;

public class LinkedList<T>
{
	//The main head node of Linked List
	private Node<T> head;

//constructor of LinkedList
public LinkedList()
{
	head = null;
}

/**
 * Returns head of LinkedList
 * @return Node<T>: head of LinkedList
 */
public Node<T> getHead()
{
	return head;
}

/**
 * Adds an object at the start of the LinkedList
 * @param obj: object to be added into the list
 */
public void addFirst(T obj)
{
	head = new Node<T>(obj, head);
}

/**
 * Adds an object at the end of the LinkedList
 * @param obj: object to be added into the list 
 */
public void addLast(T obj)
{
	if(head == null)
		addFirst(obj);
	else{
		Node<T> temp = head;
		while (head.getNext() != null)
			head = head.getNext();
		head.setNext(new Node<T>(obj, null));
		head = temp;
	}
}


//Removes the object at the end of the LinkedList
public void removeLast()
{
	if(head == null)
		throw new IllegalStateException("No jobs left");
	else{
		Node<T> start = head;
		Node<T> pointer = head;
		while(pointer.getNext() != null)
			pointer = pointer.getNext();
		if(pointer.equals(head))
			head = null;
		else{
			pointer = head;
			while(pointer.getNext().getNext() != null)
				pointer = pointer.getNext();
			head = pointer;
			head.setNext(null);
			head = start;
		}
	}
}

//Returns info on first object in LinkedList as a String
public T getFirst()
{
	if(head == null)
		return null;
	T first = head.getValue();
	return first;
}


//Returns info on last object in LinkedList as a String
public T getLast()
{
	if(head == null)
		return null;
	Node<T> pointer = head;
	while(pointer.getNext()!= null)
		pointer = pointer.getNext();
	return pointer.getValue();
}

//Removes the object at the beginning of the LinkedList 
public void removeFirst()
{
	if(head == null)
		throw new IllegalStateException("No jobs left");
	Node<T> temp = head.getNext();
	head = null;
	head = temp;
}

//Deletes all nodes of the LinkedList
public void deleteAll()
{
	head = null;
}

//Outputs info on all LinkedList objects as a String
public String printAll()
{
	if(head == null)
		return "No jobs left";
	String str = "";
	Node pointer = head;
	while(pointer.getNext()!= null){
		str = str + pointer.getValue() + "\n\n";
		pointer = pointer.getNext();
	}
	str = str + pointer.getValue();
	return str;
}
	
}