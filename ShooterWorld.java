import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;  //imports a list

public class ShooterWorld extends World {    
    private Scoreboard score;
    private int treeCount;  //Count of trees
    private int botCount;  //Count of bots
    private long timeStamp;  //Anti cheat time tracker

    /**
     * Constructor for objects of class ShooterWorld.
     * 
     */
    public ShooterWorld()
    {
        super(1000, 520, 1);  //Creates a screen size of 1000 X 520 with each cell 1 X 1
        setPaintOrder (Scoreboard.class, Birds.class, Explosion.class, Trees.class, Player.class, Bots.class, BombToken.class, HealthToken.class, InvincibilityToken.class, BulletPlayer.class, BulletBots.class, Smoke.class, Mine.class, Background.class);
        score = new Scoreboard();
        prepare();  //Set up preparation
        timeStamp = System.currentTimeMillis();  //sets variable to current time
    }
   
    public void prepare() {
        
    }
    public void act() {
        
    }
    
    public void checkForPlayerMovement() {
        
    }
    
    public void update() {
        
    }
}