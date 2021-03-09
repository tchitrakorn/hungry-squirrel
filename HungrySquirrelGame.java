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
public class HungrySquirrelGame {
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.create("Maze.txt");
        maze.display();
        int row, column;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Where would you like to start?");
            System.out.print("Row: ");
            row = scan.nextInt();
            System.out.print("Column: ");
            column = scan.nextInt();
            if (row >= Maze.getMaxRow() || column > Maze.getMaxColumn()) {
                System.out.println("You're outside of the maze. Try again!");
                continue;
            }
            if (Maze.getMaze()[row][column].toString().equals("*")) {
                System.out.println("You hit the wall. Try again!");
                continue;
            }
            break;
        }
        Squirrel squirrel = new Squirrel('@', row, column);
        squirrel.create();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter commands u, d, l, r to move Up, Down, Left, and Right: ");
            String command = scan.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }
            squirrel.move(command.charAt(0));
        }
//        while(true) {
//            System.out.print("Enter row: ");
//            int row = scan.nextInt();
//            if (row == -1) {
//                break;
//            }
//            System.out.print("Enter column: ");
//            int column = scan.nextInt();
//            System.out.println(Maze.available(row, column));
//        }
        //System.out.print("Enter commands u, d, l, r to move Up, Down, Left, and Right: ");
        //String command = scan.nextLine();
        //squirrel.move(command.charAt(0));
    }
    
}
