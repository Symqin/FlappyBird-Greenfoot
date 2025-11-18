import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flappybirdswitch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flappybirdswitch extends Actor
{
    private double g = 1;
    private int y = 150;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false;

    public flappybirdswitch() {
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }

    public void act() {
        // Add your action code here.
        if (spacePressed()) {
            g = -2;
        }
        g += 0.1;
        y += g;
        setLocation(getX(), (int) y);
        if (isTouchpipe()) {
            isalive = false;
        }
        if (!isalive) {
            getWorld().addObject(new Gameover(), 300, 200);
            getWorld().removeObject(this);
        }

        // Refactor these conditions into switch statements
        String key = Greenfoot.getKey();
        switch (key) {
            case "Q":
                g = -4;
                break;
            case "E":
                g = 4;
                break;
            default:
                break;
        }

        if (!hasaddscore && isacross && isalive) {
            Score.add(1);
        }
        hasaddscore = isacross;
    }

    public boolean spacePressed() {
        boolean pressed = false;
        if (Greenfoot.isKeyDown("Space")) {
            if (!haspressed) {
                pressed = true;
            }
            haspressed = true;
        } else {
            haspressed = false;
        }
        return pressed;
    }

    public boolean isTouchpipe() {
        isacross = false;
        for (Pipe pipe : getWorld().getObjects(Pipe.class)) {
            if (Math.abs(pipe.getX() - getX()) < 69) {
                if (Math.abs(pipe.getY() + 30 - getY()) > 37) {
                    isalive = false;
                }
                isacross = true;
            }
        }
        return !isalive;
    }
}

