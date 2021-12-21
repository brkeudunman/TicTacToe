
public class GameBoard {
    private static String[][] gameBoard;

    public static void createGameBoard() {

        gameBoard = new String[][]
                {{"[]", "[]", "[]"},
                {"[]", "[]", "[]"},
                {"[]", "[]", "[]"}};
        printGameBoard();
    }

    public static String[][] getGameBoard() {
        return gameBoard;
    }

    public static void changeGameBoard(int row,int column,String sign){
        gameBoard[row][column]="["+sign+"]";
    }

    public static void printGameBoard(){
        for (String[] strings : gameBoard) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}

