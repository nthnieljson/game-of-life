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

        this.aliveCells = new boolean[row][col];

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

    public int getRow() {
        return this.col;
    }

    public int getCol() {
        return this.col;
    }

    public boolean getCell(int x, int y) {
        return this.aliveCells[y][x];
    }

    public void setCell(int x, int y, boolean status) {
        this.aliveCells[y][x] = status;
    }

    public void setAliveCells(boolean[][] newAliveCells) {
        this.aliveCells = newAliveCells;
    }

    public void toggleCell(int x, int y) {
        this.setCell(x, y, !this.getCell(x, y));
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < this.col && y >= 0 && y < this.row;
    }

    public int getLifeNeighborCount(int x, int y) {
        int count = 0;
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            int neighborX = x + dx[i];
            int neighborY = y + dy[i];

            if (isValidCoordinate(neighborX, neighborY)) {
                count += this.getCell(neighborX, neighborY) ? 1 : 0;
            }
        }

        return count;
    }

    public void nextGeneration() {
        boolean[][] nextAliveCells = new boolean[this.col][this.row];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                int lifeNeighborCount = this.getLifeNeighborCount(j, i);

                if (this.getCell(j, i)) {
                    if (lifeNeighborCount < 2) {
                        nextAliveCells[i][j] = false;
                    } else if (lifeNeighborCount <= 3) {
                        nextAliveCells[i][j] = true;
                    } else {
                        nextAliveCells[i][j] = false;
                    }
                } else {
                    if (lifeNeighborCount == 3) {
                        nextAliveCells[i][j] = true;
                    } else {
                        nextAliveCells[i][j] = false;
                    }
                }
            }
        }

        this.setAliveCells(nextAliveCells);
    }

}
