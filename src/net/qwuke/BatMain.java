/*
 * @author Tristan Mortimer
 * 
 *
 * 
 */

package net.qwuke;

import java.util.Scanner;

public class BatMain {

	public static int[] setAtBats(int numBats, Scanner scan) {
		//Takes a scanner and the number of times at bat, uses this to validate and then insert values into an array which we can use to calculate bat avg
		int[] arrBats = new int[numBats];
		for (int i = 0; i<arrBats.length; i++) {
			 arrBats[i] = Validator.getInt(scan, "Result for at-bat: ", 0, 4);
		}
		return arrBats;
	}
	
	public static double getAvgBat(int [] bats) {
		//if >0, add one, divide by total arr length
		int numBatAvg = 0;
		int divisorBatAvg = bats.length;
		
		for(int i:bats) {
			if(i != 0) {
				numBatAvg++;
			}
		}
		double batAvg = ((double) numBatAvg / (double) divisorBatAvg);
		return batAvg;
	}
	
	public static double getSlugBat(int[] bats) {
		//literally the average value in the array
		//why isnt this just called batting average
		int numSlug = 0;
		for(int i:bats) {
			numSlug += i;
		}
		double slugBat = (double) numSlug / (double) bats.length;
		return slugBat;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String valid = "y"; // String for validating whether or not to continue based on y or n
		System.out.println("Welcome to the Batting Average Calculator");
		System.out.println("");

		while (valid.equalsIgnoreCase("y")) {

			int numAtBat = Validator.getInt(sc, "Enter the (positive and whole) number of times at bat: ", 1, Integer.MAX_VALUE);
			
			
			System.out.println("");
			System.out.println("Enter a value from 0-4 to determine how many bases you run");
			System.out.println("0=Out, 1=Single, 2=Double, 3=Triple, 4=Home run");
			
			
			int[] arrAtBats = setAtBats(numAtBat, sc);
			
			System.out.println("");
			System.out.print("Batting average: "); 
			System.out.printf("%.3f", getAvgBat(arrAtBats));
			System.out.println("");
			System.out.print("Slugging percentage: ");
			System.out.printf("%.3f", getSlugBat(arrAtBats));
			System.out.println("");

			// Display batting average and slugging percentage

			System.out.println("Another batter? Type y to continue or n to end the program");
			valid = sc.nextLine();
			while (!(valid.equalsIgnoreCase("y") || valid.equalsIgnoreCase("n"))) {
				System.out.println("That wasn't a valid input! Type y to continue or n to stop");
				valid = sc.nextLine();
			}
		} // If y, rerun the program

		sc.close();
	}

}
