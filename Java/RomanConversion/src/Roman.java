//class that converts a Roman numeral and stores the decimal equivalent
public class Roman 
{
	private String romNum;//stores the Roman numeral
	private int decNum;//stores the decimal
	//constructor to create the Roman object
	public Roman(String roman)
	{
		setRoman(roman);
	}
	//method sets the value of the Roman numeral and invokes the conversion method
		public void setRoman(String roman)
	{
		int romanLength = roman.length();//gives the length of the Roman string
		int count = 0;//variable to loop through the Roman string
		boolean valid = true;//variable to test whether it is a true Roman numeral
		roman = roman.toUpperCase();//changes the Roman numeral to all upper case
		//loop that tests whether all characters in the Roman numeral are valid
		while (count < romanLength)
		{
			if(roman.charAt(count) == 'M' || roman.charAt(count) == 'D' || roman.charAt(count) == 'C' 
					|| roman.charAt(count) == 'L' || roman.charAt(count) == 'X' || 
					roman.charAt(count) == 'V' || roman.charAt(count) == 'I')
				count ++;
			else
			{
				valid = false;
				break;
			}
		}
		//sets the value of the Roman numeral if valid or to blank if not
		if(valid)
		{
			romNum = roman;
			romanToDecimal();
		}
		else
		{
			romNum = "";
			decNum = 0;
		}
	}
		//method converts the Roman numeral to a decimal value
		private void romanToDecimal()
	{
		int romanLength = romNum.length();//length of the Roman numeral
		int count = 0;//variable to loop through the length of the Roman numeral
		int tempDec = 0;//holds the temporary decimal value
		boolean last = false;//tells whether we are at the last character
		//loops through the characters in the Roman string
		while(count < romanLength)
		{
			//tests the characters of the Roman string
			if(count + 1 == romanLength)
			{
				last = true;
			}
			if(romNum.charAt(count) == 'M')
			{
				tempDec = tempDec + 1000;
			}
			if(romNum.charAt(count) == 'D')
			{
				tempDec = tempDec + 500;
			}
			if(romNum.charAt(count) == 'C')
			{
				if(!(last) && (romNum.charAt(count + 1) == 'M' || romNum.charAt(count + 1) == 'D'))
				{
					tempDec = tempDec - 100;
				}
				else
				{
					tempDec = tempDec + 100;
				}
			}
			if(romNum.charAt(count) == 'L')
			{
				tempDec = tempDec + 50;
			}
			if(romNum.charAt(count) == 'X')
			{
				if(!(last) && (romNum.charAt(count + 1) == 'L' || romNum.charAt(count + 1) == 'C'))
				{
					tempDec = tempDec - 10;
				}
				else
				{
					tempDec = tempDec + 10;
				}
			}
			if(romNum.charAt(count) == 'V')
			{
				tempDec = tempDec + 5;
			}
			if(romNum.charAt(count) == 'I')
			{
				if(!(last) && (romNum.charAt(count + 1) == 'X' || romNum.charAt(count + 1) == 'V'))
				{
					tempDec = tempDec - 1;
				}
				else
				{
					tempDec = tempDec + 1;
				}
			}
			count ++;
		}
		decNum = tempDec;
	}
	//method prints the Roman numeral value
	public void printRoman()
	{
		System.out.print(romNum);
	}
	//method prints the Decimal value
	public void printDecimal()
	{
		System.out.print(decNum);
	}
}
