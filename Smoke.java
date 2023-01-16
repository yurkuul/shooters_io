import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Smoke that trails behind the bullets of both the bot and the player
 * 
 * Lisa Zhu
 * 2020/01
 */
public class Smoke extends MyActor
{
    private int trans;  //Transparency variable for smoke
    
    public Smoke()
    {
        trans = 255;  //Sets trans to 255
        setRotation (getRotation());  //Sets the rotation to the right direction when added in
    }
    
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().setTransparency (trans);  //Sets the transparency of the bullet to trans
        if (trans > 0) {  //If transparency is greater than 0
            trans = trans - 85;  //Transparency goes down by 85
        } else if (trans <= 0) {  //If transparency is less than or equal to 0
            getWorld().removeObject (this);  //Remove the smoke
        }
    }    
}