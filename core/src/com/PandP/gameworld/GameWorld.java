package com.PandP.gameworld;

import com.PandP.gameobjects.Airplane;
import com.PandP.gameobjects.ScrollHandler;
import com.PandP.helpers.AssetLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by FilGardFoil.
 */
public class GameWorld {

    private Airplane airplane;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int score = 0;
    private GameState currentState;

    public int midPointY;

    public enum GameState{
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    public GameWorld(int midPointY){
        currentState = GameState.READY;
        this.midPointY = midPointY;
        airplane = new Airplane(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public void update(float delta){
        switch (currentState){
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }

    }

    public void updateRunning(float delta){
        if (delta > .15f){
            delta = .15f;
        }

        airplane.update(delta);
        scroller.update(delta);

        if ( scroller.collides(airplane) && airplane.isAlive()){
            scroller.stop();
            airplane.crash();
            AssetLoader.crash.play();
        }

        if (Intersector.overlaps(airplane.getBoundingCircle(), ground)){
            scroller.stop();
            airplane.crash();
            airplane.decelerate();
            currentState = GameState.GAMEOVER;

            if (score > AssetLoader.getHighScore()){
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }

        currentState = GameState.GAMEOVER;

    }

    private void updateReady(float delta) {

    }

    public Airplane getAirplane(){
        return airplane;
    }

    public ScrollHandler getScroller(){
        return scroller;
    }

    public int getScore(){
        return score;
    }

    public void addScore(int increment){
        score += increment;
    }

    public boolean isReady(){
        return currentState == GameState.READY;
    }

    public void start(){
        currentState = GameState.RUNNING;
    }

    public void restart(){
        currentState = GameState.READY;
        score = 0;
        airplane.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver(){
        return currentState == GameState.GAMEOVER;
    }

    public boolean isHighScore(){
        return currentState == GameState.HIGHSCORE;
    }


}
