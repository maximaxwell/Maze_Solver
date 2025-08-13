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

    public Grid toggleWallFromMouseClick(Grid grid, int x, int y) { // Toggles a wall from the mouse coordinates given to a given grid
        Grid newGrid = grid;
        int[][] layout = newGrid.getGridLayout();
        int column = columnFromX(newGrid, x);
        int row = rowFromY(newGrid, y);
        if (column < 0 | row < 0) {
            return newGrid;
        }
        if (layout[row][column] == 1) {
            layout[row][column] = 0;
        } else {
            layout[row][column] = 1;
        }
        newGrid.setGridLayout(layout);
        return newGrid;
    }

    public Grid toggleWallFromMouseClick(int x, int y) { // Toggles a wall from the mouse coordinates given to the grid stored in this class
        Grid newGrid = storedGrid;
        int[][] layout = newGrid.getGridLayout();
        int column = columnFromX(newGrid, x);
        int row = rowFromY(newGrid, y);
        if (column < 0 | row < 0) {
            return newGrid;
        }
        if (layout[row][column] == 1) {
            layout[row][column] = 0;
        } else {
            layout[row][column] = 1;
        }
        newGrid.setGridLayout(layout);
        storedGrid = newGrid;
        return storedGrid;
    }

    public Grid setCostFromMouseClick(Grid grid, int x, int y, int cost) { // Adds a costed path from the coords to a given grid
        Grid newGrid = grid;
        int[][] layout = newGrid.getGridLayout();
        int column = columnFromX(newGrid, x);
        int row = rowFromY(newGrid, y);
        if (column < 0 | row < 0) {
            return newGrid;
        }
        if (cost == 0) {
            layout[row][column] = 0;
        } else {
            layout[row][column] = cost + 1;
        }
        newGrid.setGridLayout(layout);
        return newGrid;
    }

    public Grid setCostFromMouseClick(int x, int y, int cost) { // Adds a costed path from the coords to the stored grid
        Grid newGrid = storedGrid;
        int[][] layout = newGrid.getGridLayout();
        int column = columnFromX(newGrid, x);
        int row = rowFromY(newGrid, y);
        if (column < 0 | row < 0) {
            return newGrid;
        }
        if (cost == 0) {
            layout[row][column] = 0;
        } else {
            layout[row][column] = cost + 1;
        }
        newGrid.setGridLayout(layout);
        storedGrid = newGrid;
        return storedGrid;
    }

    public Grid setValueFromMouseClick(Grid grid, int x, int y, int cost) {
        Grid newGrid = grid;
        int[][] layout = newGrid.getGridLayout();
        int column = columnFromX(newGrid, x);
        int row = rowFromY(newGrid, y);
        if (column < 0 | row < 0) {
            return newGrid;
        }
        layout[row][column] = cost;
        newGrid.setGridLayout(layout);
        return newGrid;
    }

    public Grid setValueFromMouseClick(int x, int y, int cost) {
        Grid newGrid = storedGrid;
        int[][] layout = newGrid.getGridLayout();
        int column = columnFromX(newGrid, x);
        int row = rowFromY(newGrid, y);
        if (column < 0 | row < 0) {
            return newGrid;
        }
        layout[row][column] = cost;
        newGrid.setGridLayout(layout);
        storedGrid = newGrid;
        return storedGrid;
    }

    public int columnFromX(Grid grid, int x) { // Gets the column position from the mouse coords from a given grid
        Grid newGrid = grid;
        float output = Math.round(((x - newGrid.getStartingX()) - 0.5) / newGrid.getPixelSize()) - 1;
        return (int) output;
    }

    public int columnFromX(int x) { // Gets the column position from the mouse coords from the stored grid
        float output = Math.round(((x - storedGrid.getStartingX()) - 0.5) / storedGrid.getPixelSize()) - 1;
        return (int) output;
    }

    public int rowFromY(Grid grid, int y) { // Gets the row position from the mouse coords from a given grid
        Grid newGrid = grid;
        float output = Math.round(((y - newGrid.getStartingY())) / newGrid.getPixelSize()) - 2;
        return (int) output;
    }

    public int rowFromY(int y) { // Gets the row position from the mouse coords from the stored grid
        float output = Math.round(((y - storedGrid.getStartingY())) / storedGrid.getPixelSize()) - 2;
        return (int) output;
    }

}
