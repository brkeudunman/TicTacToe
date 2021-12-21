import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
    private static int counter = 0;
    private static boolean done = false;
    private Player playerOne;
    private Player playerTwo;

    public void startTheGame() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the TicTacToe!");
        GameBoard.createGameBoard();

        System.out.print("Choose First Player's sign: ");
        playerOne = new Player(takePlayerSign(keyboard));
        System.out.println();

        playerTwo = new Player(Player.getOtherPlayersSign(playerOne));
        System.out.println("Then the Second Player's sign: " + playerTwo.getSign());
        String situation;

        //Make it a method.
        while (!done) {
            if (checkEmptyBrackets()) {
                System.out.println("DRAW!");
                break;
            }

            firstPlayerMove();
            GameBoard.printGameBoard();
            //checks winner

            situation = GameReferee.checkWinner(playerOne.getSign());
            if (!(situation.equals(""))) {
                System.out.println(situation);
                break;
            }

            if (checkEmptyBrackets()) {
                System.out.println("DRAW!");
                break;
            }
            secondPlayerMove();
            GameBoard.printGameBoard();
            //checks winner

            situation = GameReferee.checkWinner(playerTwo.getSign());
            if (!(situation.equals(""))) {
                System.out.println(situation);
                break;
            }
        }

    }

    private void firstPlayerMove() {
        try {
            System.out.println();
            System.out.println("First player's move:");
            playerOne.makeMove();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " ,Please provide a number!");
            System.out.println("First player's move:");
            playerOne.makeMove();
        } finally {
            counter++;
        }
    }

    private void secondPlayerMove() {
        try {
            System.out.println();
            System.out.println("Second player's move:");
            playerTwo.makeMove();
        } catch (NumberFormatException e) {
            System.out.println("Second player's move:");
            System.out.println(e.getMessage() + " ,Please provide a number!");
            playerTwo.makeMove();
        } finally {
            counter++;
        }
    }


    private String takePlayerSign(Scanner keyboard) {
        while (true) {
            try {
                String input = keyboard.nextLine();
                if (!(input.equals("O") || input.equals("X"))) {
                    throw new InputMismatchException();
                }

                return input;

            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid sign: ");
            }
        }
    }

    private boolean checkEmptyBrackets() {
        if (counter >= 9) {
            done = true;
        }
        return done;
    }


}
