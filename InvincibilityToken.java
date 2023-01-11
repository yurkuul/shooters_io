import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When this is picked up by the Player, they receive
 * 10 seconds of invincibility.
 * 
 * Lisa Zhu
 * 2020/01
 */
public class InvincibilityToken extends MyActor
{
    private int size; //Size for token
    private int decrease;  //The variable that decreases the size as it drops
    GreenfootImage invincibility = getImage();  //gets this image
    public boolean isOnGround = false;  //not on ground is false
    
    public InvincibilityToken() {
        size = 80;  //Size of actor is set to 80
        invincibility.scale (size, size);
    }
    
    public void act() 
    {
        if (size > 30)  //If size is not 50, the size will continue to decrease
        {
            setImage(new GreenfootImage(invincibility));
            getImage().scale(--size, --size);  //decreases size
        }
        if (size == 30) {  //When size of token is 50 by 50
            isOnGround = true;  //Is on the ground
        }
    }   
}