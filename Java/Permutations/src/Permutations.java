import java.util.*;
/* This program shows permutations of three strings.
 * By Amber Simpson
 */
public class Permutations {

	public static void main(String[] args) 
	{
		//create the console so that input works
		Scanner console = new Scanner(System.in);
		//creating the string variables
		String str1;
		String str2;
		String str3;
		//Prompting user for strings and recording the responses
		System.out.println("This program asks for three strings and then shows there permutations.\n\n");
		System.out.println("Please enter your first string.");
		str1 = console.nextLine();
		System.out.println("Please enter your second string.");
		str2 = console.nextLine();
		System.out.println("Please enter your third string.");
		str3 = console.nextLine();
		//Outputting the permutations of the three strings
		System.out.println("\nFirst permutation is " + str1 + str2 + str3);
		System.out.println("Second permutation is " + str1 + str3 + str2);
		System.out.println("Third permutation is " + str2 + str1 + str3);
		System.out.println("Fourth permutation is " + str2 + str3 + str1);
		System.out.println("Fifth permutation is " + str3 + str1 + str2);
		System.out.println("Sixth permutation is " + str3 + str2 + str1);
	}

}
