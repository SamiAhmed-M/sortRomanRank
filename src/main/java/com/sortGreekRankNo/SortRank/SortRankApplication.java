/*Programmed by Sami M. Ahmed
 * considering user input as Eg. Raol XXI output as 21=Raol
 * accept user input into string array
 * convert roman rank into decimal
 * sort by rank and display result
 * 
 */
package com.sortGreekRankNo.SortRank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

@SpringBootApplication
public class SortRankApplication {
	
	public static void convert(String [] arr)
	{
		// create collection for storage of key and value
		HashMap<Integer, String> HM = new HashMap<>();
		// determine array length
		int y = arr.length;
		for (int j=0; j< y; j++)
		{
			// split every array member into value and key in roman number
			String []temp = arr[j].split(" "); // temp[1] is the RomanNumber
			int sum = 0;
			// convert temp[1] into array of characters
			int x = temp[1].length();
			char [] str = new char[x];
			str = temp[1].toCharArray();
			// number of array elements for str[]
			int z = str.length;
			for (int k=0; k<z; k++)
			{
				char N = str[k];
				switch(N)
				{
				case 'I': sum += 1; break;
				case 'V': sum += 5; break;
				case 'X': sum += 10; break;
				case 'L': sum += 50; break;
				case 'C': sum += 100; break;
				case 'D': sum += 500; break;
				case 'M': sum += 1000; break;
				default: System.out.println("Check your roman number");
				}
			}
			HM.put(new Integer(sum), temp[0]);
		}
		// Display output
		TreeMap<Integer, String> TM = new TreeMap<>(HM);
		System.out.println(TM);
	}

	public static void main(String[] args) {
		//SpringApplication.run(SortRankApplication.class, args);
		// accept user input
		System.out.println("Please enter 5 names with Roman Rank separated by space");
		Scanner myObj = new Scanner(System.in);
		String [] namesRoman = new String[5];
		for(int i=0;i<5;i++)
		{
		namesRoman[i] = myObj.nextLine();
		}
		myObj.close();
		
		// pass the accepted array to convert method
		convert(namesRoman);
	}

}
