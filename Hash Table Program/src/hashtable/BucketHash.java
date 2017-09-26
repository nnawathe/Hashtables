package hashtable;

public class BucketHash implements HashClass
{
	//Array of numbers in table
	private Integer[] numbers;

//Constructor
public BucketHash()
{
	numbers = new Integer[36];
}

/**
 * Adds number to table using bucket method
 * @param input: number to add
 */
public void add(Integer input)
{
	int i = input % 12 * 3;
	if(numbers[i] == null)
		numbers[i] = input;
	else if(numbers[i+1] == null)
		numbers[i+1] = input;
	else if(numbers[i+2] == null)
		numbers[i+2] = input;
	else
		throw new IllegalStateException("Bucket is full");
}

/**
 * Returns if a number is in the table
 * @param value: number to search for
 * @return boolean: true if number is in table
 * 					false if number is not in table
 */
public boolean contains(Integer input)
{
	int i = input % 12 *3;
	if(numbers[i] == input || numbers[i+1] == input || numbers[i+2] == input)
		return true;
	else
		return false;
}

/**
 * Returns table info as String
 * @return String: table info
 */
public String toString()
{
	int bucket = 0;
	String str = "Bucket\tLocation\tValue\n";
	for(int i = 0; i < numbers.length; i++){
		if(i % 3 == 0)
			str = str + (bucket++);
		str = str + "\t" + i + "\t\t" + numbers[i] + "\n";
	}
	return str;
}
}
