import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Field field = new Field();
    User user = new User();
    AI ai = new AI();

    public void selectMenuItem() throws IOException {
        System.out.print("Input command: ");

        ai.userChoice = reader.readLine().split(" ");

        field.createField();

        try {
            while (true) {
                if (ai.userChoice[0].equals("start") && ai.userChoice[1].equals("easy") && ai.userChoice[2].equals("easy")) {
                    ai.moveEasyAI();
                } else if (ai.userChoice[0].equals("start") && ai.userChoice[1].equals("medium") && ai.userChoice[2].equals("medium")) {
                    ai.moveMediumAI();
                } else if (ai.userChoice[0].equals("start") && ai.userChoice[1].equals("easy") && ai.userChoice[2].equals("user") ||
                        ai.userChoice[0].equals("start") && ai.userChoice[1].equals("user") && ai.userChoice[2].equals("easy") ||
                        ai.userChoice[0].equals("start") && ai.userChoice[1].equals("medium") && ai.userChoice[2].equals("user") ||
                        ai.userChoice[0].equals("start") && ai.userChoice[1].equals("user") && ai.userChoice[2].equals("medium")) {
                    ai.moveAIandUser();
                } else if (ai.userChoice[0].equals("start") && ai.userChoice[1].equals("user") && ai.userChoice[2].equals("user")) {
                    user.userMove();
                } else {
                    System.out.println("\nBad parameters!\n");

                    selectMenuItem();
                }
            }
        } catch (Exception e) {
            System.out.println("\nBad parameters!\n");

            selectMenuItem();
        }
    }
}
