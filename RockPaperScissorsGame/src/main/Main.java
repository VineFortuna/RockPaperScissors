package main;

import java.util.Scanner;

import main.game.GameManager;

public class Main {
	
	public static String creator = "Anthony Ciceu";

	public static void main(String[] args) {
		GameManager manager = new GameManager();
		manager.JoinGame();
	}
	
	public static void SendMsg(String msg) {
		System.out.println(msg);
	}
	
	public static void SendBlank(int num) {
		for (int i = 0; i < num; i++)
			System.out.println("");
	}

}
