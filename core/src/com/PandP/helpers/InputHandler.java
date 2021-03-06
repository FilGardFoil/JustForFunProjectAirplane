package com.PandP.helpers;

import com.PandP.gameobjects.Airplane;
import com.PandP.gameworld.GameWorld;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by FilGardFoil.
 */
public class InputHandler implements InputProcessor {

    private Airplane myAirplane;
    private GameWorld myWorld;

    public InputHandler(GameWorld myWorld){
        this.myWorld = myWorld;
        myAirplane = myWorld.getAirplane();
    }
    /*public InputHandler(Airplane airplane){
        myAirplane = airplane;
    }*/

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){
       if (myWorld.isReady()){
           myWorld.start();
       }
        myAirplane.onClick();

       if (myWorld.isGameOver() || myWorld.isHighScore()){
           myWorld.restart();
       }

       return true;
    }

    @Override
    public boolean keyDown(int keycode){
        return false;
    }

    @Override
    public boolean keyUp(int keycode){
        return false;
    }

    @Override
    public boolean keyTyped(char character){
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int sxreenY, int pointer, int button){
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer){
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY){  //проверить потом снести нах
        return false;
    }

    @Override
    public boolean scrolled(int amount){    //проверить потом снести нах
        return false;
    }


}
