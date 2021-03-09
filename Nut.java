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
public abstract class Nut extends Entity {
    private static final int totalNuts = 5;
    protected int nutritionPoints;
    protected String name;
    
    public Nut (char symbol, int row, int col) {
        super(symbol, row, col);
    }
    
    @Override
    public void create() {
        // randomly generate the location of the nut
    }
}
