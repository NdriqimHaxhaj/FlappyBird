/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author Ndriqim Haxhaj
 */
public class Pipes implements Updatable, Renderable {

    private int pipeWidth = 100;
    private int spaceBetween = 210;
    private int spaceVertical = 180;

    private float velX = -5.0f;
    private float x1, x2, x3;
    private float y1, y2, y3;

    // the pipe that is closest to the bird
    private int nearestPipe;
    // an array to hold the pipes coordinates
    private float[][] pipeCoordinates = new float[3][2];

    private Random rand;

    public Pipes() {
        rand = new Random();
        resetPipes();
    }

    public void resetPipes() {
        nearestPipe = 0;

        x1 = World.WIDTH * 2;
        x2 = x1 + pipeWidth + spaceBetween;
        x3 = x2 + pipeWidth + spaceBetween;

        y1 = getRandomY();
        y2 = getRandomY();
        y3 = getRandomY();

    }

    private int getRandomY() {
        return rand.nextInt((int) (World.HEIGHT * 0.4f)) + (World.HEIGHT / 10);
    }

    @Override
    public void update(Input input) {
        x1 += velX;
        x2 += velX;
        x3 += velX;

        //When the first pipe moves out of screen
        if (x1 + pipeWidth < 0) {
            //reset to the otherside
            x1 = World.WIDTH;
            y1 = getRandomY();
            nearestPipe = 1;
        }
        if (x2 + pipeWidth < 0) {
            x2 = World.WIDTH;
            y2 = getRandomY();
            nearestPipe = 2;
        }

        if (x3 + pipeWidth < 0) {
            x3 = World.WIDTH;
            y3 = getRandomY();
            nearestPipe = 0;
        }

        //Update the pipe coordinates
        switch (nearestPipe) {
            case 0:
                pipeCoordinates[0][0] = x1;
                pipeCoordinates[0][1] = y1;
                break;
            case 1:
                pipeCoordinates[1][0] = x2;
                pipeCoordinates[1][1] = y2;
                break;
            case 2:
                pipeCoordinates[2][0] = x3;
                pipeCoordinates[2][1] = y3;
                break;
        }
    }

    @Override
    public void render(Graphics2D g, float interpolation) {
        g.setColor(Color.red);
        
        //Pipe 1
        g.fillRect((int)(x1+(velX*interpolation)), 0, pipeWidth, (int)y1);
        g.fillRect((int)(x1+(velX*interpolation)),(int) (y1+spaceVertical), pipeWidth, World.HEIGHT);
        // Pipe 2
        g.fillRect((int)(x2+(velX*interpolation)), 0, pipeWidth, (int)y2);
        g.fillRect((int)(x2+(velX*interpolation)),(int) (y2+spaceVertical), pipeWidth, World.HEIGHT);
        
        //Pipe 3
        g.fillRect((int)(x3+(velX*interpolation)), 0, pipeWidth, (int)y3);
        g.fillRect((int)(x3+(velX*interpolation)),(int) (y3+spaceVertical), pipeWidth, World.HEIGHT);
    }   

    public float[] getNearestPipe() {
        return pipeCoordinates[nearestPipe];
    }

    public int getNearestPipeID() {
        return nearestPipe;
    }

    public int getPipeWidth() {
        return pipeWidth;
    }

    public int getHorizotalPipeSpace() {
        return spaceBetween;
    }

    public int getVerticalPipeSpace(){
        return spaceVertical;
    }
}
