/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

/**
 *
 * @author maxwe
 */
public class BFS {

    Grid grid = new Grid();
    // Tracking structures
    Queue<Coord> toVisitNext = new LinkedList<>(); // Frontier
    HashMap<Coord, String> visited = new HashMap<>(); // Stops values from being added twice
    Coord[][] parentGrid; // A 2D array of "parent" coords used to traceback at the end
    // End
    boolean complete = false;
    Coord start;
    Coord end;

    public BFS(Grid grid) {
        this.grid = grid;
        start = grid.getStartPoint();
        end = grid.getEndPoint();
        toVisitNext.add(start);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Coord step() {
        // This is the core of the BFS class
        // Moves the BFS algorithm along 1
        // Will return a "success" object when the goal node is reached
        // Checks whether the last step found the goal node
        if (complete) {
            return new Coord(-1, -1);
        }
        Coord output = null;
        int[][] layout = this.grid.getGridLayout();
        Coord current;
        int column;
        int row;
        if (!(toVisitNext.isEmpty())) {

            current = toVisitNext.poll();
            

            if(current.equals(end)) { // If the node to visit next is the goal node
                complete = true;
            } else {
                column = current.getX();
                row = current.getY();
                // Frontier expansion
                
                
                
                // End
                
                
            }
            
        }

        return output;
    }

}
