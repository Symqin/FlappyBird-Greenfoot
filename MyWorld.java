import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject (new flappybird(), 100, 150);
        addObject (new Pipe(), 300, 150);
        addObject (new Pipe(), 600, 150);
        addObject (new Score(), 300, 100);
    }
    public void act()
    {
    // Check if the "R" key is pressed
    if (Greenfoot.isKeyDown("R")) {
        // Reset the world by creating a new instance of your world class
        Greenfoot.setWorld(new MyWorld()); // Replace with your actual world class name
    }
    // Other actor behavior goes here...
    }

}
