package hashtable;

import java.util.ArrayList;

public class Parser {

/**
 * Turns a string into an integer
 * @param str: String to be parsed
 * @return int: parsed integer
 */
public static int parseInt(String str)
{
	int num = 0;
	for(int i = 0; i < str.length(); i++){
		if(Character.isDigit(str.charAt(i)))
			num = num + Character.getNumericValue(str.charAt(i))* (int)Math.pow(10, str.length()-i-1);
		else
			throw new IllegalStateException("\n\tInvalid: Not a number");
	}
	return num;
}
}
