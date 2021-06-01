/**
 * 
 *Lo Phillips
 *11/7/19
 *Pledged!
 */
import java.util.*;
public class Prog3 {
	public static void main(String[] args){
		String name;
		Scanner keyboard = new Scanner(System.in);
		CList<Player> playerList = new CList<Player>();
		System.out.println("Enter the number of players in the game: ");
		int players = keyboard.nextInt();
		for(int i = 1; i <= players; i++) {
			System.out.println("Enter the name of Player " + i);
			name = keyboard.next();
			Player player = new Player(name, i);
			playerList.append(player);
		}//for
		System.out.println("Enter the number of passes in the game: ");
		int passes = keyboard.nextInt();
		hotPotatoGame(players, passes, playerList);
	    }//main
	
	
	public static void hotPotatoGame(int players, int passes, CList<Player> playerList) {
		playerList.moveToStart();
		int currPlayers = players;
		if(players > 1) {
		for(int i = 1; i < players; i++) {
			System.out.println("Round " + i + ":");
			//cycle to the removed player
			for(int z = 1; z <= passes; z++)
			playerList.next();
			//remove the player
			System.out.println("The player " + playerList.getValue().getName() + " is eliminated.");
			playerList.remove();
			//update the list
			for(int a = 1; a < currPlayers; a++) {
				playerList.getValue().setPosition(a);
				playerList.next();
			}//for
			currPlayers--;
			playerList.moveToStart();
			System.out.println();
			//check if the list only has one player
		for(int j = 0; j < currPlayers; j++) {
			if(currPlayers == 1)
				System.out.println("The winner is " + playerList.getValue().getName() + ".");
			else {
		System.out.println("player " + playerList.getValue().getName() + " is at position " + playerList.getValue().getPosition());
		playerList.next();
			}//else
			}//for
		System.out.println();
		for(int j = 1; playerList.getValue().getPosition() != j; playerList.next()){}
	}//for
		}//if
		else
			System.out.println("Only one player, player 1 wins.");
	}//hotPotatoGame
			
}//Prog3
