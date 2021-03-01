import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    int column;
    int row;
    boolean isX;
    boolean isFirstTurn = true;
    String[] input;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Check check = new Check();
    Result result = new Result();
    Field field = new Field();

    public void userMove() throws IOException {
        if (isFirstTurn) {
            field.printField();
        }

        while (!check.isWin && !check.isDraw) {
            try {
                System.out.print("\nEnter the coordinates: ");

                input = reader.readLine().split(" ");
                row = Integer.parseInt(input[0]);
                column = Integer.parseInt(input[1]);

                if (!Field.playingField[row - 1][column - 1].equals("_")) {
                    System.out.println("\nThis cell is occupied! Choose another one!");
                    continue;
                } else if (!isX) {
                    Field.playingField[row - 1][column - 1] = "X";
                    isX = true;
                    isFirstTurn = false;

                    result.showResult();
                    field.printField();
                } else {
                    Field.playingField[row - 1][column - 1] = "O";
                    isX = false;
                    isFirstTurn = false;

                    result.showResult();
                    field.printField();
                }

            } catch (NumberFormatException e) {
                System.out.println("\nYou should enter numbers!");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\nCoordinates should be from 1 to 3!");
                continue;
            }
            break;
        }
    }
}
