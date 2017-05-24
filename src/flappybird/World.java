package flappybird;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class World {

    public final static int WIDTH = 800, HEIGHT = 600;
    private String gameTitle = "Flappy Bird";

    private Canvas world = new Canvas();

    public void start() {
        //init window
        Dimension worldSize = new Dimension(World.WIDTH, World.HEIGHT);
        JFrame gameWindow = new JFrame(gameTitle);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(worldSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        gameWindow.setMinimumSize(worldSize);
        gameWindow.add(world);
        gameWindow.setLocationRelativeTo(null);
        
        //game loop
        boolean flying = true;
        while (flying) {

        }
    }

}
