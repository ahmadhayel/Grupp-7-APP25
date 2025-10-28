package org.example;

public class Cell {
    private boolean bomb;
    private boolean revealed;
    private int adjacentBombs;

    public boolean isBomb() { return bomb; }
    public void setBomb(boolean bomb) { this.bomb = bomb; }

    public boolean isRevealed() { return revealed; }
    public void setRevealed(boolean revealed) { this.revealed = revealed; }

    public int getAdjacentBombs() { return adjacentBombs; }
    public void setAdjacentBombs(int adjacentBombs) { this.adjacentBombs = adjacentBombs; }
}
