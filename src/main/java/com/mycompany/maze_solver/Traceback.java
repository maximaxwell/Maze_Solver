/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.Stack;
import java.util.LinkedList;

/**
 *
 * @author maxwe
 */
public class Traceback {

    private Coord[][] parents;
    private Stack<Coord> flip;

    public Traceback(Coord[][] parents) {
        this.parents = parents;
    }

    public LinkedList<Coord> trace(Coord start, Coord end) {
        flip = new Stack<>();
        LinkedList<Coord> traceList = new LinkedList<>();
        Coord current;
        int x = end.getX();
        int y = end.getY();
        while (x != start.getX() || y != start.getY()) {
            flip.push(new Coord(x, y));
            current = parents[y][x];
            if(current == null) {
                return null;
            }
            x = current.getX();
            y = current.getY();
        }
        flip.push(start);
        while(!flip.isEmpty()) {
            traceList.add(flip.pop()); // Flips the coords around so it goes in order
        }
        return traceList;
    }

}
