//2nd JFrame for the program

//packages needed to complete this JFrame
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//class for the 2nd JFrame
public class InsertGUI extends JFrame
{
	
	//declaring various elements of the JFrame
	private static int WIDTH = 400;//width of the JFrame
	private static int HEIGHT = 300;//height of the JFrame
	private JLabel insertDescription;//instructions for the 2nd JFrame
	private JLabel indexLb;//label for the combo box
	private JComboBox indexCb;//combo box for input for the index location
	private JLabel numLb;//label for the text field
	private JTextField numTx;//text field for the number to be entered in the array
	private JTextArea arrayTa;//text area to hold the array
	private JLabel error;//label to hold error message
	private JButton back;//button to go back to previous JFrame
	private JButton insert;//button to insert number in index location in the array
	private JButton exit;//button to exit application
	private int[] array;//integer array to have numbers inserted
	private int arrayLength;//length of integer array
	
	//method to create 2nd JFrame
	public InsertGUI(int length)
	{
		//sets window elements
		setTitle("Insert Number into Array");
		Container window = getContentPane();
		setSize(WIDTH, HEIGHT);
		window.setLayout(null);
		
		//declares and initializes the array needed for the combo box
		String[] indexArray = new String[length];
		for(int index = 0; index < length; index++)
		{
			indexArray[index] = "" + (index + 1);
		}
		
		//initializes the JFrame elements
		insertDescription = new JLabel("Enter the number to insert and the location in the array.");
		indexLb = new JLabel("Enter the location in the array: ");
		indexCb = new JComboBox(indexArray);
		numLb = new JLabel("Enter the number to be inserted: ");
		numTx = new JTextField();
		arrayTa = new JTextArea();
		arrayTa.setEditable(false);
		arrayTa.setLineWrap(true);
		error = new JLabel();
		error.setForeground(Color.red);
		back = new JButton("Back");
		BackButtonHandler bHandler = new BackButtonHandler();
		back.addActionListener(bHandler);
		insert = new JButton("Insert");
		InsertButtonHandler iHandler = new InsertButtonHandler();
		insert.addActionListener(iHandler);
		exit = new JButton("Exit");
		ExitButtonHandler eHandler = new ExitButtonHandler();
		exit.addActionListener(eHandler);
		arrayLength = length;
		
		//initialize integer array
		array = new int[arrayLength];
		
		//outputs integer array to text area
		arrayTa.setText(Integer.toString(array[0]));
		for(int index = 1; index < arrayLength; index++)
		{
			arrayTa.append(", " + array[index]);
		}
		
		//sets size for various JFrame elements
		insertDescription.setSize(380, 20);
		indexLb.setSize(200, 20);
		indexCb.setSize(100, 20);
		numLb.setSize(200, 20);
		numTx.setSize(100, 20);
		arrayTa.setSize(360, 60);
		error.setSize(380, 20);
		back.setSize(100, 20);
		insert.setSize(100, 20);
		exit.setSize(100, 20);
		
		//sets location for various JFrame elements
		insertDescription.setLocation(10, 10);
		indexLb.setLocation(10, 40);
		indexCb.setLocation(250, 40);
		numLb.setLocation(10, 70);
		numTx.setLocation(250, 70);
		arrayTa.setLocation(10, 100);
		error.setLocation(10, 170);
		back.setLocation(10, 200);
		insert.setLocation(140, 200);
		exit.setLocation(270, 200);
		
		//adds JFrame elements to the window
		window.add(insertDescription);
		window.add(indexLb);
		window.add(indexCb);
		window.add(numLb);
		window.add(numTx);
		window.add(arrayTa);
		window.add(error);
		window.add(back);
		window.add(insert);
		window.add(exit);
		
		//sets window visible and default close operations
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//class to use the insert button
	private class InsertButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//sets error text to blank
			error.setText("");
			
			//try statement to check user input is an integer
			try
			{
				//gets number to be inserted into array from text field
				int number = Integer.parseInt(numTx.getText());
				//gets index location from combo box
				int insert = indexCb.getSelectedIndex();
				//calls the InsertAt method
				InsertAtLocation.InsertAt(array, arrayLength, insert, number);
			}
			
			//catch statement that displays error message if number is not an integer
			catch(NumberFormatException e1)
			{
				error.setText("ERROR: Input is not an integer.");
			}
			
			//re-outputs integer area to text area
			arrayTa.setText(Integer.toString(array[0]));
			for(int index = 1; index < arrayLength; index++)
			{
				arrayTa.append(", " + array[index]);
			}
		}
	}
	
	//class to use back button
	private class BackButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//creates a new JFrame the same as the 1st JFrame in the program
			InsertArrayGUI x = new InsertArrayGUI();
			//disposes of this JFrame
			dispose();
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