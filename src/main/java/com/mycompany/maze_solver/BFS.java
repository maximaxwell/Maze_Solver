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
        parentGrid = new Coord[grid.getGridLayout().length][grid.getGridLayout()[0].length];
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Coord step() {
        if (complete || toVisitNext.isEmpty()) {
            return new Coord(-1, -1); // signal done
        }

        Coord current = toVisitNext.poll();

        if (current.equals(end)) {
            complete = true;
            return new Coord(-1, -1);
        }

        int[][] layout = this.grid.getGridLayout();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // only 4 directions

        for (int[] d : directions) {
            int newX = current.getX() + d[0];
            int newY = current.getY() + d[1];

            if (newY >= 0 && newY < layout.length
                    && newX >= 0 && newX < layout[0].length
                    && layout[newY][newX] != 1) { // not a wall
                Coord neighbor = new Coord(newX, newY);
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, "seen"); // mark visited
                    toVisitNext.add(neighbor);
                    parentGrid[newY][newX] = current;
                }
            }
        }

        return current; // return the node we just processed
    }

    public Queue<Coord> getToVisitNext() {
        return toVisitNext;
    }

    public void setToVisitNext(Queue<Coord> toVisitNext) {
        this.toVisitNext = toVisitNext;
    }

    public HashMap<Coord, String> getVisited() {
        return visited;
    }

    public void setVisited(HashMap<Coord, String> visited) {
        this.visited = visited;
    }

    public Coord[][] getParentGrid() {
        return parentGrid;
    }

    public void setParentGrid(Coord[][] parentGrid) {
        this.parentGrid = parentGrid;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Coord getStart() {
        return start;
    }

    public void setStart(Coord start) {
        this.start = start;
    }

    public Coord getEnd() {
        return end;
    }

    public void setEnd(Coord end) {
        this.end = end;
    }

}
