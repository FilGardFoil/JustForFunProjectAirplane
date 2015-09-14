package com.PandP.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by FilGardFoil.
 */
public class Pipe extends Scrollable {

    private Random r;
    private Rectangle towerUp, towerDown, barUp, barDown;

    public static final int VERTICAL_GAP = 45;
    public static final int TOWER_WIDTH = 24;
    public static final int TOWER_HEIGHT = 11;

    private float groundY;

    private boolean isScored = false;

    public Pipe (float x, float y, int width, int height, float scrollSpeed, float groundY ){
        super(x, y, width, height, scrollSpeed);
        r = new Random();
        towerUp = new Rectangle();
        towerDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void update(float delta){
        super.update(delta);

        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width, groundY - (position.y + height + VERTICAL_GAP));

        towerUp.set(position.x - (TOWER_WIDTH - width) / 2, position.y + height - TOWER_HEIGHT, TOWER_WIDTH, TOWER_HEIGHT);
        towerUp.set(position.x - (TOWER_WIDTH -width)/2, barDown.y, TOWER_WIDTH, TOWER_HEIGHT);
    }

    @Override
    public void reset(float newX){
        super.reset(newX);
        height = r.nextInt(90) + 15;
        isScored = false;
    }

    public boolean collides(Airplane airplane){

       if (position.x < airplane.getX() + airplane.getWidth()){
            return(Intersector.overlaps(airplane.getBoundingCircle(), barUp) || Intersector.overlaps(airplane.getBoundingCircle(), barDown) || Intersector.overlaps(airplane.getBoundingCircle(), towerUp) || Intersector.overlaps(airplane.getBoundingCircle(), towerDown));
        }
        return false;
    }

    public Rectangle getTowerUp(){
        return towerUp;
    }

    public Rectangle getTowerDown(){
        return towerDown;
    }

    public Rectangle getBarUp(){
        return barUp;
    }

    public Rectangle getBarDown(){
        return barDown;
    }

    public boolean isScored(){
        return isScored;
    }

    public void setScored(boolean b){
        isScored = b;
    }

    public void onRestart(float x, float scrollSpeed){
        velocity.x = scrollSpeed;
        reset(x);
    }
}
