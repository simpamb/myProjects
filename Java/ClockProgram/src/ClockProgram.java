//program to test the new decrement methods in the clock class
//by Amber Simpson
public class ClockProgram 
{
	public static void main(String[] args)
	{
		//creating two clock objects
		Clock clock1 = new Clock();
		Clock clock2 = new Clock(23, 59, 59);
		//printing out original clock object times
		System.out.print("Clock 1 " + clock1.getHours() + ":" + clock1.getMinutes() 
			+ ":" + clock1.getSeconds());
		System.out.println();
		System.out.print("Clock 2 ");
		clock2.printTime();
		System.out.println();
		//changing the times in the clock times
		clock1.decrementSeconds();
		clock2.incrementSeconds();
		//printing out the new clock object times
		System.out.print("After decreasing one second on clock 1: ");
		clock1.printTime();
		System.out.println();
		System.out.print("After increasing one second on clock 2: ");
		clock2.printTime();
		System.out.println();
	}
}
