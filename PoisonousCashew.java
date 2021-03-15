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
public class PoisonousCashew extends Nut {
    public PoisonousCashew (char symbol, int row, int col) {
        super(symbol, row, col);
        this.nutritionPoints = -15;
        this.name = "Cashew";
    }
}
