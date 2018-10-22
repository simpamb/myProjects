/*This program takes this year's, last year's, and 2 years ago prices
 * Then computes the inflation between those years
 * by Amber Simpson
 */
import java.util.*;//import to use Scanner class
public class Inflation 
{
	public static void main(String[] args)
	{
		//create a scanner class
		Scanner console = new Scanner(System.in);
		//create local variables
		double currentPrice;//this years price
		double firstPrice;//last years price
		double secondPrice;//price two years ago
		System.out.println("This program computes the inflation for the last two years.");
		//Asking for user input for the prices
		System.out.println("Please enter an items current price: ");
		currentPrice = console.nextDouble();
		System.out.println("Please enter last years price of the item: ");
		firstPrice = console.nextDouble();
		System.out.println("Please enter the price of the item from two years ago: ");
		secondPrice = console.nextDouble();
		//Outputting the results for inflation
		System.out.println("The inflation rate from one year ago is "
				+ InflationRate(currentPrice, firstPrice));
		System.out.println("The inflation rate from two years ago is " 
				+ InflationRate(currentPrice, secondPrice));
		
	}
	//method to compute inflation
	public static double InflationRate(double newPrice, double oldPrice)
	{
		//creating local variable
		double inflation;
		//calculating inflation
		inflation = (newPrice - oldPrice) / oldPrice;
		//returning inflation amount
		return inflation;
	}
}
