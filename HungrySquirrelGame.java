/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squirrelgame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tchitrakorn
 */
public class HungrySquirrelGame {
    public static void main(String[] args) {
        // instructions
        System.out.println("Welcome to the Hungry Squirrel Game!");
        System.out.println("In this game, you're a hungry squirrel (@) who wants to collect all the peanuts and almonds.");
        System.out.println("Peanuts (P) are worth 10 points, while Almonds (A) are worth 5 points.");
        System.out.println("Beware! Cashews (C) are poisonous (minus 15 points). Eating too many of them will make you pass out!");
        System.out.println("Explore the maze and collect all the (good) nuts to win the game!");
        
        // create a maze
        Maze maze = new Maze();
        maze.create("Maze.txt");
        maze.display();
        
        // ask for user's input for the starting position of the squirrel
        int row, column;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Where would you like to start?");
            System.out.println("<You will be prompted to enter the row and column position separately>");
            System.out.println("Row positions (0 - 49) | Column positions (0, 19)");
            System.out.print("Row: ");
            row = scan.nextInt();
            System.out.print("Column: ");
            column = scan.nextInt();
            if (row >= Maze.getMaxRow() || column > Maze.getMaxColumn()) {
                System.out.println("You're outside of the maze. Try again!");
                int[] availablePosition1 = Maze.getAvailablePosition();
                int[] availablePosition2 = Maze.getAvailablePosition();
                System.out.println("You can try row " + availablePosition1[0] + " and column " + availablePosition1[1]);
                System.out.println("Or perhaps row " + availablePosition2[0] + " and column " + availablePosition2[1]);
                continue;
            }
            if (Maze.getMaze()[row][column].toString().equals("*")) {
                System.out.println("You hit the wall. Try again!");
                int[] availablePosition1 = Maze.getAvailablePosition();
                int[] availablePosition2 = Maze.getAvailablePosition();
                System.out.println("You can try row " + availablePosition1[0] + " and column " + availablePosition1[1]);
                System.out.println("Or perhaps row " + availablePosition2[0] + " and column " + availablePosition2[1]);
                continue;
            }
            break;
        }
        
        // create a squirrel based on the provided input
        Squirrel squirrel = new Squirrel('@', row, column);
        squirrel.create();
        
        // randomly place 5 poisonous cashews in the maze
        for (int i = 0; i < Nut.getTotalNuts(); i++) {
            int[] randPosition = Maze.getAvailablePosition();
            PoisonousCashew cashew = new PoisonousCashew('C', randPosition[0], randPosition[1]);
            cashew.create();
        }
        
        // instantiate an array of Nut objects and determine and create the type of nut
        Random random = new Random();
        for (int i = 0; i < Nut.getTotalNuts(); i++) {
            int randNut = random.nextInt(2); // 0 is peanut, 1 is almond
            int[] randPosition = Maze.getAvailablePosition();
            if (randNut == 0) { // peanut
                Peanut peanut = new Peanut('P', randPosition[0], randPosition[1]);
                peanut.create();
            } else if (randNut == 1) { // almond
                Almond almond = new Almond('A', randPosition[0], randPosition[1]);
                almond.create();
            }
        }
        
        // display all the entities in the maze (may need refactoring)
        Maze.display();
        
        // ask for user's input for the squirrel's direction
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("<Enter 'quit' whenever you're done foraging!>");
            System.out.print("Enter commands u, d, l, r to move Up, Down, Left, and Right: ");
            String command = scan.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }
            if(command.isEmpty()) {
                System.out.println("Nothing was entered. Please try again!");
                continue;
            }
            if(command.length() != 1) {
                System.out.println("Your command must be exactly 1 character. Please try again!");
                continue;
            }
            squirrel.move(command.charAt(0));
            if (squirrel.checkVictory()) { // if won!
                System.out.println("You successfully collected all the nuts!");
                System.out.println("Thank you for playing this game!");
                break;
            }
            if (squirrel.checkDefeat()) { // if lost (have less than 0 point)
                System.out.println("You ate too many poisonous cashews and passed out!");
                System.out.println("Please try again!");
                break;
            }
        }
    }
    
}
