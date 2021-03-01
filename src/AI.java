import java.io.IOException;
import java.util.Random;

public class AI {
    int randomNumberRow;
    int randomNumberColumn;
    boolean isWinInOneMove;
    String[] userChoice;

    Check check = new Check();
    Result result = new Result();
    User user = new User();
    Field field = new Field();

    public void moveAIandUser() throws IOException {
        while (!check.isWin && !check.isDraw) {
            if (userChoice[0].equals("start") && userChoice[1].equals("easy") && userChoice[2].equals("user")) {
                moveEasyAI();
                user.userMove();
            } else if (userChoice[0].equals("start") && userChoice[1].equals("user") && userChoice[2].equals("easy")) {
                user.userMove();
                moveEasyAI();
            } else if (userChoice[0].equals("start") && userChoice[1].equals("medium") && userChoice[2].equals("user")) {
                moveMediumAI();
                user.userMove();
            } else if (userChoice[0].equals("start") && userChoice[1].equals("user") && userChoice[2].equals("medium")) {
                user.userMove();
                moveMediumAI();
            }
        }
    }

    public void moveEasyAI() {
        System.out.println("\nMaking move level \"easy\"");

        Random random = new Random();
        randomNumberRow = random.nextInt(3 - 1 + 1) + 1;
        randomNumberColumn = random.nextInt(3 - 1 + 1) + 1;

        while (!Field.playingField[randomNumberRow - 1][randomNumberColumn - 1].equals("_")) {
            randomNumberRow = random.nextInt(3 - 1 + 1) + 1;
            randomNumberColumn = random.nextInt(3 - 1 + 1) + 1;
        }

        if (!user.isX) {
            Field.playingField[randomNumberRow - 1][randomNumberColumn - 1] = "X";
            user.isX = true;
        } else {
            Field.playingField[randomNumberRow - 1][randomNumberColumn - 1] = "O";
            user.isX = false;
        }

        user.isFirstTurn = false;

        result.showResult();
        field.printField();
    }

    public void moveMediumAI() {
        System.out.println("\nMaking move level \"medium\"");

        checkRowAIWinInOneMove();
        checkColumnAIWinInOneMove();
        checkDiagonalAIWinInOneMove();
        checkRowUserWinInOneMove();
        checkColumnUserWinInOneMove();
        checkDiagonalUserWinInOneMove();

        if (!isWinInOneMove) {
            Random random = new Random();
            randomNumberRow = random.nextInt(3 - 1 + 1) + 1;
            randomNumberColumn = random.nextInt(3 - 1 + 1) + 1;

            while (!Field.playingField[randomNumberRow - 1][randomNumberColumn - 1].equals("_")) {
                randomNumberRow = random.nextInt(3 - 1 + 1) + 1;
                randomNumberColumn = random.nextInt(3 - 1 + 1) + 1;
            }

            if (!user.isX) {
                Field.playingField[randomNumberRow - 1][randomNumberColumn - 1] = "X";
                user.isX = true;
            } else {
                Field.playingField[randomNumberRow - 1][randomNumberColumn - 1] = "O";
                user.isX = false;
            }
        }

        user.isFirstTurn = false;
        isWinInOneMove = false;

        result.showResult();
        field.printField();
    }

