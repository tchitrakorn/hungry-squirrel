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
    protected char symbol;
    protected int row;
    protected int column;
    
    public Entity(char symbol,int row, int column) {
        this.symbol = symbol;
        this.row = row;
        this.column = column;
    }
    
    public abstract void create();
    
    public Entity put(int newRow, int newCol) {
        Entity originalEntity = Maze.getMaze()[newRow][newCol];
        return originalEntity;
    }
    
    public char getSymbol() {
        return this.symbol;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getColumn() {
        return this.column;
    }
    
    public void setRow(int newRow) {
        this.row = newRow;
    }
    
    public void setColumn(int newColumn) {
        this.column = newColumn;
    }
    
    @Override
    public String toString() {
        return this.symbol + "";
    }
}
