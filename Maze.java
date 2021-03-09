/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squirrelgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tchitrakorn
 */
public class Maze {
    private static final int MAX_MAZE_ROW = 20;
    private static final int MAX_MAZE_COLUMN = 50;
    private static Entity[][] maze = new Entity[MAX_MAZE_ROW][MAX_MAZE_COLUMN];
    
    // create a maze based on the provided file
    public static void create(String filename) {
        File mazeFile = new File(filename);
        try {
            Scanner in = new Scanner(mazeFile);
            int row = 0;
            while (in.hasNextLine()) {
                String wallLine = in.nextLine();
                for (int col = 0; col < MAX_MAZE_COLUMN; col++) {
                    char symbol = wallLine.charAt(col);
                    maze[row][col] = new Wall(symbol, row, col);
                }
                row++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(filename + " does not exist!");
        }
    }
    
    // display maze structure and the containing entities
    public static void display() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println("");
        }
    }
    
    // determines if the location is a blank space based on provided row and col
    public static boolean available(int row, int col) {
        return maze[row][col].toString().equals("*") ? false : true;
    }
    
    // get maze
    public static Entity[][] getMaze() {
        return maze;
    }
    
    // get MAX_MAZE_ROW
    public static int getMaxRow() {
        return MAX_MAZE_ROW;
    }
    
    // get MAX_MAZE_COLUMN
    public static int getMaxColumn() {
        return MAX_MAZE_COLUMN;
    }
}
