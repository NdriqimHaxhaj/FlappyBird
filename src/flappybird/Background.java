/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Background implements Updatable,Renderable {

    private BufferedImage City;

    public Background() {
        try {
            this.City = Sprite.getSprite("../images/city.jpg");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    @Override
    public void update(Input input) {
        //init
    }

    @Override
    public void render(Graphics2D g, float interpolation) {
       g.drawImage(City, null, 0, 0);
    }
    
}
