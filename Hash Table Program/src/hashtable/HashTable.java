package hashtable;

public class HashTable implements HashClass
{
	//Array of numbers in table
	private Integer[] numbers;
	//Stores type of collision handler
	private String collision;
	
/**
 * Parameterized constructor
 * @param collision: type of collision handler
 */
public HashTable(String collision)
{
	numbers = new Integer[12];
	this.collision = collision;
}

/**
 * Adds number to table
 * @param input: number to add
 */
public void add(Integer input)
{
	final int LOCATION = input %12;
	if(numbers[LOCATION] != null){
		if(collision.equals("Linear"))
			linearCollision(input);
		else if(collision.equals("Quadratic"))
			quadraticCollision(input, input %12);
		else if(collision.equals("Rehash"))
			rehashCollision(input);
	}else
		numbers[LOCATION] = input;
}

/**
 * Helper method that adds using linear collision handling
 * @param input: number to add
 */
private void linearCollision(Integer input)
{
	int i = input % 12;
	Integer temp = numbers[i];
	do{
		++i;
		if(i > 11)
			i = 0;
		if(numbers[i] == null){
			numbers[i] = input;
			return;
		}
	}while(numbers[i] != temp);
	throw new IllegalStateException("\nHashTable is full");
}

/**
 * Helper method that adds using quadratic collision handling
 * @param input: number to add
 */
private void quadraticCollision(Integer input, int start)
{
	int counter = 1;
	do{
		start = input % 12;
		start = start + (int)Math.pow(counter++, 2);
		if(start > 11)
			start = start % 12;
		if(numbers[start] == null){
			numbers[start] = input;
			return;
		}
	}while(start != input %12);
	throw new IllegalStateException("\nNumber is unable to be placed");
}

/**
 * Helper method that adds using rehash collision handling
 * @param input: number to add
 */
private void rehashCollision(Integer input)
{
	if(numbers[input*3%12] == null)
		numbers[input *3 %12] = input;
	else
		quadraticCollision(input, input*3%12);
}

/**
 * Returns if a number is in the table
 * @param value: number to search for
 * @return boolean: true if number is in table
 * 					false if number is not in table
 */
public boolean contains(Integer value)
{
	if(collision.equals("Linear"))
		return linearSearch(value);
	else if(collision.equals("Quadratic"))
		return quadraticSearch(value);
	else
		return rehashSearch(value);
}

/**
 * Searches for number with linear process
 * @param value: number to search for
 * @return boolean: true if number is in table
 * 					false if number is not in table
 */
private boolean linearSearch(Integer value)
{
	int i = value % 12;
	Integer temp = numbers[i];
	do{
		++i;
		if(i > 11)
			i = 0;
		if(numbers[i] == value)
			return true;
	}while(numbers[i] != temp);
	return false;
}

/**
 * Searches for number with rehash process
 * @param value: number to search for
 * @return boolean: true if number is in table
 * 					false if number is not in table
 */
private boolean rehashSearch(Integer value)
{
	if(numbers[value*3%12] == value)
		return true;
	else
		return quadraticSearch(value);
}

/**
 * Searches for number with quadratic process
 * @param value: number to search for
 * @return boolean: true if number is in table
 * 					false if number is not in table
 */
private boolean quadraticSearch(Integer value)
{
	int i, counter = 1;
	do{
		i = value % 12;
		i = i + (int)Math.pow(counter++, 2);
		if(i > 11)
			i = i % 12;
		if(numbers[i] == value){
			return true;
		}
	}while(i != value %12);
	return false;
}

/**
 * Returns table info as String
 * @return String: table info
 */
public String toString()
{
	String str = "Location\tValue\n";
	for(int i = 0; i < numbers.length; i++)
		str = str + i + "\t\t" + numbers[i] + "\n";
	return str;
}
}