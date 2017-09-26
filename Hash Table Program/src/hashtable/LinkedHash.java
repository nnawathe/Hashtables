package hashtable;

public class LinkedHash implements HashClass
{
	//Array of LinkedLists that stores numbers in table
	private LinkedList<Integer>[] numbers;

//Constructor
public LinkedHash()
{
	numbers = new LinkedList[12];
}

/**
 * Adds number to table using LinkedList method
 * @param input: number to add
 */
public void add(Integer input)
{
	if(numbers[input %12] == null)
		numbers[input%12] = new LinkedList();
	numbers[input%12].addLast(input);
}

/**
 * Returns if a number is in the table
 * @param value: number to search for
 * @return boolean: true if number is in table
 * 					false if number is not in table
 */
public boolean contains(Integer input)
{
	Node temp=null;
	if(numbers[input%12] != null)
		temp = numbers[input%12].getHead();
	while(temp != null){
		if(temp.getValue().equals(input))
			return true;
		temp = temp.getNext();
	}
	return false;
}

/**
 * Returns table info as String
 * @return String: table info
 */
public String toString()
{
	String str = "Location\tValue\tLinks\n";
	for(int i = 0; i < numbers.length; i++){
		Node temp = null;
		str = str + i + "\t\t";
		if(numbers[i] == null)
			str = str + numbers[i] + "\t";
		else
			temp = numbers[i].getHead();
		while(temp != null){
			str = str +  temp.getValue() + "\t";
			temp = temp.getNext();
		}
		str = str + "\n";
	}
	return str;
}

}
