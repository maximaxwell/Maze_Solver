/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

/**
 *
 * @author maxwe
 */
public class PriorityQueueNode { // Used in the A star algorithm for converting a coordinate into a cost which can be evaluated by a priority queue

    private Coord coord;
    private double g;
    private double h;

    public PriorityQueueNode(Coord coord, double g, double h) {
        this.coord = coord;
        this.g = g;
        this.h = h;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public double getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public double getF() {
        return g + h; // The total cost of the node which includes the heuristic and actual path cost
    }

}
