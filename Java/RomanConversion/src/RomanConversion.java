//This program test the Roman class
//by Amber Simpson
public class RomanConversion 
{
	public static void main(String[] args)
	{
		//creating object of Roman class
		Roman numeral = new Roman("mciv");
		//printing out the Roman numeral and its decimal equivalent
		System.out.print("The Roman numeral is: ");
		numeral.printRoman();
		System.out.println();
		System.out.print("Its decimal value is: ");
		numeral.printDecimal();
		System.out.println();
		//changing value of Roman numeral
		numeral.setRoman("CCCLIX");
		//printing out the Roman numeral and its decimal equivalent
		System.out.print("The Roman numeral is: ");
		numeral.printRoman();
		System.out.println();
		System.out.print("Its decimal value is: ");
		numeral.printDecimal();
		System.out.println();
		//changing value of Roman numeral
		numeral.setRoman("MDCLXVI");
		//printing out the Roman numeral and its decimal equivalent
		System.out.print("The Roman numeral is: ");
		numeral.printRoman();
		System.out.println();
		System.out.print("Its decimal value is: ");
		numeral.printDecimal();
		System.out.println();
	}
	
}
