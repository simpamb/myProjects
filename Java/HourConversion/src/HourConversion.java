/*This program takes a 12hr time and converts it into 24hr format
 * by Amber Simpson
 */
//importing in needed packages to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//creating my main program class
public class HourConversion extends JFrame
{
	private static int WIDTH = 500;//width of the window
	private static int HEIGHT = 200;//height of the window
	
	//declaring my window components
	private JLabel explain;//label for program explanation
	private JTextField hours;//text field to hold hours
	private JLabel colon;//label to hold the first colon
	private JTextField minutes;//text field to hold minutes
	private JLabel colon2;//label to hold second colon
	private JTextField seconds;//label to hold seconds
	private JCheckBox afternoon;//check box on whether it is am or pm
	private JLabel conversion;//label to give the conversion of 12hr to 24hr
	private JLabel hrExcept;//label for error if hours is out of range
	private JLabel hrEx;//label for error if hours is not an integer
	private JLabel minExcept;//label for error if minutes is out of range
	private JLabel minEx;//label for error if minutes is not an integer
	private JLabel secExcept;//label for error if seconds is out of range
	private JLabel secEx;//label for error if seconds is not an integer
	private JButton calculate;//button to calculate the conversion
	private JButton exit;//button to exit the program
	//declaring layout as a group layout
	private GroupLayout layout;
	
