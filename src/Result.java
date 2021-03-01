public class Result {
    Check check = new Check();
    Field field = new Field();

    public void showResult() {
        check.checkRow();
        check.checkColumn();
        check.checkDiagonal();
        check.checkEmptyCells();
        check.checkDraw();

        if (check.isWinX) {
            field.printField();
            System.out.println("\nX wins");
            System.exit(0);
        } else if (check.isWinO) {
            field.printField();
            System.out.println("\nO wins");
            System.exit(0);
        } else if (check.isDraw) {
            field.printField();
            System.out.println("\nDraw");
            System.exit(0);
        }
    }
}
