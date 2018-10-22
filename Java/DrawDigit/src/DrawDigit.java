/*This program asks for a number and color
 * It then draws the number in that color
 * by Amber Simpson
 */
//import statements for the components needed for the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//program to ask for a number and create a graphic representation
public class DrawDigit extends JFrame
{
	//variables for the width and height of the window
	private static int WIDTH = 410;
	private static int HEIGHT = 480;
	
	//variables for the window components
	private JLabel enterNum;//label for instructions on entering number
	private JComboBox num;//combo box for entering number
	private JLabel enterColor;//label for instruction on entering color
	private JComboBox color;//combo box for entering color
	private Canvas graphic;//window component that can be painted on
	private Graphics g; //graphic to be changed
	private JButton draw;//button that repaints graphic
	private JButton exit;//button to exit program
	
	//variables to get the number and color
	private int numType = 1;
	private int colorType = 1;
	private Color currentColor;
	
	//constructor to create the window and components
	public DrawDigit()
	{
		//setting window components
		setTitle("Digit Graphics");
		Container window = getContentPane();
		setSize(WIDTH, HEIGHT);
		window.setLayout(null);
		
		//initializing window components
		enterNum = new JLabel("Enter the number to be displayed: ");
		String numbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		num = new JComboBox(numbers);
		num.setMaximumRowCount(1);
		enterColor = new JLabel("Enter the color of the number: ");
		String colors[] = {"Black", "Red", "Green", "Blue", "Orange", "Yellow"};
		color = new JComboBox(colors);
		color.setMaximumRowCount(1);
		graphic = new Canvas();
		graphic.setBackground(Color.white);
		draw = new JButton("Draw");
		DrawButtonHandler dHandler = new DrawButtonHandler();
		draw.addActionListener(dHandler);
		exit = new JButton("Exit");
		ExitButtonHandler eHandler = new ExitButtonHandler();
		exit.addActionListener(eHandler);
		
		//setting size for window components
		enterNum.setSize(290, 20);
		num.setSize(80, 20);
		enterColor.setSize(290, 20);
		color.setSize(80, 20);
		graphic.setSize(300, 300);
		draw.setSize(80, 20);
		exit.setSize(80, 20);
		
		//setting location for window components
		enterNum.setLocation(10, 10);
		num.setLocation(300, 10);
		enterColor.setLocation(10, 30);
		color.setLocation(300, 30);
		graphic.setLocation(50, 80);
		draw.setLocation(10, 400);
		exit.setLocation(300, 400);
		
		//adding window components to window
		window.add(enterNum);
		window.add(num);
		window.add(enterColor);
		window.add(color);
		window.add(graphic);
		window.add(draw);
		window.add(exit);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//creating an action handler for draw button
	private class DrawButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//changes color and number to those selected
			colorType = color.getSelectedIndex() + 1;
			numType = num.getSelectedIndex() + 1;
			//repaints the windows component
			graphic.repaint();
		}
	}
	//creating an action handler for the exit button
	private class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);//exits program
		}	
	}
	
	//programs main method
	public static void main(String[] args)
	{
		DrawDigit drawDigit = new DrawDigit();
	}
	
	//creates the canvas class that can be painted on
	public class Canvas extends JPanel
	{
		//overrides the paintComponent method
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			//clears the panel of previous number
			g.clearRect(0, 0, 300, 300);
			//chooses number color according to combo box
			switch (colorType)
			{
			case 1: 
				currentColor = Color.black;
				break;
			case 2: 
				currentColor = Color.red;
				break;
			case 3:
				currentColor = Color.green;
				break;
			case 4:
				currentColor = Color.blue;
				break;
			case 5:
				currentColor = Color.orange;
				break;
			case 6:
				currentColor = Color.yellow;
			}
			//sets graphic to chosen color
			g.setColor(currentColor);
			//creates the drawing according to number combo box selection
			switch (numType)
			{
			case 1:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 20, 20, 260);
				g.fillRect(50, 260, 200, 20);
				g.fillRect(230, 20, 20, 260);
				break;
			case 2:
				g.fillRect(140, 20, 20, 260);
				break;
			case 3:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 140, 200, 20);
				g.fillRect(50, 260, 200, 20);
				g.fillRect(50, 140, 20, 130);
				g.fillRect(230, 20, 20, 130);
				break;
			case 4:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 140, 200, 20);
				g.fillRect(50, 260, 200, 20);
				g.fillRect(230, 20, 20, 260);
				break;
			case 5:
				g.fillRect(50, 140, 200, 20);
				g.fillRect(230, 20, 20, 260);
				g.fillRect(50, 20, 20, 130);
				break;
			case 6:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 140, 200, 20);
				g.fillRect(50, 260, 200, 20);
				g.fillRect(50, 20, 20, 130);
				g.fillRect(230, 140, 20, 130);
				break;
			case 7:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 140, 200, 20);
				g.fillRect(50, 260, 200, 20);
				g.fillRect(50, 20, 20, 260);
				g.fillRect(230, 140, 20, 130);
				break;
			case 8:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(230, 20, 20, 260);
				break;
			case 9:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 20, 20, 260);
				g.fillRect(50, 140, 200, 20);
				g.fillRect(50, 260, 200, 20);
				g.fillRect(230, 20, 20, 260);
				break;
			case 10:
				g.fillRect(50, 20, 200, 20);
				g.fillRect(50, 140, 200, 20);
				g.fillRect(230, 20, 20, 260);
				g.fillRect(50, 20, 20, 130);
			}
		}
	}
}
