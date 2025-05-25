package com.chargepoint.gof;

import com.chargepoint.gof.core.GameEngine;
import com.chargepoint.gof.core.Universe;
import com.chargepoint.gof.util.PatternFactory;

public class GameOfLife {

    public static void main(String[] args) {
        int rows = 25, cols = 25;
        Universe universe = new Universe(rows, cols);
        PatternFactory.applyGlider(universe, 12, 12);

        GameEngine engine = new GameEngine();

        int generations = 10;
        for (int i = 0; i < generations; i++) {
            System.out.println("Generation: " + i);
            universe.printGrid();
            universe = engine.evolve(universe);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
