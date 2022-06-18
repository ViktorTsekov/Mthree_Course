package org.Viktor.assesment;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import  java.util.Scanner;

public class RockPaperScissors {
    static Map<Integer, String> options = new HashMap<Integer, String>();

    static String decideWinner(int player, int computer) {
        String temp = computer - 1 < 1 ? options.get(3) : options.get(computer - 1);

        if(player == computer) {
            return "Tie";
        }

        return options.get(player) == temp ? "Computer Wins" : "Player Wins";
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player = 0;
        int computer = 0;

        options.put(1, "Rock");
        options.put(2, "Paper");
        options.put(3, "Scissors");

        while(player != -1) {
            System.out.print("Pick an option\n 1: Rock\n 2: Paper\n 3: Scissors\n -1: Exit\n");

            try {
                System.out.print("Input: ");
                player = scanner.nextInt();
                computer = random.nextInt(3) + 1;
            } catch (Exception e) {
                System.out.println("Unexpected Error!\n");
                break;
            }

            if(options.containsKey(player)) {
                System.out.println("Player Picks: " + options.get(player));
                System.out.println("Computer Picks: " + options.get(computer));
                System.out.println(decideWinner(player, computer) + "\n");
            } else {
                System.out.println(player != -1 ? "Invalid Input\n" : "");
            }
        }
    }
}
