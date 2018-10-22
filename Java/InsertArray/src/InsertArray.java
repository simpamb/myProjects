/*This program asks for an array length
 * It then creates an array of that length with 0s for values
 * Then asks for a number and position for entry into the array
 * After all entries are made it prints out the array
 * by Amber Simpson
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertArray 
{
	//creates a scanner object for user input
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args)
	{
		//variables for array length, number, and index
		int length;
		int index;
		int num;
		//variable to hold whether a new number needs to be inserted
		int insertAgain;
		
		//try statement to make sure that user input is valid
		try 
		{
			//user input to find out the length of the array
			System.out.print("Enter the length of the array");
			length = console.nextInt();
			//creating the new array
			int[] numArray = new int[length];
			//printing the new array
			for(int integer: numArray)
				System.out.print(integer + " ");
			System.out.println();
			//do while loop to insert numbers into the array
			do
			{
				//user input on the number to insert into the array
				System.out.print("Enter the number to insert into the array: ");
				num = console.nextInt();
				//user input on the index location for the number to insert
				System.out.print("Enter the location in the array for the number: ");
				index = console.nextInt();
				//calling insertAt method to insert the number into the array
				insertAt(numArray, length, num, index);
				//user input on whether there is another number to insert
				System.out.print("Do you want to insert another number in the array? 1 = yes, 2 = no: ");
				insertAgain = console.nextInt();
			}
			while(insertAgain == 1);
			//reprinting the array
			for(int integer: numArray)
				System.out.print(integer + " ");
			System.out.println();
		} 
		//catch statement for error message if the input is not valid
		catch (InputMismatchException e) 
		{
			System.out.println("ERROR! Wrong type of input entered.");
		}
	}
	
	//method to insert number into the array
	public static void insertAt(int[] intArray, int lengthArray, int insertItem, int index)
	{
		//try statement to make sure index is in range for the array
		try {
			//if statement to throw exception if index is out of range of the array
			if(0 > index || index >= lengthArray)
			{
				throw new OutOfRangeException();
			}
			//else statement inserts the number into the index location on the array
			else
			{
				intArray[index] = insertItem;
			}
		} 
		//catch statement for the out of range exception error message
		catch (OutOfRangeException e) 
		{
			System.out.println("ERROR: index location is outside of range of array!");
		}
	}
}
