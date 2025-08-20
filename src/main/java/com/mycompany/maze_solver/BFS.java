/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author maxwe
 */
public class BFS {
    Grid grid = new Grid();
    Queue<Coord> toVisit = new LinkedList<>();
    
    
    public BFS (Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
    public Grid run() {
        
        return this.grid;
    }
    
    
}
