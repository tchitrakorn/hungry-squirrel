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
public class HungrySquirrelGame {
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.create("Maze.txt");
        maze.display();
        Squirrel squirrel = new Squirrel('@', 18, 10);
        squirrel.create();
    }
    
}
