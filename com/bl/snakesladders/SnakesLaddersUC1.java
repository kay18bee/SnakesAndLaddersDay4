//This package contains use-cases from 1-6.

package com.bl.snakesladders;

import java.util.Random;
import java.util.Scanner;

public class SnakesLaddersUC1 {
	
	static final int final_position = 100;
	static final int initial_position = 0;
	
	static int dice() 
	{   
		int diceRoll = (int)(Math.random()*6 )+1 ; 
		System.out.println("You rolled: " + diceRoll);
		return diceRoll;
	}
	
	static int your_options() 
	{
		
		Random r = new Random();
		int option = r.nextInt(3); 
		
		return option ;
	}
    
	public static void main(String[] args) 
	{
		int count = 0;
		int player_position = 0;
		System.out.println("Welcome to the Snakes and ladders game.");
		
		for (int i = initial_position; i<= final_position; i++) 
		{
		
			System.out.println("Type 0 to roll the dice. ");
			Scanner sc = new Scanner(System.in);
	        int answer = sc.nextInt();
	        if (answer == 0)
	           {   
	        	int a = dice();
	        	count++;
	            your_options();
	            
	        	switch(your_options())
		    		{
		    	
			    		case 0: System.out.println("Option generated: Snake.");
			    		        if(player_position >= initial_position && player_position < a)
			    		        {
			    		        	player_position = initial_position;
			    		        }
			    		        else 
			    		        {
			    		        	player_position = player_position - a;
			    		        }
			    				
			    				break;
			    				
			    		case 1: System.out.println("Option generated: Ladder. ");
			    				if(a + player_position > final_position)
			    		        {
			    		           player_position = player_position + 0;
			    		        }	
			    		        else if(a+player_position == final_position || player_position == final_position)
		    		        	{   
		    		        		System.out.println("You have won.");
		    		        	}
			    		        else
			    		        {
			    		        	player_position = player_position + a;
			    		        }
			    		      
			    		        break;
			    		       
			    		case 2: System.out.println("Option generated: Cannot move."); 
			    		        player_position = player_position + 0;
			    		        break;
			    		
			    		default: break;        
			    		
			    		}
			    		
	        }	
	        else
	        {
        	  System.out.println("Invalid input.");
	        }
	        
		  System.out.println("You are at " + player_position + " tile.");
		}	
        
		System.out.println("The dice has been rolled " + count + " times in total.");
     }
	
}

