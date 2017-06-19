/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.io.IOException;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Main {
    public static void main (String[] args) {
        World world = new World();
        
        //initialise game objects
        Pipes pipes = new Pipes();
        Bird bird = new Bird(pipes);
        Background bg = new Background();
        
        // add updatables and renderables
        world.addUpdatable(bg);
        world.addRenderable(bg);
        world.addRenderable(pipes);
        world.addUpdatable(pipes);
        world.addUpdatable(bird);
        world.addRenderable(bird);
        
       
        // start game!
        world.start();
    }
}
