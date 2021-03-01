import java.util.Arrays;

public class Field {
    static String[][] playingField;

    public void createField() {
        playingField = new String[3][3];

        for (String[] strings : playingField) {
            Arrays.fill(strings, "_");
        }
    }

    public void printField() {
        System.out.println("---------");

        for (int i = 0; i < playingField.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < playingField[i].length; j++) {
                System.out.print(playingField[i][j] + " ");
            }
            System.out.print("|\n");
        }

        System.out.println("---------");
    }
}
