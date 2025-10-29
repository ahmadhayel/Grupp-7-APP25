public class Bord {

    private int rows, cols, bombs;
    private Cell[][] grid;

    public Board(int rows, int cols, int bombs) {
        this.rows = rows;
        this.cols = cols;
        this.bombs = bombs;
        generateBoard();
    }

    private void generateBoard() {
        grid = new Cell[rows][cols];
        // Initiera celler + placera bomber slumpmässigt
    }

    public boolean revealCell(String move) {
        int row = move.charAt(0) - 'a';
        int col = Character.getNumericValue(move.charAt(1)) - 1;

        Cell cell = grid[row][col];
        cell.setRevealed(true);
        return cell.isBomb();
    }

    public void printBoard() {
        // Visa rader och kolumner som i exemplet du fick
    }

    public boolean allSafeCellsRevealed() {
        // Returnera true om alla celler utan bomb är öppnade
        return false;
    }

}

