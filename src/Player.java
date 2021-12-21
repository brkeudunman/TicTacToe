
import java.util.Scanner;

public class Player {

    private final String sign;

    Player(String sign_) {
        this.sign = sign_;
    }

    public String getSign() {
        return sign;
    }

    public void makeMove() {
        String input=inputMove(new Scanner(System.in));


        String[] inputArr = input.split(",");

        int row = Integer.parseInt(inputArr[0]);
        int column = Integer.parseInt(inputArr[1]);

        GameBoard.changeGameBoard(row-1,column-1,getSign());
    }

    public static String getOtherPlayersSign(Player otherPlayer) {
        if (otherPlayer.getSign().equals("O")) {
            return "X";
        }
        return "O";
    }

    private String inputMove(Scanner keyboard) throws NumberFormatException{
        String row;
        String column;
        while (true) {
            System.out.println("Please enter the location of your move: ");


            System.out.print("Row:");
            row = keyboard.next();

            while (Integer.parseInt(row) > 3 || Integer.parseInt(row) <= 0) {
                System.out.println("Please provide a valid row.");
                row = keyboard.next();
            }


            System.out.print("Column");
            column = keyboard.next();
            while (Integer.parseInt(column) > 3 || Integer.parseInt(column) <= 0) {
                System.out.println("Please provide a valid column:");
                column = keyboard.next();
            }

            if (!(GameBoard.getGameBoard()[Integer.parseInt(row) - 1][Integer.parseInt(column) - 1].equals("[]"))) {
                System.out.println("Please choose a empty bracket for fill with your sign!");
            } else {
                break;
            }

        }

        return row +","+column;
    }

}
