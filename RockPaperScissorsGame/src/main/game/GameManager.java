package main.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Main;

public class GameManager {

	public List<GameInstance> games = new ArrayList<>();

	public void JoinGame() {
		GameInstance instance = null;
		Scanner s = new Scanner(System.in);
		Main.SendMsg("Welcome to the Rock Paper Scissors Game!");
		Main.SendMsg("Made By: " + Main.creator);
		Main.SendBlank(3);
		
		Main.SendMsg("Please enter your name for Player 1:");
		String playerOne = s.nextLine();
		Main.SendMsg("Please enter your name for Player 2:");
		String playerTwo = s.nextLine();
		Main.SendBlank(3);

		if (instance == null) {
			if (!(games.contains(instance))) {
				instance = new GameInstance(this);
				games.add(instance);
			}
		}
		
		instance.AddToGame(playerOne, playerTwo);
	}
	
	public void RemoveGame(GameInstance instance) {
		games.remove(instance);
	}
}
