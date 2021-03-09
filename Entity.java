/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squirrelgame;

/**
 *
 * @author tchitrakorn
 */
public abstract class Entity {
    private char symbol;
    private int row;
    private int column;
    
    public Entity(char symbol,int row, int column) {
        this.symbol = symbol;
        this.row = row;
        this.column = column;
    }
    
    public abstract void create();
    
    public Entity put(int newRow, int newCol) {
        // put an entity at a location in the maze
        // returns an object that was replaced in the maze
        Entity originalEntity = Maze.getMaze()[newRow][newCol];
        // Maze.getMaze()[newRow][newCol] = 
        return originalEntity;
    }
    
    @Override
    public String toString() {
        return this.symbol + "";
    }
}
