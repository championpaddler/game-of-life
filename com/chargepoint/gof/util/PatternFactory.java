
package com.chargepoint.gof.util;

import com.chargepoint.gof.core.Universe;

public class PatternFactory {
    public static void applyGlider(Universe universe, int startRow, int startCol) {
        universe.setCellAlive(startRow, startCol + 1);
        universe.setCellAlive(startRow + 1, startCol + 2);
        universe.setCellAlive(startRow + 2, startCol);
        universe.setCellAlive(startRow + 2, startCol + 1);
        universe.setCellAlive(startRow + 2, startCol + 2);
    }
}
