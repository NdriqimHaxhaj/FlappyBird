package flappybird;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;

public class World {
    private Canvas world = new Canvas();
    public final static int WIDTH = 800, HEIGHT = 600;
    private String gameTitle = "Flappy Bird";
    private Input input;
    
    private ArrayList<Updatable> updatables = new ArrayList<>();  // Storage for updatable game objects 
    private ArrayList<Renderable> renderables = new ArrayList<>(); // Storage for renderable game objects 

   public void addUpdatable(Updatable u){
       updatables.add(u);
   }
   
   public void removeUpdatable(Updatable u){
       updatables.remove(u);
   }
   
   public void addRenderable(Renderable r){
       renderables.add(r);
   }
   
   public void removeRenderable(Renderable r){
       renderables.remove(r);
   }
   
   
    public void start() {
        Dimension worldSize = new Dimension(World.WIDTH, World.HEIGHT);
        JFrame gameWindow = new JFrame(gameTitle);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(worldSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        world.setSize(worldSize);
        world.setPreferredSize(worldSize);
        gameWindow.add(world);
        gameWindow.setLocationRelativeTo(null); // Center window when opening

        input = new Input();
        world.addKeyListener(input);
        
        //game loop
        final int FRAME_PER_SECOND=60;
        final int TIME_PER_FRAME=1000/FRAME_PER_SECOND; // 16.67 ms per cdo frame
        final int MAX_FRAME_SKIPS=5;
        
        long nextFrame = System.currentTimeMillis();
        int loops;
        float interpolation;
        
        long timeAtLastFPSCheck = 0;
        int frames=0;
        
        boolean flying = true;
        while (flying) {
           //Updating
           loops=0; // Counts the amount of time that we are going to update 
                    // We are not going to render more than MAX_FRAME_SKIPS
           
           while(System.currentTimeMillis()>nextFrame && loops < MAX_FRAME_SKIPS)   {
               update();
               frames++; // Times we are going to update per second
               
               nextFrame+=TIME_PER_FRAME;
               loops++;
               
           }     
                    
           //  Rendering
           // (Actual time to render - Expected time) / TimerPerFrame = Betwen 0 and 1
           interpolation = (float)(System.currentTimeMillis() + TIME_PER_FRAME - nextFrame) 
                            /(float) TIME_PER_FRAME ;
           render(interpolation);
           
           
           //FPS Check
//           if (System.currentTimeMillis() - timeAtLastFPSCheck >= 1000){
//               System.out.println("FPS: "+frames);
//               gameWindow.setTitle(gameTitle + " - FPS: "+frames);
//               frames=0;
//               timeAtLastFPSCheck=System.currentTimeMillis();
//           }
           
        }
    } // end of start() method

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
    } // end of rener(float) method
    
}
