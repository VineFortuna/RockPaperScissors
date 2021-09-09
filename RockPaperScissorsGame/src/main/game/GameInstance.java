package main.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Main;

public class GameInstance {

	private final GameManager manager;
	public GameState state;
	public List<String> players;

	public GameInstance(GameManager manager) {
		this.manager = manager;
		this.state = GameState.WAITING; // Default state
		this.players = new ArrayList<>();
	}

	public void AddToGame(String playerOne, String playerTwo) {
		if (state == GameState.WAITING) {
			players.add(playerOne);
			players.add(playerTwo);
			CheckForStart();
		}
	}

	public void CheckForStart() {
		if (players.size() == 2) {
			StartGame();
		} else {
			Main.SendMsg("Error on checking for game start");
		}
	}

	public void StartGame() {
		state = GameState.IN_PROGRESS;
		Main.SendBlank(3);
		Main.SendMsg("GAME STARTED!");
		Main.SendBlank(3);

		Game(players.get(0), players.get(1));
	}

	public void Game(String playerOne, String playerTwo) {
		Scanner s = new Scanner(System.in);
		String output = "";

		Main.SendMsg("" + playerOne + " will be going first");
		Main.SendMsg("Please enter your choice: (R, P, or S)");
		String p1Choice = s.nextLine();

		Main.SendMsg("" + playerTwo + "'s turn is next");
		Main.SendMsg("Please enter your choice: (R, P, or S)");
		String p2Choice = s.nextLine();

		if (p1Choice.equals(p2Choice)) {
			Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
			Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
			Main.SendMsg("It's a tie!");
			EndGame();
		}

		if (p1Choice.equals("R")) {
			if (p2Choice.equals("P")) {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerTwo + " wins!");
				EndGame();
			} else if (p2Choice.equals("S")) {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerOne + " wins!");
				EndGame();
			} else {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerOne + " wins!");
				EndGame();
			}
		} else if (p1Choice.equals("P")) {
			if (p2Choice.equals("R")) {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerOne + " wins!");
				EndGame();
			} else if (p2Choice.equals("S")) {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerTwo + " wins!");
				EndGame();
			} else {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerOne + " wins!");
				EndGame();
			}
		} else if (p1Choice.equals("S")) {
			if (p2Choice.equals("R")) {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerTwo + " wins!");
				EndGame();
			} else if (p2Choice.equals("P")) {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerOne + " wins!");
				EndGame();
			} else {
				Main.SendMsg("" + playerOne + "'s choice: " + p1Choice);
				Main.SendMsg("" + playerTwo + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerOne + " wins!");
				EndGame();
			}
		} else {
			if (p2Choice.equals("R")) {
				Main.SendMsg("" + playerOne + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerTwo + " wins!");
				EndGame();
			} else if (p2Choice.equals("P")) {
				Main.SendMsg("" + playerOne + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerTwo + " wins!");
				EndGame();
			} else if (p2Choice.equals("S")) {
				Main.SendMsg("" + playerOne + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerTwo + "'s choice: " + p2Choice);
				Main.SendMsg("" + playerTwo + " wins!");
				EndGame();
			} else {
				Main.SendMsg("" + playerOne + "'s choice: " + "INVALID");
				Main.SendMsg("" + playerTwo + "'s choice: " + "INVALID");
				Main.SendMsg("No one wins :(");
				EndGame();
			}
		}
	}

	public void EndGame() {
		state = GameState.ENDED;
		manager.RemoveGame(this);
		Main.SendBlank(3);
		Main.SendMsg("Thank you for playing! :)");
		return;
	}

}
