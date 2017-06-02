/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Sprite {
    
    public static BufferedImage getSprite(String fileName) throws IOException{
        return ImageIO.read(Sprite.class.getResourceAsStream(fileName));
    }
    
}
