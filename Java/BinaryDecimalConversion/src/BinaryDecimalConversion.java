/*This program takes in a binary number and converts it to integer
 * or a integer and converts it to decimal
 * by Amber Simpson
 */
//import packages needed for the program
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.Math;

//creating the class to handle the conversions
public class BinaryDecimalConversion extends JFrame
{
	//constant to hold the size of the window
	private static int WIDTH = 415;
	private static int HEIGHT = 230;
	//variables to hold the program description
	private static JLabel description1;
	private static JLabel description2;
	private static JLabel description3;
	private static JLabel description4;
	//labels for the binary and decimal conversion
	private static JLabel binary;
	private static JLabel decimal;
	//label for any error message
	private static JLabel error;
	//textfield to gather input on binary or decimal number
	private static JTextField binaryTx;
	private static JTextField decimalTx;
	//buttons for conversion
	private static JButton binaryBn;
	private static JButton decimalBn;
	//button to exit the program
	private static JButton exitBn;
	
	//constructor for the BinaryDecimalConversion class
	public BinaryDecimalConversion()
	{
		//setting up window elements
		setTitle("Binary and Decimal Conversion");
		Container window = getContentPane();
		setSize(WIDTH, HEIGHT);
		window.setLayout(null);
		
		//initializing JFrame elements
		description1 = new JLabel("This program converts a binary number to a decimal number");
		description2 = new JLabel("and a decimal number to a binary number.");
		description3 = new JLabel("Enter a binary number and click Convert Binary.");
		description4 = new JLabel("Enter a decimal number and click Convert Decimal.");
		binary = new JLabel("Binary Number: ");
		decimal = new JLabel("Decimal Number: ");
		error = new JLabel("");
		error.setForeground(Color.red);
		binaryTx = new JTextField();
		decimalTx = new JTextField();
		binaryBn = new JButton("Convert Binary");
		BinaryHandler binaryHd = new BinaryHandler();
		binaryBn.addActionListener(binaryHd);
		decimalBn = new JButton("Convert Decimal");
		DecimalHandler decimalHd = new DecimalHandler();
		decimalBn.addActionListener(decimalHd);
		exitBn = new JButton ("Exit");
		ExitHandler exitHd = new ExitHandler();
		exitBn.addActionListener(exitHd);
		
		//setting the size for windows elements
		description1.setSize(380, 20);
		description2.setSize(380, 20);
		description3.setSize(380, 20);
		description4.setSize(380, 20);
		decimal.setSize(100, 20);
		binary.setSize(100, 20);
		error.setSize(380, 20);
		binaryTx.setSize(100, 20);
		decimalTx.setSize(100, 20);
		binaryBn.setSize(120, 20);
		decimalBn.setSize(140, 20);
		exitBn.setSize(100, 20);
		
		//setting the location of the window elements into the window
		description1.setLocation(10, 10);
		description2.setLocation(10, 30);
		description3.setLocation(10, 50);
		description4.setLocation(10, 70);
		binary.setLocation(10, 100);
		binaryTx.setLocation(200, 100);
		decimal.setLocation(10, 120);
		decimalTx.setLocation(200, 120);
		error.setLocation(10, 140);
		binaryBn.setLocation(10, 160);
		decimalBn.setLocation(140, 160);
		exitBn.setLocation(290, 160);
		
		//adding the windows elements into the window
		window.add(description1);
		window.add(description2);
		window.add(description3);
		window.add(description4);
		window.add(binary);
		window.add(binaryTx);
		window.add(decimal);
		window.add(decimalTx);
		window.add(error);
		window.add(binaryBn);
		window.add(decimalBn);
		window.add(exitBn);
		
		//setting values for window
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	//class to handle the binary conversion button
	private static class BinaryHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//resets the text fields to blank
			error.setText("");
			decimalTx.setText("");
			
			//try statement to check input for validation
			try
			{
				//gets binary string from binary text field
				String binaryNum = binaryTx.getText();
				//loops through string to make sure it only contains 0s and 1s
				for(int index = 0; index < binaryNum.length(); index++)
				{
					//throws exception if string contains anything else than 1s and 0s
					if(binaryNum.charAt(index) != '0' && binaryNum.charAt(index) != '1')
						throw new Exception();
				}
				
				//setting the decimal value by calling the recursive method BinaryConversion
				decimalTx.setText(Integer.toString(BinaryConversion(binaryNum, binaryNum.length() - 1, 0)));
			}
			
			//catch statement to output error message
			catch(Exception e1)
			{
				error.setText("ERROR: The number must consist of only 0s and 1s.");
			}
		}
	}
	
	//class to handle decimal conversion button
	private static class DecimalHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int number;
			//resets text field and error message to blank
			error.setText("");
			binaryTx.setText("");
			
			//try statement to test that a valid input is entered
			try
			{
				//initiates number with input from decimal text field
				number = Integer.parseInt(decimalTx.getText());
				
				//if statement to make sure number is a positive number
				if(number < 0)
					throw new Exception();
				
				//sets binary text field to a binary string found by the recursive method
				//DecimalConversion
				binaryTx.setText(DecimalConversion(number));
			}
			
			//catch statement to display error message
			catch(Exception e1)
			{
				error.setText("ERROR: The number must be a positive integer!");
			}
			
		}
	}
	
	//class to handle the exit button
	private static class ExitHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);//exits program
		}
	}
	
	//method to convert a decimal number to a binary number
	private static String DecimalConversion(int num)
	{
		String binary;//variable to hold the binary number
		
		//if statement to check to see if the decimal equals 0
		if(num == 0)
		{
			binary = "0";
		}
		else
		{
			//initiates binary to the recursive DecimalConversion method
			binary = DecimalConversion(num/2);
			//adds the new binary digit to the binary string
			binary = binary + (num % 2);
		}
		
		//returns the binary string
		return binary;
	}
	
	//method to Convert a binary string into a decimal number
	private static int BinaryConversion(String binary, int weight, int index)
	{
		//integer to hold the decimal value
		int decimal = 0;
		
		//if statement to stop the recursive method
		if (!(weight < 0))
		{
			//decimal is added to the recursive method BinaryConversion
			decimal = decimal + BinaryConversion(binary, weight - 1, index + 1);
			//decimal is added to 2 to the power of weight times the number in the binary string
			decimal = decimal + ((int) Math.pow(2, weight) * Character.getNumericValue(binary.charAt(index)));
		}
		
		//returns the decimal value
		return decimal;
	}
	
	//main method to start the program
	public static void main(String[] args)
	{
		//creates an instance of the BinaryDecimalConversion class
		BinaryDecimalConversion conversion = new BinaryDecimalConversion();
	}
}
