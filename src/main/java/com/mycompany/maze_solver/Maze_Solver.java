/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.maze_solver;

/**
 *
 * @author maxwe
 */
public class Maze_Solver {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.getMainPanel().setLayout(new java.awt.BorderLayout()); // so Grid fills space
        maze.getMainPanel().add(new Grid(), java.awt.BorderLayout.CENTER);
        maze.pack();
        maze.setVisible(true);

    }
}
