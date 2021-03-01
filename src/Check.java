public class Check {
    boolean isWin;
    boolean isWinX;
    boolean isWinO;
    boolean isDraw;
    boolean isEmpty;

    public void checkRow() {
        while (!isWin) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[i][0].equals("X") && Field.playingField[i][1].equals("X") && Field.playingField[i][2].equals("X")) {
                    isWin = true;
                    isWinX = true;
                } else if (Field.playingField[i][0].equals("O") && Field.playingField[i][1].equals("O") && Field.playingField[i][2].equals("O")) {
                    isWin = true;
                    isWinO = true;
                }
            }
            break;
        }
    }

    public void checkColumn() {
        while (!isWin) {
            for (int i = 0; i < Field.playingField.length; i++) {
                if (Field.playingField[0][i].equals("X") && Field.playingField[1][i].equals("X") && Field.playingField[2][i].equals("X")) {
                    isWin = true;
                    isWinX = true;
                } else if (Field.playingField[0][i].equals("O") && Field.playingField[1][i].equals("O") && Field.playingField[2][i].equals("O")) {
                    isWin = true;
                    isWinO = true;
                }
            }
            break;
        }
    }

    public void checkDiagonal() {
        while (!isWin) {
            if (Field.playingField[0][0].equals(("X")) && Field.playingField[1][1].equals("X") && Field.playingField[2][2].equals("X") ||
                    Field.playingField[0][2].equals(("X")) && Field.playingField[1][1].equals("X") && Field.playingField[2][0].equals("X")) {
                isWin = true;
                isWinX = true;
            } else if (Field.playingField[0][0].equals(("O")) && Field.playingField[1][1].equals("O") && Field.playingField[2][2].equals("O") ||
                    Field.playingField[0][2].equals(("O")) && Field.playingField[1][1].equals("O") && Field.playingField[2][0].equals("O")) {
                isWin = true;
                isWinO = true;
            }
            break;
        }
    }

    public void checkEmptyCells() {
        isEmpty = false;

        for (int i = 0; i < Field.playingField.length; i++) {
            for (int j = 0; j < Field.playingField[i].length; j++) {
                if (Field.playingField[i][j].equals("_")) {
                    isEmpty = true;
                }
            }
        }
    }

    public void checkDraw() {
        if (!isWin && !isEmpty) {
            isDraw = true;
        }
    }
}
