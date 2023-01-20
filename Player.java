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
public class Player extends MyActor
{
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
        
    }

    private void movement() {
    
    }

    private void aim() {
        
    }

    private void checkPickUp() {
        
    }
    
    private void changeImage() {
        
    }
    
    private void bomb() {
        
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