    public void checkRowAIWinInOneMove() {
        if (!user.isX && !isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[i][0].equals("X") && Field.playingField[i][1].equals("X") && Field.playingField[i][2].equals("_")) {
                    Field.playingField[i][2] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][0].equals("X") && Field.playingField[i][2].equals("X") && Field.playingField[i][1].equals("_")) {
                    Field.playingField[i][1] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][1].equals("X") && Field.playingField[i][2].equals("X") && Field.playingField[i][0].equals("_")) {
                    Field.playingField[i][0] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                }
            }
        } else if (!isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[i][0].equals("O") && Field.playingField[i][1].equals("O") && Field.playingField[i][2].equals("_")) {
                    Field.playingField[i][2] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][0].equals("O") && Field.playingField[i][2].equals("O") && Field.playingField[i][1].equals("_")) {
                    Field.playingField[i][1] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][1].equals("O") && Field.playingField[i][2].equals("O") && Field.playingField[i][0].equals("_")) {
                    Field.playingField[i][0] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                }
            }
        }
    }

    public void checkColumnAIWinInOneMove() {
        if (!user.isX && !isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[0][i].equals("X") && Field.playingField[1][i].equals("X") && Field.playingField[2][i].equals("_")) {
                    Field.playingField[2][i] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[0][i].equals("X") && Field.playingField[2][i].equals("X") && Field.playingField[1][i].equals("_")) {
                    Field.playingField[1][i] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[1][i].equals("X") && Field.playingField[2][i].equals("X") && Field.playingField[0][i].equals("_")) {
                    Field.playingField[0][i] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                }
            }
        } else if (!isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[0][i].equals("O") && Field.playingField[1][i].equals("O") && Field.playingField[2][i].equals("_")) {
                    Field.playingField[2][i] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[0][i].equals("O") && Field.playingField[2][i].equals("O") && Field.playingField[1][i].equals("_")) {
                    Field.playingField[1][i] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[1][i].equals("O") && Field.playingField[2][i].equals("O") && Field.playingField[0][i].equals("_")) {
                    Field.playingField[0][i] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                }
            }
        }
    }

    public void checkDiagonalAIWinInOneMove() {
        if (!user.isX && !isWinInOneMove) {
            if (Field.playingField[0][0].equals(("X")) && Field.playingField[1][1].equals("X") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][2] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[0][0].equals(("X")) && Field.playingField[2][2].equals("X") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("X")) && Field.playingField[2][2].equals("X") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][0] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("X")) && Field.playingField[1][1].equals("X") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][0] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("X")) && Field.playingField[2][0].equals("X") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("X")) && Field.playingField[2][0].equals("X") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][2] = "X";
                user.isX = true;
                isWinInOneMove = true;
            }
        } else if (!isWinInOneMove) {
            if (Field.playingField[0][0].equals(("O")) && Field.playingField[1][1].equals("O") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][2] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[0][0].equals(("O")) && Field.playingField[2][2].equals("O") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("O")) && Field.playingField[2][2].equals("O") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][0] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("O")) && Field.playingField[1][1].equals("O") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][0] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("O")) && Field.playingField[2][0].equals("O") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("O")) && Field.playingField[2][0].equals("O") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][2] = "O";
                user.isX = false;
                isWinInOneMove = true;
            }
        }
    }

    public void checkRowUserWinInOneMove() {
        if (user.isX && !isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[i][0].equals("X") && Field.playingField[i][1].equals("X") && Field.playingField[i][2].equals("_")) {
                    Field.playingField[i][2] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][0].equals("X") && Field.playingField[i][2].equals("X") && Field.playingField[i][1].equals("_")) {
                    Field.playingField[i][1] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][1].equals("X") && Field.playingField[i][2].equals("X") && Field.playingField[i][0].equals("_")) {
                    Field.playingField[i][0] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                }
            }
        } else if (!isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[i][0].equals("O") && Field.playingField[i][1].equals("O") && Field.playingField[i][2].equals("_")) {
                    Field.playingField[i][2] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][0].equals("O") && Field.playingField[i][2].equals("O") && Field.playingField[i][1].equals("_")) {
                    Field.playingField[i][1] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[i][1].equals("O") && Field.playingField[i][2].equals("O") && Field.playingField[i][0].equals("_")) {
                    Field.playingField[i][0] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                }
            }
        }
    }

    public void checkColumnUserWinInOneMove() {
        if (user.isX && !isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[0][i].equals("X") && Field.playingField[1][i].equals("X") && Field.playingField[2][i].equals("_")) {
                    Field.playingField[2][i] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[0][i].equals("X") && Field.playingField[2][i].equals("X") && Field.playingField[1][i].equals("_")) {
                    Field.playingField[1][i] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                } else if (Field.playingField[1][i].equals("X") && Field.playingField[2][i].equals("X") && Field.playingField[0][i].equals("_")) {
                    Field.playingField[0][i] = "O";
                    user.isX = false;
                    isWinInOneMove = true;
                }
            }
        } else if (!isWinInOneMove) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[0][i].equals("O") && Field.playingField[1][i].equals("O") && Field.playingField[2][i].equals("_")) {
                    Field.playingField[2][i] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[0][i].equals("O") && Field.playingField[2][i].equals("O") && Field.playingField[1][i].equals("_")) {
                    Field.playingField[1][i] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                } else if (Field.playingField[1][i].equals("O") && Field.playingField[2][i].equals("O") && Field.playingField[0][i].equals("_")) {
                    Field.playingField[0][i] = "X";
                    user.isX = true;
                    isWinInOneMove = true;
                }
            }
        }
    }

    public void checkDiagonalUserWinInOneMove() {
        if (user.isX && !isWinInOneMove) {
            if (Field.playingField[0][0].equals(("X")) && Field.playingField[1][1].equals("X") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][2] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[0][0].equals(("X")) && Field.playingField[2][2].equals("X") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("X")) && Field.playingField[2][2].equals("X") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][0] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("X")) && Field.playingField[1][1].equals("X") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][0] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("X")) && Field.playingField[2][0].equals("X") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "O";
                user.isX = false;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("X")) && Field.playingField[2][0].equals("X") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][2] = "O";
                user.isX = false;
                isWinInOneMove = true;
            }
        } else if (!isWinInOneMove) {
            if (Field.playingField[0][0].equals(("O")) && Field.playingField[1][1].equals("O") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][2] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[0][0].equals(("O")) && Field.playingField[2][2].equals("O") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("O")) && Field.playingField[2][2].equals("O") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][0] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("O")) && Field.playingField[1][1].equals("O") && Field.playingField[2][2].equals("_")) {
                Field.playingField[2][0] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[0][2].equals(("O")) && Field.playingField[2][0].equals("O") && Field.playingField[1][1].equals("_")) {
                Field.playingField[1][1] = "X";
                user.isX = true;
                isWinInOneMove = true;
            } else if (Field.playingField[1][1].equals(("O")) && Field.playingField[2][0].equals("O") && Field.playingField[0][0].equals("_")) {
                Field.playingField[0][2] = "X";
                user.isX = true;
                isWinInOneMove = true;
            }
        }
    }
}
