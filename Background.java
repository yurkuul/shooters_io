import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Background of the game is created here
 * 
 * Lisa Zhu
 * 2020/01
 */
public class Background extends MyActor
{
    public Background() {
        //Sets up the background image for the game
        GreenfootImage background = new GreenfootImage (1280, 720); //Sets the image size
        background.setColor (new Color (47, 151, 94)); //Sets color to a green colour
        background.fill(); //Fills the drawing with the colored set
        background.drawRect (640, 360, 1280, 720); //Draws a rectangle
        setImage (background); //Sets the image
    }
}