/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Input implements KeyListener{

    private boolean spacePressed=false;
    private boolean spaceReleased=true;
    
    public boolean isSpacePressed(){
        boolean s=spacePressed;
        spacePressed=false;
        return s;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            spacePressed=true;
            spaceReleased=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      if(e.getKeyCode()==KeyEvent.VK_SPACE){
          spaceReleased=true;
      }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
      
    }
}
