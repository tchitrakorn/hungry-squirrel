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
public class Wall extends Entity {
    public Wall(char symbol, int row, int column) {
        super(symbol, row, column);
    }
  
    @Override
    public void create() {}
}
