import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Bots that move around and shoot at the Player.
 * 
 * Lisa Zhu
 * 2020/01
 */
public class Bots extends MyActor {
    private int health = 20;  //Sets the health of the bots to 20
    private int shoot = 0;  //Shooting counter so bullets don't spawn in a line
    long lastShotTime = 0;  //Variable for when bot last shot
    private boolean hasShot = false;  //Sets the boolean to false
    final int shotDelay = 500;  //sets the variable to a constant at 500; the time between each shot
    
    public Bots() {
        GreenfootImage bots = new GreenfootImage ("Bots.png");  //Creates a variablefor the image
        bots.scale (75, 75);  //Scales the image to 75 X 75
        setImage (bots);  //Sets the image of the bot
    }
    
    /**
     * Act - do whatever the Bots wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        
    }    
    
    private void movement() {
        
    }
    
    private void checkNearPlayers() {
        
    }
    
    private void checkHit() {
        
    }
    
    private void checkNearMine() {
        
    }
    
    public void checkDie() {
        
    }
}