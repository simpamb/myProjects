/*This program takes a number of lines
 * Then uses it to create a pattern of stars
 * by Amber Simpson
 */
//imports Scanner class
import java.util.*;

//program to make a star pattern using a recursive method
public class StarPattern 
{
	//creates a scanner object to hold input
	static Scanner console = new Scanner(System.in);
	
	//main method
	public static void main(String[] args)
	{
		char pattern = '*';//variable to hold the pattern
		int numLines = 0;//variable to hold the number of lines
		
		//loop to make sure a valid number is input
		while (numLines == 0)
		{
			//tests input to make sure it is a positive integer
			try
			{
				System.out.print("Please enter the number of lines for the pattern: ");
				numLines = console.nextInt();
				if(numLines < 0)
				{
					numLines = 0;
					throw new NegativeException();
				}
				else
					Pattern(numLines, pattern);
			}
			//catch statement for a non integer
			catch (InputMismatchException e1)
			{
				System.out.println("ERROR: The entry is not an integer!");
			}
			//catch statement for a negative number
			catch (NegativeException e)
			{
				System.out.println("ERROR: The entry is less than zero.");
			}
		}
	}
	
	//recursive method to print the star pattern
	public static void Pattern(int line, char digit)
	{
		//for loop for the first part of the pattern
		for(int count = line; count > 0; count --)
		{
			System.out.print(digit);			
		}
		System.out.println();
		//recursive statements to print out the second part of the pattern
		if(line > 1)
		{
			Pattern(line - 1, digit);
		}
		for(int count = line; count > 0; count --)
		{
			System.out.print(digit);
		}
		System.out.println();
	}
}

