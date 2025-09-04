/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author maxwe
 */
public class AStar {

    Grid grid = new Grid();
    // Tracking structures
    Queue<Coord> toVisitNext = new LinkedList<>(); // Frontier
    HashMap<Coord, String> visited = new HashMap<>(); // Stops values from being added twice
    Coord[][] parentGrid; // A 2D array of "parent" coords used to traceback at the end
    // End
    boolean complete = false;
    Coord start;
    Coord end;
    int[][] startingLayout;

    public AStar(Grid grid) {
        this.grid = grid;
        start = grid.getStartPoint();
        end = grid.getEndPoint();
        toVisitNext.add(start);
        parentGrid = new Coord[grid.getGridLayout().length][grid.getGridLayout()[0].length];
        startingLayout = grid.getGridLayout();
    }
    
    public Coord step() { // Moves the A* algorithm along 1
        if (complete || toVisitNext.isEmpty()) {
            return new Coord(-1, -1); // signal done
        }
        
        
        
        
        
        
        
        return new Coord(-1, -1);
    }

    public double distance(Coord a, Coord b) { // Finds the euclidean distance between 2 coordinate objects
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public double distance(int x1, int y1, int x2, int y2) { // Finds the euclidean distance between 2 coordinates but using x and y
        return Math.hypot(x1 - x2, y1 - y2);
    }

}
