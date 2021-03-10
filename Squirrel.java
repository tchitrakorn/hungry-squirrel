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
        Maze.getMaze()[this.getRow()][this.getColumn()] = this;
    }
    
    @Override
    public void move(char direction) {
        int currentRow = this.getRow();
        int currentColumn = this.getColumn();
        boolean foundNut = false;
        
        if (direction == 'u' && Maze.available(currentRow - 1, currentColumn)) {
            Entity replacedEntity = this.put(currentRow - 1, currentColumn);
            if (replacedEntity.getSymbol() == 'P') {
                this.pointCollect += 10;
                foundNut = true;
            } else if (replacedEntity.getSymbol() == 'A') {
                this.pointCollect += 5;
                foundNut = true;
            }
            Maze.setBlank(this.getRow(), this.getColumn()); // set the original position to be blank
            this.setRow(currentRow - 1); // set the new row position
            Maze.getMaze()[this.getRow()][this.getColumn()] = this; // move the squirrel to the new position
            Maze.display(); // rerender the maze
            System.out.println("Moved up!");
        } else if (direction == 'd' && Maze.available(currentRow + 1, currentColumn)) {
            Entity replacedEntity = this.put(currentRow + 1, currentColumn);
            if (replacedEntity.getSymbol() == 'P') {
                this.pointCollect += 10;
                foundNut = true;
            } else if (replacedEntity.getSymbol() == 'A') {
                this.pointCollect += 5;
                foundNut = true;
            }
            Maze.setBlank(this.getRow(), this.getColumn());
            this.setRow(currentRow + 1);
            Maze.getMaze()[this.getRow()][this.getColumn()] = this;
            Maze.display();
            System.out.println("Moved down!");
        } else if (direction == 'l' && Maze.available(currentRow, currentColumn - 1)) {
            Entity replacedEntity = this.put(currentRow, currentColumn - 1);
            if (replacedEntity.getSymbol() == 'P') {
                this.pointCollect += 10;
                foundNut = true;
            } else if (replacedEntity.getSymbol() == 'A') {
                this.pointCollect += 5;
                foundNut = true;
            }
            Maze.setBlank(this.getRow(), this.getColumn());
            this.setColumn(currentColumn - 1);
            Maze.getMaze()[this.getRow()][this.getColumn()] = this;
            Maze.display();
            System.out.println("Moved left!");
        } else if (direction == 'r' && Maze.available(currentRow, currentColumn + 1)) {
            Entity replacedEntity = this.put(currentRow, currentColumn + 1);
            if (replacedEntity.getSymbol() == 'P') {
                this.pointCollect += 10;
                foundNut = true;
            } else if (replacedEntity.getSymbol() == 'A') {
                this.pointCollect += 5;
                foundNut = true;
            }
            Maze.setBlank(this.getRow(), this.getColumn());
            this.setColumn(currentColumn + 1);
            Maze.getMaze()[this.getRow()][this.getColumn()] = this;
            Maze.display();
            System.out.println("Moved right!");
        } else {
            System.out.println("Invalid position or command!");
        }
        
        if (foundNut) {
            this.totalNutsEaten++;
            System.out.println("You found a nut!");
            System.out.println("Your current point is: " + this.pointCollect);
            System.out.println("You have found " + this.totalNutsEaten + " nut(s) out of 5 nuts!");
        }
    }
}