
package com.chargepoint.gof.core;

import com.chargepoint.gof.model.Cell;

public class GameEngine {
    public Universe evolve(Universe universe) {
        int rows = universe.getGrid().length;
        int cols = universe.getGrid()[0].length;
        Universe nextGen = new Universe(rows, cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbors = countLiveNeighbors(universe.getGrid(), r, c);
                boolean isAlive = universe.getGrid()[r][c].isAlive();

                if (isAlive && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    nextGen.setCellAlive(r, c);
                } else if (!isAlive && liveNeighbors == 3) {
                    nextGen.setCellAlive(r, c);
                }
            }
        }

        return nextGen;
    }

    private int countLiveNeighbors(Cell[][] grid, int row, int col) {
        int count = 0;
        int[] dir = {-1, 0, 1};
        for (int dr : dir) {
            for (int dc : dir) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}
