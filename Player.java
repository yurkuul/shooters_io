import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player class is the class that is controlled by the person playing the game. 
 * This player can move around and shoot at bots. Your objective is to try to get 
 * to 15 points before you lose all your lives. You have tokens that you can pick
 * up that will help you along the way.
 * 
 * @author Lisa Zhu
 * @version 2020/01
 */
public class Player extends MyActor {
    private int health = 100;  //Sets the health of the player  to 100
    private int shoot = 0;  //Counter for each bullet shoot
    private int lives = 3;  //Sets the player to have 5 lives
    private int ammo = 15;  //Sets Player's ammo to 15
    private int bomb = 0;  //Amount of bombs the player has
    private int no; //Variable for nothing
    private long invincibilityStartTime;  //Counter for invincibility
    private int reloadCount = 50;  //Counter for reload
    private boolean hasAmmo = true;  //Player has ammo
    private boolean damageProne = true;  //Allows player to lose health
    private boolean invincibility = false;  //boolean for status

    public Player() {
        GreenfootImage player = new GreenfootImage ("Player.png");  //Sets image of the Player class
        setImage (player);  //Sets image
    }

    public void act() {
        //shows text of these variables in game
        getWorld().showText ("Ammo: " +ammo, 75, 25);
        getWorld().showText ("Bombs Count: " +bomb, 103, 50);
        getWorld().showText ("Invincibility Status: " +invincibility, 137, 75);
        getWorld().showText ("Lives: " +lives, 65, 470);
        getWorld().showText ("Health: " +health, 75, 495);
        movement();
        aim();  //Allows the player to rotate according to mouse position
        checkPickUp();  //Checks if player has picked up any tokens
        changeImage();  //Changes image of player
        bomb();  //Bomb drop by player
    }

    private void movement() {
        //movement for player
        if (((ShooterWorld) getWorld()).wPressed) {
            setLocation (getX(), getY() - 3);
        }
        if (((ShooterWorld) getWorld()).aPressed) {
            setLocation (getX() - 3, getY());
        }
        if (((ShooterWorld) getWorld()).sPressed) {
            setLocation (getX(), getY() + 3);
        }
        if (((ShooterWorld) getWorld()).dPressed) {
            setLocation (getX() + 3, getY());
        }
    }

    private void aim() {
        MouseInfo mouse = Greenfoot.getMouseInfo(); //Grabs MouseInfo from Greenfoot
        if (mouse != null) //Checks if mouse is not equal to null
        {  
            turnTowards(mouse.getX(), mouse.getY());  //Turns Player towards mouse
        }
    }

    private void checkPickUp() {
        //BombToken bombCheck = (BombToken) getOneIntersectingObject(BombToken.class);
        //HealthToken healthCheck = (HealthToken) getOneIntersectingObject(HealthToken.class);
        //InvincibilityToken InvincibilityCheck = (InvincibilityToken) getOneIntersectingObject(InvincibilityToken.class);
        if (isTouching (BombToken.class)) {
            removeTouching (BombToken.class);
            bomb++;  //Player gets a bomb when touching bomb token
        }
        if (isTouching (HealthToken.class)) {  //If touching the health token
            removeTouching (HealthToken.class);  //It gets removed from the world
            health = health + 25;  //Player gains 25 health
        }
        if (isTouching (InvincibilityToken.class)) {  //If touching the invincibility token
            removeTouching (InvincibilityToken.class);  //It gets removed from the world
            invincibilityStartTime = System.currentTimeMillis();  //Sets start time to the system time
            invincibility = true;  //Sets boolean to true
            damageProne = false;  //Player does not take damage
        }
        if (!damageProne && System.currentTimeMillis() - invincibilityStartTime > 10000) {  //Checks if the player isn't taking damage, then if system time is 10 seconds past the start time
            damageProne = true;  //Player takes damage again
            invincibility = false;  //Sets back to false
        }
    }
    
    private void changeImage() {
        //gets the image
        GreenfootImage player = new GreenfootImage ("Player.png");
        GreenfootImage playerInvincible = new GreenfootImage ("PlayerInvincible.png");
        
        if (damageProne == false) {
            setImage (playerInvincible);  //Sets image to the player with blue glow
        } else {
            setImage (player);  //Sets image back to normal player
        }
    }
    
    private void bomb() {
        if (bomb >= 1) {  //if Player has bomb
            if (Greenfoot.isKeyDown ("f") || Greenfoot.isKeyDown ("F")) {
                getWorld().addObject (new Mine(), getX(), getY());  //adds in bomb
                bomb--;  //player loses a bomb
            }
        }
    }
    
    private void checkShoot() {
        
    }

    private void checkOutOfBullets() {
        
    }
    
    private void reload() {
        
    }
    
    private void checkIfHit() {
        
    }

    private void checkTouchMine() {
        
    }
    
    private void checkDie() {
        
    }

    private void checkEndGame() {
        
    }
}