/*This program asks for a number between 2-12
 * It then rolls two dice until their sum equals the number given
 * by Amber Simpson
 */
import java.util.*;//import to use Scanner class
public class RollDice 
{
	//create a Scanner object for user input
	public static Scanner console = new Scanner(System.in);
	public static void main(String[] args)
	{
		//create local variables
		int sum;
		char rollAgain = 'Y';
		System.out.println("This program takes a sum of two dice "
				+ "and give the number of times the dice are rolled "
				+ "to equal that sum.");
		//looping to so user can decide when to quit
		while(rollAgain == 'Y' || rollAgain == 'y')
		{
			//get user input for sum
			System.out.println("Enter whole number between 2 and 12: ");
			sum = console.nextInt();
			//outputting number of dice rolled
			System.out.println("The number of times the dice are rolled "
					+ "to get the sum of " + sum + " is " + rollDice(sum) + ".");
			System.out.println("");
			//asking user if they want to input another sum
			System.out.println("Would you like to choose another number? Y/N ");
			rollAgain = console.next().charAt(0);
		}
		
	}
	//method to calculate the number of dice rolled
	public static int rollDice(int num)
	{
		//declaring local variables
		int die1;
		int die2;
		int sum;
		int rollCount = 0;
		//rolling die until desired sum is made
		do
		{
			die1 = (int)(Math.random() * 6) + 1;
			die2 = (int)(Math.random() * 6) + 1;
			sum = die1 + die2;
			rollCount++;
		}
		while(sum != num);
		//returning the number of rolls
		return rollCount;
	}
}
