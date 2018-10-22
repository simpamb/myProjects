//This program finds the highest and lowest temperatures for a year as well as there averages
//by Amber Simpson
import java.util.Scanner;

public class TwoDimensionalArray 
{
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args)
	{
		//creating the array to hold the temperatures
		double[][] tempArray = getData();
		//getting the average high and low temperatures
		double avgHigh = averageHigh(tempArray);
		double avgLow = averageLow(tempArray);
		//getting the index for the highest and lowest temperatures
		int indexHigh = indexHighTemp(tempArray);
		int indexLow = indexLowTemp(tempArray);
		//outputting all the high and low temperatures for the year
		System.out.println("Highest temperatures: ");
		for(int index = 0; index < 12; index ++)
		{
			System.out.printf("%10.2f", tempArray[index][0]);
		}
		System.out.println();
		System.out.println("Lowest temperatures: ");
		for(int index = 0; index < 12; index ++)
		{
			System.out.printf("%10.2f", tempArray[index][1]);
		}
		//outputting the average high and low temperature for the year
		System.out.println();
		System.out.printf("The average high temperature for the year is: %.2f", 
				avgHigh);
		System.out.println();
		System.out.printf("The average low temperature for the year is: %.2f", 
				avgLow);
		System.out.println();
		//outputting the highest and lowest temperatures for the year
		System.out.printf("The highest temperature for the year was: %.2f", 
				tempArray[indexHigh][0]);
		System.out.println();
		System.out.printf("The lowest temperature for the year was: %.2f", 
				tempArray[indexLow][1]);
	}
	//method to get the data needed for the array of temperatures
	private static double[][] getData()
	{
		//an array of the months
		String[] month = {"January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "Novemeber",
				"December"};
		//the array to put the temperatures in
		double[][] array = new double[12][2];
		//input for the high temperatures
		for(int index = 0; index < 12; index ++)
		{
			System.out.print("Please enter the high for " + month[index] + " ");
			array[index][0] = console.nextDouble();
		}
		//input for the low temperatures
		for(int index = 0; index < 12; index ++)
		{
			System.out.print("Please enter the low for " + month[index] + " ");
			array[index][1] = console.nextDouble();
		}
		//returning the temperature array
		return array;
	}
	//this method gets the average high temperatures in the array
	private static double averageHigh(double[][] highTemp)
	{
		double avgTemp;//variable to carry average temperature
		double sum = 0;//variable to sum up the high temperatures
		//adding up all the high temperatures
		for(int index = 0; index < 12; index ++)
		{
			sum = sum + highTemp[index][0];
		}
		//finding the average temperature
		avgTemp = sum/12;
		//returning the average high temperature
		return avgTemp;
	}
	//this method gets the average low temperature in the array
	private static double averageLow(double[][] lowTemp)
	{
		double avgTemp;//variable to carry the average temperature
		double sum = 0;//variable to sum up the low temperatures
		//adding up all the low temperatures
		for(int index = 0; index < 12; index ++)
		{
			sum = sum + lowTemp[index][1];
		}
		//finding the average temperature
		avgTemp = sum/12;
		//returning the average low temperature
		return avgTemp;
	}
	//method to find the index of the highest temperature
	private static int indexHighTemp(double[][] highTemp)
	{
		int index = 0;//holds the index of the highest temperature
		//finds the highest temperature
		for(int count = 1; count < 12; count ++)
		{
			if(highTemp[count][0] > highTemp[index][0])
			{
				index = count;
			}
		}
		//returns the index of the highest temperature
		return index;
	}
	//method to find the index of the lowest temperature
	private static int indexLowTemp(double[][] lowTemp)
	{
		int index = 0;//holds the index of the lowest temperature
		//finds the lowest temperature
		for(int count = 1; count < 12; count ++)
		{
			if(lowTemp[count][0] < lowTemp[index][0])
			{
				index = count;
			}
		}
		//returns the index of the lowest temperature
		return index;
	}
}
