/*program creates an array of 50 numbers and outputs the results in a table
 * First 25 numbers in array are the index squared
 * Last 25 numbers are 3 * the index
 * Table is 10 columns by 5 rows
 * by Amber Simpson
 */
public class DoubleArray 
{
	public static void main(String[] args)
	{
		//creating the array
		double[] dArray = new double[50];
		//squaring the index for the value of the first 25 elements
		for(int index = 0; index < 25; index++)
		{
			dArray[index] = index * index;
		}
		//multiplying the index for the value of the last 25 elements
		for(int index = 25; index < 50; index++)
		{
			dArray[index] = 3 * index;
		}
		//outputting the table
		System.out.print("The array of double numbers is: ");
		//creating the five rows
		for(int count = 0; count < 5; count ++)
		{
			System.out.println();
			//creating the 10 columns
			for(int index = 0; index < 10; index ++)
			{
				System.out.printf("%10.2f", dArray[index + count * 10]);
			}
		}
	}
}
