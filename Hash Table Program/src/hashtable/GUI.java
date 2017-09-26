package hashtable;

import java.awt.Dimension;

import javax.swing.*;

import BreezySwing.*;

public class GUI extends GBFrame
{
	private JButton input, getTable, search;
	private HashClass table;
	
//Constructor
public GUI()
{
	input = addButton("New Table",1,1,1,1);
	getTable = addButton("Get Table", 2,1,1,1);
	search = addButton("Search",3,1,1,1);
}

/**
 * Acts on a number being clicked
 * @param buttonObj: button that is clicked
 */
public void buttonClicked(JButton buttonObj)
{
	try{
		if(buttonObj == input){
			Object[] options = new Object[] {"Linear", "Quadratic", "Rehash", "Bucket", "Linked List"};
			String collision = (String) JOptionPane.showInputDialog(this,"Output with which method?","Select", 
					JOptionPane.QUESTION_MESSAGE, null, options, null);
			if(collision.equals("Bucket"))
				table = new BucketHash();
			else if(collision.equals("Linked List"))
				table = new LinkedHash();
			else
				table = new HashTable(collision);
			for(int i = 0; i < 12; i ++){
				table.add(Parser.parseInt(JOptionPane.showInputDialog(this, "Input number: ")));
			}
		}else if(buttonObj == getTable){
			messageBox(table.toString());
		}else if(buttonObj == search){
			if(table.contains(Parser.parseInt(JOptionPane.showInputDialog(this, "Input number to search:"))))
				messageBox("This number is in the table");
			else
				messageBox("This number is not in the table");
		}
	}catch(IllegalStateException e){
		messageBox(e);
	}
}
	
//Main method
public static void main(String[]args)
{
	GUI theGUI = new GUI();
	theGUI.setSize(230,200);
	theGUI.setTitle("Hash Table Program");
	theGUI.setVisible(true);
}
}
