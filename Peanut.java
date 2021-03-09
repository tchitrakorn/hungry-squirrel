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
public class Peanut extends Nut {
    public Peanut (char symbol, int row, int col) {
        super(symbol, row, col);
        this.symbol = 'P'; // may not be necessary
        this.nutritionPoints = 10;
        this.name = "Peanut";
    }
}
