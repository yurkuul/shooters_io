import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Birds fly across the screen and drop tokens with
 * different effects.
 * 
 * Lisa Zhu
 * 2020/01
 */
public class Birds extends MyActor
{
    private long timeDelay;  //Time between each frame rate in animation
    private int frame = 1;
    private int animationCount = 0;
    
    public Birds() {
        setImage ("Bird 1.png");
    }
    
    public void act() {
        movement();
        animationCount++;
        dropTokens();
        checkAtEdge();
    }    
    
    private void movement() {
        move (4);
        
        if (animationCount % 6 == 0) {  //divides animation counter by 6 only if there will be a remainder of 0
            switchImages();
        }
    }
    private void switchImages() {
        //image variables
        GreenfootImage Bird1 = new GreenfootImage ("Bird 1.png");
        GreenfootImage Bird2 = new GreenfootImage ("Bird 2.png");
        GreenfootImage Bird3 = new GreenfootImage ("Bird 3.png");
        GreenfootImage Bird4 = new GreenfootImage ("Bird 4.png");
        //Animating the bird
        if (frame == 1) {
            setImage (Bird1);
        } else if (frame == 2) {
            setImage (Bird2);
        } else if (frame == 3) {
            setImage (Bird3);
        } else if (frame == 4) {
            setImage (Bird4);
            frame = 1;
            return;  //stops the code from executing again
        }
        frame ++;  //Increases the frame
    }
    
    private void dropTokens() {
        if (Greenfoot.getRandomNumber (10000) < 1) {  //0.01% of the time
            getWorld().addObject (new BombToken(), getX(), getY());  //A new bomb token is added to the world
            Greenfoot.playSound ("Tokendrop.wav");  //Plays sound of drop
        }
        if (Greenfoot.getRandomNumber (1000) < 1) {  //0.1% of the time
            getWorld().addObject (new HealthToken(), getX(), getY());  //A new health token is added to the world
            Greenfoot.playSound ("Tokendrop.wav");  //Plays sound of drop
        }
        if (Greenfoot.getRandomNumber (10000) < 1) {  //0.01% of the time
            getWorld().addObject (new InvincibilityToken(), getX(), getY());  //A new invincibility token is added to the world
            Greenfoot.playSound ("Tokendrop.wav");  //Plays sound of drop
        }
    }
    
    private void checkAtEdge() {
        if (isAtEdge()) {  //if at edge
            getWorld().removeObject (this); //remove object
        }
    }
}