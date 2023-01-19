import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Trees that are in the world
 * 
 * Lisa Zhu
 * 2020/01
 */
public class Trees extends MyActor
{
    private int treeType = Greenfoot.getRandomNumber (2);  //Sets tree type to a random number between 0 and 1

    public Trees() {
        if (treeType == 0) {  //If tree type is 0
            setImage ("TreeGreen.png");  //Sets image
        } else {  //If tree type is anything other than 0
            setImage ("TreeBrown.png");  //Sets image
        }
        GreenfootImage trees = getImage();  //Gets image of this class
        int size = Greenfoot.getRandomNumber(20) + 90;  //Variable for sisze set between 90 and 110
        trees.scale (size, size);  //Sets the size to a random size
        setImage (trees);  //Sets the image
    }
    
    public void act() 
    {
        checkOverlapping();  //Checks if overlapping other trees
    }    
    
    private void checkOverlapping() {
        if (isTouching (Trees.class)) {  //If they are overlapping
            setLocation (Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(520));  //They get put into another location in the world
        }
    }
}