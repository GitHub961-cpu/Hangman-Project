package Hangman;

import java.util.Scanner;
/**
 * The "Hangman game, promts the user to guess a secret word,
 * if guessed win, not guessed hang
 * @author Saule Buhler
 * CSIS 2450
 */
public class hangman {
	
	public static void main(String[] args) {

		int numOfLives = 6;
		
		Scanner scanner = new Scanner(System.in);
		
		int randomIndex = (int)(Math.random() * 5);
		
		String words[] = {"Utah", "Orem", "Sandy", "Midvale", "Murray"};
		
		String guessWord = words[randomIndex];
		
		StringBuilder guessedLetters = new StringBuilder();
		
		Boolean guessedCompletely = false;
		
		//keep asking player to guess until # of lives = 0, or guessed
		while(!guessedCompletely) {
			
			System.out.println("Lives left: "+ numOfLives);
			
			//replace the secret word with _ and print out
			String hiddenWord = guessWord.replaceAll("[^" + guessedLetters + "^]", "- ");
			System.out.println("\n" + hiddenWord);
			
			//check if secret word matches with what player guessed
			//there is a little bug, it still asks to enter one more time after
			//word is already guessed, don't know how to fix it yet
			guessedCompletely = hiddenWord.equalsIgnoreCase(guessWord) ? true : false;
			
			
			System.out.print("\nYour guess: ");
			String userGuess = scanner.nextLine();
			
			//if secret word contains the letter, keep track of guessed letters
			if(guessWord.contains(userGuess)) {
				guessedLetters.append(userGuess);
				
			}else {
				numOfLives = numOfLives - 1;
				System.out.println("No, try again!");
			}
			
			//visual
			System.out.println("\t\t -------");
			System.out.println("\t\t |     |");
			
			if(numOfLives <= 5) {
				System.out.println("\t\t o");
			}
			if(numOfLives <= 4) {
				System.out.print("\t\t\\ ");
				if(numOfLives <= 3) {
					System.out.println("/");
				}
				else {
					System.out.println("");
				}
			}
			if(numOfLives <= 2) {
				System.out.println("\t\t |");
			}
			if(numOfLives <= 1) {
				System.out.print("\t\t/ ");
				if(numOfLives <= 0) {
					System.out.println("\\ ");
				}
				else {
					System.out.println("");
				}
			}
			
			//end the game
			if(numOfLives == 0 && guessedCompletely == false) {
				break;
			}else if(numOfLives == 0){
				break;
			}
			else if(guessedCompletely == true){
				break;
			}
		}
		
		//win or lose
		if(guessedCompletely == true) {
			System.out.println("You won!");
		}else {
			System.out.println("You lost!");
		}
		scanner.close();
	}

}
