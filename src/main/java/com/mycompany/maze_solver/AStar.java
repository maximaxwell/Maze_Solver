/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author maxwe
 */
public class AStar {

    Grid grid = new Grid();
    // Tracking structures
    PriorityQueue<PriorityQueueNode> toVisitNext = new PriorityQueue<>(Comparator.comparingDouble(PriorityQueueNode::getF)); // Frontier
    HashMap<Coord, String> visited = new HashMap<>(); // Stops values from being added twice
    Coord[][] parentGrid; // A 2D array of "parent" coords used to traceback at the end
    // End
    boolean complete = false;
    Coord start;
    Coord end;
    int[][] startingLayout;
    Traceback trace;

    public AStar(Grid grid) {
        this.grid = grid;
        start = grid.getStartPoint();
        end = grid.getEndPoint();
        toVisitNext.add(new PriorityQueueNode(start, 0, distance(start, end)));
        parentGrid = new Coord[grid.getGridLayout().length][grid.getGridLayout()[0].length];
        startingLayout = grid.getGridLayout();
    }

    public Coord step() { // Moves the A* algorithm along 1
        if (complete || toVisitNext.isEmpty()) {
            return new Coord(-1, -1); // signal done
        }

        Coord current = toVisitNext.poll().getCoord();

        if (current.equals(end)) {
            complete = true;
            return new Coord(-1, -1);
        }

        int[][] layout = this.grid.getGridLayout();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // only 4 directions
        trace = new Traceback(parentGrid);
        int currentPathCost;
        double heuristicCost;
        PriorityQueueNode neighbourToAdd;

        for (int[] d : directions) {
            int newX = current.getX() + d[0];
            int newY = current.getY() + d[1];

            if (newY >= 0 && newY < layout.length
                    && newX >= 0 && newX < layout[0].length
                    && layout[newY][newX] != 1) {

                Coord neighbour = new Coord(newX, newY);
                if (!visited.containsKey(neighbour)) {
                    visited.put(neighbour, "seen");
                    // Pushing to the priority queue (The heart of the A* algorithm)
                    currentPathCost = trace.traceCost(startingLayout, start, neighbour);
                    heuristicCost = distance(neighbour, end);
                    neighbourToAdd = new PriorityQueueNode(neighbour, currentPathCost, heuristicCost);
                    toVisitNext.add(neighbourToAdd);
                    // End
                    parentGrid[newY][newX] = current;
                }

            }

        }

        return current;
    }

    public double distance(Coord a, Coord b) { // Finds the euclidean distance between 2 coordinate objects
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public double distance(int x1, int y1, int x2, int y2) { // Finds the euclidean distance between 2 coordinates but using x and y
        return Math.hypot(x1 - x2, y1 - y2);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public PriorityQueue<PriorityQueueNode> getToVisitNext() {
        return toVisitNext;
    }

    public void setToVisitNext(PriorityQueue<PriorityQueueNode> toVisitNext) {
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

    public int[][] getStartingLayout() {
        return startingLayout;
    }

    public void setStartingLayout(int[][] startingLayout) {
        this.startingLayout = startingLayout;
    }

    public Traceback getTrace() {
        return trace;
    }

    public void setTrace(Traceback trace) {
        this.trace = trace;
    }
    
    

}
