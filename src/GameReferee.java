
import java.util.Arrays;

public class GameReferee {



    public static String checkWinner(String playerSign) {
        String[][] gameBoard = GameBoard.getGameBoard();
        String[] winningSituation_1 = {"["+playerSign+"]", "["+playerSign+"]", "["+playerSign+"]"};

        //for winning situation_1
        for (String[] strings : gameBoard) {
            if (Arrays.equals(winningSituation_1, strings)) {
                return "Winner is = " + playerSign + " !!";
            }

        }

        if(gameBoard[0][0].equals("["+playerSign+"]") && gameBoard[1][1].equals("["+playerSign+"]") && gameBoard[2][2].equals("["+playerSign+"]")){
            return "Winner is =" + playerSign + " !!";
        }

        else if(gameBoard[0][2].equals("["+playerSign+"]")&&gameBoard[1][1].equals("["+playerSign+"]")&&gameBoard[2][0].equals("["+playerSign+"]")){
            return "Winner is =" + playerSign + " !!";
        }


        for(int j = 0;j<3;j++){
            if(gameBoard[0][j].equals("["+playerSign+"]")  && gameBoard[1][j].equals("["+playerSign+"]")&& gameBoard[2][j].equals("["+playerSign+"]")){
                return "Winner is = "+ playerSign + " !!";
            }
        }

       return"";
    }
}
