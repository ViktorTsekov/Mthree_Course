package org.Viktor.assesment;

import java.util.*;

public class RockPaperScissors {
    static Map<Integer, String> options = new HashMap<Integer, String>();
    static Map<String, Integer> score = new HashMap<String, Integer>();

    static String decideWinner(int player, int computer) {
        if(player == computer) {
            score.put("Tie", score.get("Tie") + 1);
            return "Tie";
        }

        String temp = computer - 1 < 1 ? options.get(3) : options.get(computer - 1);

        if(options.get(player) == temp) {
            score.put("Computer", score.get("Computer") + 1);
            return "Computer Wins";
        } else {
            score.put("Player", score.get("Player") + 1);
            return "Player Wins";
        }
    }

    static int concludeGame() {
        if(score.get("Player") == score.get("Computer")) {
            return 0;
        }

        return score.get("Player") > score.get("Computer") ? 1 : -1;
    }

    static void resetScore() {
        score.put("Tie", 0);
        score.put("Player", 0);
        score.put("Computer", 0);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player;
        int computer;
        int numRounds;
        String userInput = "";

        options.put(1, "Rock");
        options.put(2, "Paper");
        options.put(3, "Scissors");

        while (!userInput.equals("No")) {
            resetScore();

            do {
                try {
                    System.out.print("How many rounds do you want to play (1-10): ");
                    numRounds = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Unexpected Error!");
                    return;
                }
            } while (numRounds < 1 || numRounds > 10);

            System.out.println();

            for (int i = 0; i < numRounds;) {
                System.out.println("Round: " + (i + 1));
                System.out.println("Current Score:" + " Player-" + score.get("Player") + " Computer-" + score.get("Computer") + " Ties-" + score.get("Tie"));
                System.out.print("Pick an option\n 1: Rock\n 2: Paper\n 3: Scissors\n");

                try {
                    System.out.print("Input: ");
                    player = scanner.nextInt();
                    computer = random.nextInt(3) + 1;
                } catch (Exception e) {
                    System.out.println("Unexpected Error!");
                    return;
                }

                if (options.containsKey(player)) {
                    i++;
                    System.out.println("Player Picks: " + options.get(player));
                    System.out.println("Computer Picks: " + options.get(computer));
                    System.out.println(decideWinner(player, computer) + "\n");
                } else {
                    System.out.println("Invalid Input\n");
                }
            }

            System.out.println("Final Score:" + " Player-" + score.get("Player") + " Computer-" + score.get("Computer") + " Ties-" + score.get("Tie"));

            switch (concludeGame()) {
                case 0:
                    System.out.println("It is a tie\n");
                    break;
                case 1:
                    System.out.println("Player Wins\n");
                    break;
                case -1:
                    System.out.println("Computer Wins\n");
                    break;
            }

            while(true) {
                System.out.print("Do you want to play again (Yes/No): ");
                userInput = scanner.next();
                if (userInput.equals("Yes") || userInput.equals("No")) break;
            }

            System.out.println();
        }

        System.out.println("Thanks for playing!");
    }
}
