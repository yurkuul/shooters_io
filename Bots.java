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
        movement();  //Movement for Bots
        checkNearPlayers();  //Checks if it is near the Player
        checkHit();  //Checks to see if they have been hit
        checkNearMine();
    }    
    
    private void movement() {
        move (3);  //Moves by 3
        if (Greenfoot.getRandomNumber(100) < 10) {  //10% of the time
            turn (Greenfoot.getRandomNumber(90) - 45);  //The bot will turn anywhere between 45 to -45
        }
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5) {  //Checks if at edge
            turn (180);  //Turns around
        }
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5) {  //Checks if at edge
            turn (180);  //Turns around
        }
    }
    
    private void checkNearPlayers() {
        List<Bots> enemy = getObjectsInRange (200, Bots.class);  //Creates a list of all the Bots within range
        List<Player> player = getObjectsInRange (200, Player.class);  //Creates a list of all the Players within range
        BulletBots bullets = new BulletBots();  // Creates a variable name for adding a new Bullet 
        if (player.size() > 0 &! hasShot && System.currentTimeMillis() - lastShotTime > shotDelay) {  //Gets the list of the Player's size, and if it is greater than 0 and hasn't shot yet AND if the system time system minus the lastShotTime variable is greater than 500, then
            hasShot = true;  //hasShot is set to true
            lastShotTime = System.currentTimeMillis();  //lastShotTime is set to the system time
            turnTowards (player.get (0).getX(), player.get (0).getY());  //Turns the bot towards the player
            getWorld().addObject (bullets, getX(), getY());  //Adds a new bullet into the world at the bot's position
            bullets.setRotation (getRotation());  //Sets the rotation of the bullets to the direction the bot is facing
        } else {
            hasShot = false;  //hasShot is set to false
        }
    }
    
    private void checkHit() {
        if (isTouching (BulletPlayer.class)) {  //If Bot class is touching the Player's Bullet
            removeTouching (BulletPlayer.class);  //Removes the bullet
            health = health - (Greenfoot.getRandomNumber (3) + 5);  //Health of bot decreases by a range of 5 to 8
            setImage ("BotsHit.png");  //Sets image of the bot to it getting hit
            move (-4);  //Pushes bot backwards when it is hit
        } else {
            setImage ("Bots.png");  //Sets image back to original image
        }
    }
    
    private void checkNearMine() {
        if (isTouching (Explosion.class)) {  //if touching explosion
            health = 0;  //immediately dies
        }
    }
    
    public void checkDie() {
        
    }
}