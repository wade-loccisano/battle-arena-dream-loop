package com.wade;

import java.util.Scanner;

public class App {
		
    public static void main( String[] args ) {
    	
    	Scanner input = new Scanner(System.in);
    	boolean newGame = true;
    	boolean newMonster = true;
    	int stamina = 10; //reduces to 0, then user dies
    	int panic = 10; //raises to 20 then user dies
    	int turn = 1; //raises to 10 then user dies
    	int d6Roll = 1;
    	Monster currentMonster = new Monster();

        while (true) {
        	if (newGame) {
        		System.out.println("Welcome to the Battle Arena");
        		System.out.println("***************************");
        		stamina = 10;
        		panic = 10;
        		turn = 1;
        		newGame = false;
        		newMonster = true;
        	}
        	if (newMonster) {
        		currentMonster = new Monster();
        		System.out.println("The enemy, " + currentMonster.getMonsterName() + ", enters the battle arena!\n");
        		newMonster = false;
        	}
        	
        	System.out.println("*********************************");
	        System.out.println("Turn: " + turn + " | Current Stamina: " + stamina + " | Current Panic!: " + panic);
	        System.out.println(currentMonster.getMonsterName() + " Hit Points Remaining: " + currentMonster.getMonsterHP());
	        System.out.println("Press Enter to continue...");
	        
	        input.nextLine();
	        d6Roll = (int)(Math.random()*6) + 1;

	        switch(d6Roll) {
		        case 1:
		        	panic += 2;
		        	System.out.println(">The " + currentMonster.getMonsterName() + " strikes you unexpectedly. You begin to panic. Panic + 2");
		        	break;
		        case 2:
		        	stamina -= 1;
		        	System.out.println(">You dodge " + currentMonster.getMonsterName() +"'s attack but feel winded. Stamina - 1");
		        	break;
		        case 3:
		        	System.out.println(">You parry the enemy's atack with ease. No stat changes.");
		            break;
		        case 4:
		        	stamina += 1;
		        	System.out.println(">The enemy cowers before your might! You take a deep breath. Stamina + 1");
		            break;
		        case 5:
		        	panic -= 1;
		        	currentMonster.decreaseMonsterHP(3);
		        	System.out.println(">Your attack glances the " + currentMonster.getMonsterName() + ". Your confidence grows! Panic - 1, Enemy HP - 3");
		            break;
		        case 6:
		        	stamina += 2;
		        	panic -= 3;
		        	currentMonster.decreaseMonsterHP(5);
		        	System.out.println(">You strike " + currentMonster.getMonsterName() + " with a massive blow! You feel heroic! Stamina + 2, Panic - 3, Enemy HP - 5");
		            break;
		        default:
		        	System.out.println(">That's strange. For a second, there, you felt like you were in a dream...");
	        	
	        }
	        System.out.println();
	        turn++;
	        
	        if (currentMonster.getMonsterHP() > 0) {
	        	System.out.println("The " + currentMonster.getMonsterName() + " still lives. Your stamina decreases by 1 and your panic increases by 1!\n");
	        	panic++;
	        	stamina--;
	        } else {
	        	System.out.println("You defeated the " + currentMonster.getMonsterName() +"! You hear something approaching...");
	        	newMonster = true;
	        	turn = 1;
	        }
	        
	        if (stamina < 1) {
	        	System.out.println("You are out of stamina. You begin to black out...");
	        	System.out.println("DEFEAT (Stamina 0)\n");
	        	newGame = true;
	        } else if (panic > 19) {
	        	System.out.println("Your panic has driven you insane. You feel reality slipping away from you...");
	        	System.out.println("DEFEAT (Panic 20+)\n");
	        	newGame = true;
	        } else if (turn > 10) {
	        	System.out.println("You cannot seem to gain the upperhand. The madness of combat takes you...");
	        	System.out.println("DEFEAT (Turns 10+)\n");
	        	newGame = true;
	        } else {
	        	if (newMonster == false) {
	        		System.out.println("Beginning Turn " + turn + "...");
	        	} else {
	        		System.out.println("VICTORY!\n");
	        	}
	        }
        }
    }
}
