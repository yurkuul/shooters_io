import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A token that can be picked up by the player.
 * This provides the Player with more health
 * 
 * Lisa Zhu
 * 2020/01
 */
public class HealthToken extends MyActor
{
    private int size;  //Size for token
    private int decrease;  //The variable that decreases the size as it drops
    GreenfootImage health = getImage();  //gets this image
    public boolean isOnGround = false;  //not on ground is false
    
    public HealthToken() {
        size = 80;  //Size of actor is set to 80
        health.scale (size, size);
    }
    
    public void act() 
    {
        if (size > 30)  //If size is not 50, the size will continue to decrease
        {
            setImage(new GreenfootImage(health));
            getImage().scale(--size, --size);  //decreases size
        }
        if (size == 30) {  //When size of token is 50 by 50
            isOnGround = true;  //Is on the ground
        }
    }
}