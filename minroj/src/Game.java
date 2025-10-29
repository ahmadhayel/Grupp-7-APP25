public class Game {
    private Board board;
    private boolean isRunning;

    public void startGame() {
        board = new Board(6, 6, 5); // 6x6 bräde med 5 bomber
        isRunning = true;

        System.out.println("Hej och välkommen till Minröj!");
        board.printBoard();

        while (isRunning) playTurn();
    }

    private void playTurn() {
        String move = InputHandler.askForMove(board.getRows(), board.getCols());
        boolean hitBomb = board.revealCell(move);

        board.printBoard();

        if (hitBomb) {
            System.out.println("💣 Pang!! Game Over. Ruta " + move + " innehöll en bomb.");
            isRunning = false;
        } else if (board.allSafeCellsRevealed()) {
            System.out.println("🎉 Grattis! Du har vunnit!");
            isRunning = false;
        }
    }
}
