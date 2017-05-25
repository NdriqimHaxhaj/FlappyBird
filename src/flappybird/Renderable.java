/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Graphics2D;

/**
 *
 * @author Ndriqim Haxhaj
 */
public interface Renderable {
    
    public void render(Graphics2D g,float interpolation);
    
}
