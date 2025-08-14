/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author maxwe
 */
public class Grid extends JPanel {

    private int columns = 30;
    private int rows = 30;
    private int pixelSize = 14;
    private int[][] gridLayout = new int[rows][columns];
    private int startingX = 20;
    private int startingY = 20;

    public Grid() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (Math.random() <= 0.3) {
                    gridLayout[j][i] = 1; // A wall is created for 30% of the time
                } else {
                    gridLayout[j][i] = 0; // A cell without a wall is created the other 70%
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = startingX;
        int y = startingY;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (gridLayout[i][j] == 1) {
                    g.setColor(Color.BLACK); // Wall case
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                } else if (gridLayout[i][j] == 0) {
                    g.setColor(Color.WHITE); // 0 Weighted path case
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                } else if (gridLayout[i][j] == -1) {
                    g.setColor(Color.RED); // Error case
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                } else if (gridLayout[i][j] == -2) {
                    g.setColor(Color.BLUE); // Visited case
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                } else if (gridLayout[i][j] == -3) {
                    g.setColor(Color.ORANGE); // Start point
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                } else if (gridLayout[i][j] == -4) {
                    g.setColor(Color.ORANGE); // End point
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.BLACK);
                    g.drawString("🏴", x + pixelSize / 4, y + (pixelSize / 8) * 10);
                } else if (gridLayout[i][j] == -5) {
                    g.setColor(Color.GREEN); // Shortest path
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, pixelSize, pixelSize);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(gridLayout[i][j] - 1), x + pixelSize / 4, y + (pixelSize / 8) * 10);
                }
                x = x + pixelSize;
            }
            x = startingX;
            y = y + pixelSize;
        }

        /*
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        g.drawRect(0, 0, 100, 100);
         */
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 500);
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(int pixelSize) {
        this.pixelSize = pixelSize;
    }

    public int[][] getGridLayout() {
        return gridLayout;
    }

    public void setGridLayout(int[][] gridLayout) {
        this.gridLayout = gridLayout;
    }

    public int getStartingX() {
        return startingX;
    }

    public void setStartingX(int startingX) {
        this.startingX = startingX;
    }

    public int getStartingY() {
        return startingY;
    }

    public void setStartingY(int startingY) {
        this.startingY = startingY;
    }

}
