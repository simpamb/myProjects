import java.util.*;
/*This program asks for a weight in kilograms and converts it to pounds.
 * by Amber Simpson
 */
public class WeightConversions {

	public static void main(String[] args) 
	{
		//creating an input path
		Scanner console = new Scanner(System.in);
		//declaring variables and Constants
		double weight;
		final double CONVERT = 2.2;
		double convertedWeight;
		//asking for user input
		System.out.println("This program asks for a weight in kilograms and converts it to pounds. \n\n");
		System.out.println("Please enter a weight: ");
		weight = console.nextDouble();
		//calculating converted weight
		convertedWeight = weight * CONVERT;
		//outputting the weight in kilograms and pounds in a formatted string.
		System.out.printf("\nThe weight you entered is %.2f kgs.", weight);
		System.out.printf("\nThe converted weight is %.2f lbs.", convertedWeight);
	}

}
