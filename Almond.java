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
public class Almond extends Nut {
    public Almond (char symbol, int row, int col) {
        super(symbol, row, col);
        this.symbol = 'A'; // may not be necessary
        this.nutritionPoints = 5;
        this.name = "Almond";
    }
}
