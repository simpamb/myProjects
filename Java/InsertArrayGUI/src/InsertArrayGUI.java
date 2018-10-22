/*This program asks for the length of an array
 * It initializes the array with zeroes
 * Then asks for a number and location to input into the array
 * by Amber Simpson
 */
//1st JFrame window to appear in the application

//java packages needed for this JFrame
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//class to create the first JFrame and start the program
public class InsertArrayGUI extends JFrame
{
	
	//elements needed in the window
	private static int WIDTH = 400;//width of window
	private static int HEIGHT = 150;//height of window
	private JLabel arrayDescription;//instructions for window
	private JTextField length;//element to hold the length of the array
	private JLabel error;//element to hold error message
	private JButton createArray;//button to create array
	private CreateButtonHandler cbHandler;//handler for the create button
	private ExitButtonHandler eHandler;//handler for the exit button
	private JButton exit;//button to exit the program
	
	//constructor for the JFrame window
	public InsertArrayGUI()
	{
		//sets windows elements
		setTitle("Create Array");
		Container window = getContentPane();
		setSize(WIDTH, HEIGHT);
		window.setLayout(null);
		
		//initializes the various JFrame elements
		arrayDescription = new JLabel("Enter the length of the array to be created.");
		length = new JTextField();
		error = new JLabel();
		error.setForeground(Color.red);
		createArray = new JButton("Create");
		cbHandler = new CreateButtonHandler();
		createArray.addActionListener(cbHandler);
		exit = new JButton("Exit");
		eHandler = new ExitButtonHandler();
		exit.addActionListener(eHandler);
		
		//sets the size of the various JFrame elements
		arrayDescription.setSize(300, 20);
		length.setSize(40, 20);
		error.setSize(380, 20);
		createArray.setSize(100, 20);
		exit.setSize(100, 20);
		
		//sets the location of the various JFrame elements into the JFrame
		arrayDescription.setLocation(10, 10);
		length.setLocation(330, 10);
		error.setLocation(10, 40);
		createArray.setLocation(10, 60);
		exit.setLocation(270, 60);
		
		//adds the JFrame elements into the JFrame
		window.add(arrayDescription);
		window.add(length);
		window.add(error);
		window.add(createArray);
		window.add(exit);
		
		//sets window visible and default close operations
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//method to start the program
	public static void main(String[] args)
	{
		//creates the first JFrame
		InsertArrayGUI create = new InsertArrayGUI();
	}
	
	//class to use the create button 
	private class CreateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//sets the error text to blank
			error.setText("");
			//try statement to make sure the input is a positive integer
			try 
			{
				//gets the array length from the JTextField
				int arrayLength = Integer.parseInt(length.getText());
				//checks to make sure that the input is positive
				if (arrayLength <= 0)
				{
					throw new OutOfRangeException();
				}
				else
				{
					//creates a new JFrame and disposes of the old one
					InsertGUI createdArray = new InsertGUI(arrayLength);
					dispose();
				}
			}
			//catch statement for a non integer value
			catch(NumberFormatException e1)
			{
				error.setText("ERROR: Input is not an integer.");
			}
			//catch statement for a non positive value
			catch(OutOfRangeException e1)
			{
				error.setText("ERROR: Input must be a positive non-zero integer.");
			}
		}
	}
	
	//class to use the exit button
	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);//exits program
		}	
	}
}
