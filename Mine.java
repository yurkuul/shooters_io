import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mine that is dropped by the player. This blows up
 * Killing everything within its range.
 * 
 * Lisa Zhu
 * 2020/01
 */
public class Mine extends MyActor
{
    private int detonate = 0;  //Counter for when the mine is set off
    
    public Mine() {
        GreenfootImage mine = new GreenfootImage ("Mine.png");  //Creates new image
        mine.scale (25, 25);  //Resizing the mine
        setImage (mine);  //Sets the image
    }
    
    public void act() 
    {
        detonate++;  //Counter add
        if (detonate >= 300) {  //When counter reaches 300,
            getWorld().addObject (new Explosion(), getX(), getY());  //Adds in an explosion
            getWorld().removeObject (this);  //Removes object
        }
    }    
}