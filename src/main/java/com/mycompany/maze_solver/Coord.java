/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

/**
 *
 * @author maxwe
 */
public class Coord {
    private int x = -1;
    private int y = -1;
    
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coord() {}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void reset() {
        this.x = -1;
        this.y = -1;
    }
    
    public boolean equals(Coord other) {
        if(this.x == other.getX() && this.y == other.getY()) {
            return true;
        } else {
            return false;
        }
    }

    

}
