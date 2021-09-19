package com.company;

public class Board {

    private int row;
    private int col;
    private boolean[][] aliveCells;

    private final String LIFE_SYMBOL = "0";
    private final String DEAD_SYMBOL = "-";

    public Board(int row, int col) {
        this.row = row;
        this.col = col;

        this.aliveCells = new boolean[col][row];

        for (boolean[] cells : this.aliveCells) {
            for (boolean cell : cells) {
                cell = false;
            }
        }
    }

    public void print() {
        for (boolean[] cells : this.aliveCells) {
            for (boolean cell : cells) {
                if (cell) {
                    System.out.print(LIFE_SYMBOL);
                } else {
                    System.out.print(DEAD_SYMBOL);
                }
            }
            System.out.print("\n");
        }
    }
}
