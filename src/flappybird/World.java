package flappybird;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

public class World {

    public final static int WIDTH = 800, HEIGHT = 600;
    private String gameTitle = "Flappy Bird";
    private Input input;

    private ArrayList<Updatable> updatables = new ArrayList<>();  // Storage for updatable game objects 
    private ArrayList<Renderable> renderables = new ArrayList<>(); // Storage for renderable game objects 

    private Canvas world = new Canvas();

    public void start() {
        Dimension worldSize = new Dimension(World.WIDTH, World.HEIGHT);
        JFrame gameWindow = new JFrame(gameTitle);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(worldSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        gameWindow.setMinimumSize(worldSize);
        gameWindow.add(world);
        gameWindow.setLocationRelativeTo(null); // Center window when opening

        //init Input
        input = new Input();
        //game loop
        boolean flying = true;
        while (flying) {

        }
    }

    private void update() {
        for(Updatable u : updatables) {
            u.update(input);
        }
    }
    
    private void render(float interpolation){
        
        BufferStrategy buffer = world.getBufferStrategy(); //Keep the current frame, until there is something relevant to draw in the next frame
        if(buffer==null){ // the first time this function is called
            world.createBufferStrategy(2);
            return;
        }
        
        Graphics2D g2d = (Graphics2D) buffer.getDrawGraphics();
        g2d.clearRect(0, 0, world.getWidth(), world.getHeight()); // cleares the screen (default: white color)
        
        for(Renderable r: renderables){ //After cleaning the screen, render again
            r.render(g2d, interpolation);
        }
        
        g2d.dispose(); // Free up memory
        buffer.show(); // Show what we have to draw
    }
    
    
}
