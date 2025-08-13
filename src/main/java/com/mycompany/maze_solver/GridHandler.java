/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

/**
 *
 * @author maxwe
 */
public class GridHandler {

    private Grid storedGrid;

    public GridHandler() {
        this.storedGrid = null;
    }

    public GridHandler(Grid grid) {
        this.storedGrid = grid;
    }

    public Grid getGrid() {
        return this.storedGrid;
    }

    public void setGrid(Grid grid) {
        this.storedGrid = grid;
    }

    public Grid addWallFromMouseClick(Grid grid, int x, int y) { // Adds a wall from the mouse coordinates given to a given grid
        Grid newGrid = grid;
        return newGrid;
    }

    public Grid addWallFromMouseClick(int x, int y) { // Adds a wall from the mouse coordinates given to the grid stored in this class
        return storedGrid;
    }

    public Grid addCostFromMouseClick(Grid grid, int x, int y, int cost) { // Adds a costed path from the coords to a given grid
        Grid newGrid = grid;
        return newGrid;
    }

    public Grid addCostFromMouseClick(int x, int y, int cost) { // Adds a costed path from the coords to the stored grid
        return storedGrid;
    }

    public int columnFromX(Grid grid, int x) { // Gets the column position from the mouse coords from a given grid
        Grid newGrid = grid;
        return -1;
    }

    public int columnFromX(int x) { // Gets the column position from the mouse coords from the stored grid

        return -1;
    }

    public int rowFromY(Grid grid, int x) { // Gets the row position from the mouse coords from a given grid
        Grid newGrid = grid;
        return -1;
    }

    public int rowFromY(int x) { // Gets the row position from the mouse coords from the stored grid

        return -1;
    }

}
