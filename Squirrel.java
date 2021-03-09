/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squirrelgame;

import java.util.Scanner;

/**
 *
 * @author tchitrakorn
 */
public class Squirrel extends Entity implements Movable {
    private int pointCollect;
    private int totalNutsEaten;
    public Squirrel(char symbol, int row, int column) {
        super(symbol, row, column);
    }
    
    @Override
    public void create() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Where would you like to start?");
            System.out.print("Row: ");
            int row = scan.nextInt();
            System.out.print("Column: ");
            int column = scan.nextInt();
            if (row >= Maze.getMaxRow() || column > Maze.getMaxColumn()) {
                System.out.println("You're outside of the maze. Try again!");
                continue;
            }
            if (Maze.getMaze()[row][column].toString().equals("*")) {
                System.out.println("You hit the wall. Try again!");
                continue;
            }
            Maze.getMaze()[row][column] = this; // if the position is valid
            break;
        }
        Maze.display();
    }
    
    @Override
    public void move(char direction) {
    }
}