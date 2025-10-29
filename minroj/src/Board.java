import java.util.Random;

public class Board {
    private int rows, cols, bombs;
    private Cell[][] grid;

    public Board(int rows, int cols, int bombs) {
        this.rows = rows;
        this.cols = cols;
        this.bombs = bombs;
        generateBoard();
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    private void generateBoard() {
        grid = new Cell[rows][cols];

        // Skapa celler
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell();
            }
        }

        // Placera bomber slumpmässigt
        int bombsPlaced = 0;
        Random rand = new Random();
        while (bombsPlaced < bombs) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!grid[r][c].isBomb()) {
                grid[r][c].setBomb(true);
                bombsPlaced++;
            }
        }

        // Räkna angränsande bomber
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c].setAdjacentBombs(countAdjacentBombs(r, c));
            }
        }
    }

    private int countAdjacentBombs(int row, int col) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = row + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc].isBomb()) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean revealCell(String move) {
        int row = move.charAt(0) - 'a';
        int col = Character.getNumericValue(move.charAt(1)) - 1;

        Cell cell = grid[row][col];
        if (cell.isRevealed()) {
            System.out.println("Denna ruta är redan undersökt.");
            return false;
        }

        cell.setRevealed(true);
        return cell.isBomb();
    }

    public boolean allSafeCellsRevealed() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid[r][c];
                if (!cell.isBomb() && !cell.isRevealed()) return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.print("   ");
        for (int c = 1; c <= cols; c++) System.out.print(c + "  ");
        System.out.println();

        for (int r = 0; r < rows; r++) {
            char rowChar = (char) ('a' + r);
            System.out.print(rowChar + " |");
            for (int c = 0; c < cols; c++) {
                Cell cell = grid[r][c];
                if (cell.isRevealed()) {
                    if (cell.isBomb()) System.out.print("O|");
                    else System.out.print(cell.getAdjacentBombs() + "|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }
}

