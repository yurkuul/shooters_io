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
        addObject (new Background(), getWidth()/2, getHeight()/2);  //Adds in the background to the ecenter of the screen
        addObject (new Player(), getWidth()/2, getHeight()/2);  //Adds the player in the center of the screen
        for (botCount = 0; botCount < 2; botCount++) {
            addObject (new Bots(), Greenfoot.getRandomNumber (1000), Greenfoot.getRandomNumber (520));  //adds in 2 bots at the beginning
        }
        for (treeCount = 0; treeCount < 5; treeCount++) {
            addObject (new Trees(), Greenfoot.getRandomNumber (1000), Greenfoot.getRandomNumber (520));  //Adds in trees
        }
        addObject (score, 990, 495);  //Adds in a scoreboard
    }

    public void act() {
        //Anti cheat
        if (timeStamp < System.currentTimeMillis()){timeStamp = System.currentTimeMillis();} else System.exit(999);  //Prevents people from changing the clock time forward
        //in the future: add feature to prevent changing the clock backwards
        
        checkForPlayerMovement();  //Checks for movement keys
        if (Greenfoot.getRandomNumber (300) < 1) {  //0.33% of the time
            addObject (new Birds(), 0, Greenfoot.getRandomNumber (520));  //A new bird is added to the world
        }
        if (Greenfoot.getRandomNumber (200) < 1) {  //0.5% of the time
            addObject (new Bots(), Greenfoot.getRandomNumber (1000), Greenfoot.getRandomNumber (520));  //A bot is added in
        }
    }
    
    public void checkForPlayerMovement() {
        
    }
    
    public void update() {
        
    }
}