/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Bird implements Updatable,Renderable{

    private float x,y;
    private float velY;
    private float baseVelY = -6.0f;
    private float gravity = 0.25f;
    
    private Pipes pipes;
    private int scoredPipe=0;
    
    private int score=0;
    
    private Font gameFont = new Font("Arial", Font.BOLD,30);
    
    private BufferedImage flapUp;
    private BufferedImage flapDown;
    
    public Bird(Pipes pipes){
        resetBird();
        
        this.pipes=pipes;
        
        try {
            flapUp=Sprite.getSprite("bird_up.png");
            flapDown=Sprite.getSprite("bird_down.png");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
           
    public void resetBird(){
        x=100;
        y=100;
        velY=baseVelY;
    }
    
    private void flap(){
        velY=baseVelY;
    }
    
    @Override
    public void update(Input input) {
        y+=velY;
        velY+=gravity;
        
        if(y<0){
            y=0;
            velY=0;
        }
        
        if(input.isSpacePressed()){
            flap();
        }
        
        float[] pipeCoordinates = pipes.getNearestPipe();
        float pipeX=pipeCoordinates[0];
        float pipeY=pipeCoordinates[1];
        
        if((x>=pipeX && x<=pipeX + pipes.getPipeWidth() &&
                (y<=pipeY || y >= pipeY+pipes.getVerticalPipeSpace())) ||
                y>=World.HEIGHT){
            pipes.resetPipes();
            resetBird();
            score=0;
        }
        else {
            int nearestPipeID = pipes.getNearestPipeID();
            score=(scoredPipe != nearestPipeID) ? score+1 : score;
            scoredPipe=nearestPipeID;
        }
    }

    @Override
    public void render(Graphics2D g, float interpolation) {
    g.setColor(Color.BLUE);
    
    g.drawImage(velY<=0?flapUp:flapDown, (int)x, (int)(y+(velY+interpolation)),null);
    g.setFont(gameFont);
    g.drawString("Score: "+score, 20, 50);
    }
    
        
    
}
