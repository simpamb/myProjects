//class to use InsertAt method

public class InsertAtLocation 
{
	//method that inserts a number into an array at a specific location
	public static void InsertAt(int[] array, int length, int index, int number)
	{
		if(index >= 0 && index < length)
			array[index] = number;
	}
}
