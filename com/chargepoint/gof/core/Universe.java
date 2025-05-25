
package com.chargepoint.gof.core;

import com.chargepoint.gof.model.Cell;

public class Universe {
    private final int rows;
    private final int cols;
    private Cell[][] grid;

    public Universe(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Cell[rows][cols];
        initGrid();
    }

    private void initGrid() {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = new Cell(false);
    }

    public void setCellAlive(int row, int col) {
        grid[row][col].setAlive(true);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void printGrid() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
