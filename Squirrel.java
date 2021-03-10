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
    
    public String updatePoints(Entity replacedEntity) {
        String updates = "";
        if (replacedEntity.getSymbol() == 'P') {
            this.pointCollect += 10;
            this.totalNutsEaten++;
            updates += "You found a peanut and earned 10 points!\n";
            updates += "Your current point is: " + this.pointCollect + "\n";
            updates += "You have found " + this.totalNutsEaten + " nut(s) out of 5 nuts!\n";
        } else if (replacedEntity.getSymbol() == 'A') {
            this.pointCollect += 5;
            this.totalNutsEaten++;
            updates += "You found an almond and earned 5 points!\n";
            updates += "Your current point is: " + this.pointCollect + "\n";
            updates += "You have found " + this.totalNutsEaten + " nut(s) out of 5 nuts!\n";
        }
        return updates;
    }
    
    @Override
    public void create() {
        Maze.getMaze()[this.getRow()][this.getColumn()] = this;
    }
    
    @Override
    public void move(char direction) {
        int currentRow = this.getRow();
        int currentColumn = this.getColumn();
        
        if (direction == 'u' && Maze.available(currentRow - 1, currentColumn)) {
            String updates = "Moved up!\n";
            Entity replacedEntity = this.put(currentRow - 1, currentColumn);
            updates += this.updatePoints(replacedEntity); // update points
            Maze.setBlank(this.getRow(), this.getColumn()); // set the original position to be blank
            this.setRow(currentRow - 1); // set the new row position
            Maze.getMaze()[this.getRow()][this.getColumn()] = this; // move the squirrel to the new position
            Maze.display(); // rerender the maze
            System.out.println(updates);
        } else if (direction == 'd' && Maze.available(currentRow + 1, currentColumn)) {
            String updates = "Moved down!\n";
            Entity replacedEntity = this.put(currentRow + 1, currentColumn);
            updates += this.updatePoints(replacedEntity);
            Maze.setBlank(this.getRow(), this.getColumn());
            this.setRow(currentRow + 1);
            Maze.getMaze()[this.getRow()][this.getColumn()] = this;
            Maze.display();
            System.out.println(updates);
        } else if (direction == 'l' && Maze.available(currentRow, currentColumn - 1)) {
            String updates = "Moved left!\n";
            Entity replacedEntity = this.put(currentRow, currentColumn - 1);
            updates += this.updatePoints(replacedEntity);
            Maze.setBlank(this.getRow(), this.getColumn());
            this.setColumn(currentColumn - 1);
            Maze.getMaze()[this.getRow()][this.getColumn()] = this;
            Maze.display();
            System.out.println(updates);
        } else if (direction == 'r' && Maze.available(currentRow, currentColumn + 1)) {
            String updates = "Moved right!\n";
            Entity replacedEntity = this.put(currentRow, currentColumn + 1);
            updates += this.updatePoints(replacedEntity);
            Maze.setBlank(this.getRow(), this.getColumn());
            this.setColumn(currentColumn + 1);
            Maze.getMaze()[this.getRow()][this.getColumn()] = this;
            Maze.display();
            System.out.println(updates);
        } else {
            System.out.println("Invalid position or command!");
        }
    }
}