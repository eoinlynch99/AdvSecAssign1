/* Eoin Lynch - C17310846
 * Advanced Security 1
 * Assignment 1 */

 package assign1;
 

import java.util.Scanner;

public class controlAssign 
{
	public static void main(String[] args) 
	{
		int num1, ans1 = 0;
		int iter;
		boolean repeat = true;
		
		
		MilRabAlg MRA = new MilRabAlg();
		AESKeyExp AES = new AESKeyExp();
		Scanner sc = new Scanner(System.in);
		
		while (repeat)
		{		

			System.out.println("Please enter which algorithm you want to use:\n" +
							   "(Enter 1 for the Miller Rabin Algorithm. " +
							   "Enter 2 for the Key Expansion.)");
			
			ans1 = sc.nextInt();
			
			
			if (ans1 == 1)
			{
				// Part A Miller Rabin Algorithm
				try
				{
					
					System.out.println("Please enter a number to test if prime:");
					num1= sc.nextInt();
					System.out.println("Enter how many times you want to iterate ");
					iter = sc.nextInt();
					
				}
				
				catch (Exception e)
				{
					
					System.out.println("Please enter a valid positive integer.");
					break;
					
				}
		        
				if (num1 < 0)
				{
					System.out.println("Please enter a positive integer.\n");
				}
				
		        if (MRA.isPrime(num1, iter)) 
		            System.out.print("inconclusive result.\n\n");
		        
		        else
		        	System.out.print("composite result.\n\n"); 
			}
			else if (ans1 == 2)
			{
				
				// Part B AES key expansion
				try
				{
					
					String str1 = "0f1571c947d9e8590cb7add6af7f6798";
					
					// this is to make an array to store the key
					byte[] AESkey = new byte[str1.length() / 2];
					
					for (int i = 0; i < AESkey.length; i++) 
					{
						int AESindex = i * 2;
					    int n = Integer.parseInt(str1.substring(AESindex, AESindex + 2), 16);
					    
					    //Adds the integer to the array of keys
					    AESkey[i] = (byte) n; 
					     
					}
					  
					System.out.println("Key = " + AESkey);
					int word[] = new int[44];
					//Performs the expansion
					AES.keyExpansion(AESkey, word);
					
					//Create a new array to hold the results
					String[] ResultList = new String[44];
					  
					for(int i =0;i<44;i++)
					{
						ResultList[i] = Integer.toHexString(word[i]);
						
						// Displaying the results from the list
						System.out.println(ResultList[i]);
					}	
					
					System.out.println("\n");
				}
				catch (Exception e)
				{
					System.out.println("Please enter only positive integers.");
					break;
				}
			}
			else
			{
				System.out.println("\nInvalid option entered.\n\n");
			}
		}
		
		sc.close();
	}

}
