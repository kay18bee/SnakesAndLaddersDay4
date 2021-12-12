package com.bl.snakesladders;

import java.util.Random;
import java.util.Scanner;

public class SnakesLaddersUC7 {
	
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
    
	static char players(int player1, int player2)
	{   int diceCountForPlayer1 = 0;
		int diceCountForPlayer2 = 0;
		int turnCount = 0;
		while (player1 < 100 && player2 < 100)
		{ 
			if(turnCount % 2 == 0 ) 
			  { 
				System.out.println("It is Player 1's turn.");
			    computationLogic();
			    turnCount++;
			    diceCountForPlayer1++;
		      }
			else 
			  {
				System.out.println("It is Player 2's turn.");
				computationLogic();
				turnCount++;
				diceCountForPlayer2++;
			  }
			
		}
		System.out.println("Player 1 rolled the dice " + diceCountForPlayer1 + " times.");
		System.out.println("Player 2 rolled the dice " + diceCountForPlayer2 + " times.");
      return 0 ;
	} 
		
		
	public static int computationLogic() 
	{
		int player_position = 0;
		
			System.out.println("Type 0 to roll the dice. ");
			Scanner sc = new Scanner(System.in);
	        int answer = sc.nextInt();
	        if (answer == 0)
	           {   
	        	int a = dice();
	        	
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
	 
		return 0;
	}
public static void main(String[] args) 
{
	int player1 = 0;
	int player2 = 0;
	System.out.println("Welcome to the Snakes and ladders game.");
	System.out.println("Choose your sequence. Player1 will play first followed by Player2.");
    players(player1 , player2);
    
}
}