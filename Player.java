import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player class is the class that is controlled by the person playing the game. 
 * This player can move around and shoot at bots. Your objective is to try to get 
 * to 15 points before you lose all your lives. You have tokens that you can pick
 * up that will help you along the way.
 * 
 * @author Lisa Zhu
 * @version 2020/01
 */
public class Player extends MyActor {
    private int health = 100;  //Sets the health of the player  to 100
    private int shoot = 0;  //Counter for each bullet shoot
    private int lives = 3;  //Sets the player to have 5 lives
    private int ammo = 15;  //Sets Player's ammo to 15
    private int bomb = 0;  //Amount of bombs the player has
    private int no; //Variable for nothing
    private long invincibilityStartTime;  //Counter for invincibility
    private int reloadCount = 50;  //Counter for reload
    private boolean hasAmmo = true;  //Player has ammo
    private boolean damageProne = true;  //Allows player to lose health
    private boolean invincibility = false;  //boolean for status

    public Player() {
        GreenfootImage player = new GreenfootImage ("Player.png");  //Sets image of the Player class
        setImage (player);  //Sets image
    }

    public void act() {
        //shows text of these variables in game
        getWorld().showText ("Ammo: " +ammo, 75, 25);
        getWorld().showText ("Bombs Count: " +bomb, 103, 50);
        getWorld().showText ("Invincibility Status: " +invincibility, 137, 75);
        getWorld().showText ("Lives: " +lives, 65, 470);
        getWorld().showText ("Health: " +health, 75, 495);
        movement();
        aim();  //Allows the player to rotate according to mouse position
        checkPickUp();  //Checks if player has picked up any tokens
        changeImage();  //Changes image of player
        bomb();  //Bomb drop by player
        shoot++;  //A counter for shooting
        checkShoot();  //Checks if Player has shot
        checkOutOfBullets();  //Checks if Player has no more ammo
        reload();  //Allows for player to reload ammo
        checkIfHit();  //Checks if Player has been shot
        checkTouchMine();  //Checks if it is touching mine explosion
        checkDie();  //Checks to see if Player has died
        checkEndGame();  //Checks to see if Player has lost all lives
    }

    private void movement() {
        //movement for player
        if (((ShooterWorld) getWorld()).wPressed) {
            setLocation (getX(), getY() - 3);
        }
        if (((ShooterWorld) getWorld()).aPressed) {
            setLocation (getX() - 3, getY());
        }
        if (((ShooterWorld) getWorld()).sPressed) {
            setLocation (getX(), getY() + 3);
        }
        if (((ShooterWorld) getWorld()).dPressed) {
            setLocation (getX() + 3, getY());
        }
    }

    private void aim() {
        MouseInfo mouse = Greenfoot.getMouseInfo(); //Grabs MouseInfo from Greenfoot
        if (mouse != null) //Checks if mouse is not equal to null
        {  
            turnTowards(mouse.getX(), mouse.getY());  //Turns Player towards mouse
        }
    }

    private void checkPickUp() {
        //BombToken bombCheck = (BombToken) getOneIntersectingObject(BombToken.class);
        //HealthToken healthCheck = (HealthToken) getOneIntersectingObject(HealthToken.class);
        //InvincibilityToken InvincibilityCheck = (InvincibilityToken) getOneIntersectingObject(InvincibilityToken.class);
        if (isTouching (BombToken.class)) {
            removeTouching (BombToken.class);
            bomb++;  //Player gets a bomb when touching bomb token
        }
        if (isTouching (HealthToken.class)) {  //If touching the health token
            removeTouching (HealthToken.class);  //It gets removed from the world
            health = health + 25;  //Player gains 25 health
        }
        if (isTouching (InvincibilityToken.class)) {  //If touching the invincibility token
            removeTouching (InvincibilityToken.class);  //It gets removed from the world
            invincibilityStartTime = System.currentTimeMillis();  //Sets start time to the system time
            invincibility = true;  //Sets boolean to true
            damageProne = false;  //Player does not take damage
        }
        if (!damageProne && System.currentTimeMillis() - invincibilityStartTime > 10000) {  //Checks if the player isn't taking damage, then if system time is 10 seconds past the start time
            damageProne = true;  //Player takes damage again
            invincibility = false;  //Sets back to false
        }
    }
    
