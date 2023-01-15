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
        points++;  //1 is added to variable points
        scoreboard.clear();  //image gets cleared
        if(points < 15) {  //if points is less than 15
            scoreboard.drawString("Score: " + points, 5,25);  //score will increase by 1
        } else {
            scoreboard.drawString("You win!!!", 5,25);  //you win text
            Greenfoot.playSound ("Fanfare.wav");  //plays ending game
            Greenfoot.stop();  //stops the game
        }
        setImage (scoreboard);  //sets the image
    }
}