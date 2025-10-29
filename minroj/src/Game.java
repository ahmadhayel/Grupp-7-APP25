public class Game {
    private Board board;
    private boolean isRunning = true;

    public void startGame() {
        board = new Board(6, 6, 5); // 6x6 med 5 bomber
        board.printBoard();

        while (isRunning) {
            playTurn();
        }
    }

    private void playTurn() {
        String move = InputHandler.askForMove();
        boolean hitBomb = board.revealCell(move);

        board.printBoard();

        if (hitBomb) {
            System.out.println("Pang!! Game Over.");
            isRunning = false;
        } else if (board.allSafeCellsRevealed()) {
            System.out.println("Grattis! Du har vunnit!");
            isRunning = false;
        }
    }
}