    private void changeImage() {
        //gets the image
        GreenfootImage player = new GreenfootImage ("Player.png");
        GreenfootImage playerInvincible = new GreenfootImage ("PlayerInvincible.png");
        
        if (damageProne == false) {
            setImage (playerInvincible);  //Sets image to the player with blue glow
        } else {
            setImage (player);  //Sets image back to normal player
        }
    }
    
    private void bomb() {
        if (bomb >= 1) {  //if Player has bomb
            if (Greenfoot.isKeyDown ("f") || Greenfoot.isKeyDown ("F")) {
                getWorld().addObject (new Mine(), getX(), getY());  //adds in bomb
                bomb--;  //player loses a bomb
            }
        }
    }
    
    private void checkShoot() {
        MouseInfo right = Greenfoot.getMouseInfo(); //Grabs Right Click Key from MouseInfo from Greenfoot
        if (right != null) { //Checks if rightclick is not equal to null
            int buttonNumber = right.getButton();  //Creates a variable for right click
            if (buttonNumber == 1 && (shoot >= 15) && (hasAmmo == true)) {  //Check if right click is down and if Player is ready to shoot and has ammo
                BulletPlayer newBullets = new BulletPlayer();  //Creates a variable for a dding a new Bullet of Player
                getWorld().addObject(newBullets, getX() + 5, getY());  //Adds in the bullet
                Greenfoot.playSound ("Gunshot.wav");  //Plays sound of shooting
                newBullets.setRotation (getRotation());  //Sets rotation of bullet to face the shooting direction
                shoot = 0;  //Sets shoot back to 0 to prepare for another shoot
                ammo--;  //Each time a player shoots, they lose ammo
            }
        }
    }

    private void checkOutOfBullets() {
        if (ammo == 0) {  //If ammo count of player is 0
            hasAmmo = false;  //Player is out of ammo
        }
    }
    
    private void reload() {
        // **KEY** Hold down R key to reload
        if (ammo == 0 && Greenfoot.isKeyDown ("r") || Greenfoot.isKeyDown ("R")) {  //If player is out of ammo and r key is pressed
            reloadCount--;  //Counter for reload
            if (reloadCount <= 0) {  //If the counter is less than or equal to 0
                Greenfoot.playSound ("Reload.mp3");
                ammo = 15;  //Gives player 15 ammo
                hasAmmo = true;  //Player now has ammo
                reloadCount = 50;  //Sets counter back to 50
            }
        }
    }
    
    private void checkIfHit() {
        if (isTouching (BulletBots.class) && damageProne == true) {  //Checks to see if it is touching a Bot's bullet and if it can take damage
            removeTouching (BulletBots.class);  //If return true
            if (Greenfoot.getRandomNumber (100) < 20) {
                Greenfoot.playSound ("Hit.wav");  //plays sound 20% of time
            }
            health = health - (Greenfoot.getRandomNumber (5) + 5); //Takes 5 to 10 damage from bot bullets
            setImage ("PlayerHit.png");  //sets image to damaged version of player
            move (-4);  //moves player back
        } else if (!isTouching (BulletBots.class) && damageProne == true) {
            setImage ("Player.png");  //Sets image back
        }
    }

    private void checkTouchMine() {
        if (isTouching (Explosion.class)) {
            health = 0;  //immediately kills player
        }
    }
    
    private void checkDie() {
        if (health <= 0) {
            lives--;  //lives loses a point
            health = 100;  //health is set back to 100
            setLocation (getWorld().getWidth()/2, getWorld().getHeight()/2);  //player respawn
        }
    }

    private void checkEndGame() {
        
    }
}