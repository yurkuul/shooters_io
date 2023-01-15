import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scoreboard extends MyActor
{
    private int points;  //Points variable
    private Font scoreboardFont = new Font(20);  //Creates a font for the text
    private GreenfootImage scoreboard;

    public Scoreboard()
    {
        points = 0;  //Points is set to 0
        scoreboard = new GreenfootImage(200,50);  //Creates a new image
        scoreboard.setFont( scoreboardFont );  //Sets the font
        scoreboard.setColor (Color.BLACK);  //Sets color to black
        scoreboard.drawString("Score: " + points, 5,25);  //Adds in text to image
        setImage(scoreboard);  //Sets the image
    }

    public void addToScore() {
        
    }
}