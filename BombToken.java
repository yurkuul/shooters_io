import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When this is picked up, Player receives a bomb that they can drop on the ground
 * 
 * Lisa Zhu
 * 2020/01
 */
public class BombToken extends MyActor
{
    private int size; //Size for token
    private int decrease;  //The variable that decreases the size as it drops
    GreenfootImage bomb = getImage();  //gets this image
    public boolean isOnGround = false;  //not on ground is false
    
    public BombToken() {
        size = 80;  //Size of actor is set to 80
        bomb.scale (size, size);
    }
    
    public void act() 
    {
        if (size > 30)   //If size is not 50, the size will continue to decrease
        {
            setImage(new GreenfootImage(bomb));
            getImage().scale(--size, --size);  //decreases size
        }
        if (size == 30) {  //When size of token is 50 by 50
            isOnGround = true;  //Is on the ground
        }
    }
}