	//constructor to build the window
	public HourConversion()
	{
		//sets up the window elements
		setTitle("Clock Conversion");
		Container window = getContentPane();
		setSize(WIDTH, HEIGHT);
		layout = new GroupLayout(window);
		window.setLayout(layout);
		//initializes window components
		explain = new JLabel("Enter a time in 12 hour format to be converted to 24 hr format.");
		hours = new JTextField(2);
		colon = new JLabel(":");
		minutes = new JTextField(2);
		colon2 = new JLabel(":");
		seconds = new JTextField(2);
		afternoon = new JCheckBox("pm");
		conversion = new JLabel("The converted time is: hh:mm:ss");
		hrExcept = new JLabel("ERROR: Hour out of range. Hour set to ");
		hrExcept.setForeground(Color.red);
		hrEx = new JLabel("ERROR: Entry not an integer. Hour set to ");
		hrEx.setForeground(Color.red);
		minExcept = new JLabel("ERROR: Minutes out of range. Minutes set to 0");
		minExcept.setForeground(Color.red);
		minEx = new JLabel("ERROR: Entry not an integer. Minutes set to 0.");
		minEx.setForeground(Color.red);
		secExcept = new JLabel("ERROR: Seconds out of range. Seconds set to 0");
		secExcept.setForeground(Color.red);
		secEx = new JLabel("ERROR: Entry not an integer. Seconds set to 0.");
		secEx.setForeground(Color.red);
		calculate = new JButton("Convert");
		exit = new JButton("Exit");
		CalculateButtonHandler cHandler = new CalculateButtonHandler();
		calculate.addActionListener(cHandler);
		ExitButtonHandler eHandler =  new ExitButtonHandler();
		exit.addActionListener(eHandler);
		
		//sets components into window layout
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(explain)
						.addComponent(conversion)
						.addComponent(hrExcept)
						.addComponent(hrEx)
						.addComponent(minExcept)
						.addComponent(minEx)
						.addComponent(secExcept)
						.addComponent(secEx)
						.addComponent(calculate))
				.addComponent(hours)
				.addComponent(colon)
				.addComponent(minutes)
				.addComponent(colon2)
				.addComponent(seconds)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(afternoon)
						.addComponent(exit)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(explain)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(hours)
						.addComponent(colon)
						.addComponent(minutes)
						.addComponent(colon2)
						.addComponent(seconds)
						.addComponent(afternoon))
				.addComponent(conversion)
				.addComponent(hrExcept)
				.addComponent(hrEx)
				.addComponent(minExcept)
				.addComponent(minEx)
				.addComponent(secExcept)
				.addComponent(secEx)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(calculate)
						.addComponent(exit)));
		
		//sets whether certain components are seen or not
		setVisible(true);
		conversion.setVisible(false);
		hrExcept.setVisible(false);
		hrEx.setVisible(false);
		minExcept.setVisible(false);
		minEx.setVisible(false);
		secExcept.setVisible(false);
		secEx.setVisible(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//method for when the calculate button is pushed
	private class CalculateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//hides certain components till needed
			conversion.setVisible(false);
			hrExcept.setVisible(false);
			hrEx.setVisible(false);
			minExcept.setVisible(false);
			minEx.setVisible(false);
			secExcept.setVisible(false);
			secEx.setVisible(false);
			
			//declaring variables to help conversion
			int hr = 0;
			int min;
			int sec;
			String hour;
			String minute;
			String second;
			
			//try statement to make sure the hours are correct
			try
			{
				hr = hr + Integer.parseInt(hours.getText());
				if(hr < 1 || hr > 12)
				{
					hr = 0;
					throw new InvalidHrExcep();
				}
			}
			//catch statements to catch the exceptions the hours try statement throws
			catch(NumberFormatException e1)
			{
				hrEx.setText("ERROR: Entry not an integer. Hour set to " + hr);
				hrEx.setVisible(true);
			}
			catch(InvalidHrExcep e2)
			{
				if(afternoon.isSelected())
					hrExcept.setText("ERROR: Hour out of range. Hour set to 12.");
				else
					hrExcept.setText("ERROR: Hour out of range. Hour set to 0.");
				hrExcept.setVisible(true);
			}
			
			//try statement to make sure the minutes are correct
			try
			{
				min = Integer.parseInt(minutes.getText());
				if(min < 0 || min > 60)
				{
					throw new InvalidMinExcep();
				}
			}
			//catch statements to catch the exceptions the minutes try statement throws
			catch(NumberFormatException e1)
			{
				minEx.setVisible(true);
				min = 0;
			}
			catch(InvalidMinExcep e2)
			{
				minExcept.setVisible(true);
				min = 0;
			}
			
			//try statement to make sure the seconds are correct
			try
			{
				sec = Integer.parseInt(seconds.getText());
				if(sec < 0 || sec > 60)
				{
					throw new InvalidSecExcep();
				}
			}
			//catch statements to catch the exceptions the seconds try statement throws
			catch(NumberFormatException e1)
			{
				secEx.setVisible(true);
				sec = 0;
			}
			catch(InvalidSecExcep e2)
			{
				secExcept.setVisible(true);
				sec = 0;
			}
			
			//checks to see if it is am or pm
			if(afternoon.isSelected())
				hr = hr + 12;
			//converts the integer hr into a String hour
			if(hr < 10)
				hour = "0" + hr;
			else
				hour = "" + hr;
			//converts the integer min into a String minute
			if(min < 10)
				minute = "0" + min;
			else
				minute = "" + min;
			//converts the integer sec into a String second
			if(sec < 10)
				second = "0" + sec;
			else
				second = "" + sec;	
			
			//Formats the calculation and makes it visible to the user
			conversion.setText("The converted time is: " + hour + ":" + minute + ":" + second + ".");
			conversion.setVisible(true);
		}
	}
	
	//method for when the Exit button is pushed
	private class ExitButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);//exits program
		}	
	}
	
	//creating the user Exception classes that I need for my program
	public class InvalidHrExcep extends Exception
	{
		public InvalidHrExcep()
		{}
	}
	public class InvalidMinExcep extends Exception
	{
		public InvalidMinExcep()
		{}
	}
	public class InvalidSecExcep extends Exception
	{
		public InvalidSecExcep()
		{}
	}
	
	//main method to call the Window constructor method
	public static void main(String[] args)
	{
		HourConversion calculate = new HourConversion();
	}
}
