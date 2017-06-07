/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Main {
    public static void main (String[] args){
        World w = new World();
        //initialise game objects
        Pipes p = new Pipes();
        Bird b = new Bird(p);
        Background bg = new Background();
        // add updatables and renderables
        w.addUpdatable(bg);
        w.addRenderable(bg);
        w.addRenderable(p);
        w.addUpdatable(p);
        w.addUpdatable(b);
        w.addRenderable(b);
      
        // start!
        w.start();
    }
}
