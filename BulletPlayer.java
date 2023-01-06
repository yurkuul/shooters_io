import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet for the Player.
 * 
 * Lisa Zhu
 * 2020/01
 */
public class BulletPlayer extends MyActor
{
    private int speed;  //Variable for speed of the bullet
    
    public BulletPlayer() {
        speed = Greenfoot.getRandomNumber (3) + 5;  //Sets the speed of the bullet from 5 to 8
    }
    
    public void act() 
    {
        move (speed);  //Moves  by the speed set
        getWorld().addObject (new Smoke(), getX(), getY());  //Adds in a smoke trail
        checkAtEdge();  //Checks if it has reached the edge
    }    
    
    private void checkAtEdge() {
        if (isAtEdge()) {  //If it is at edge
            getWorld().removeObject (this);  //Remove the object
        }
    }
}