package com.PandP.gameworld;

import com.PandP.gameobjects.Airplane;

/**
 * Created by FilGardFoil.
 */
public class GameWorld {

    private Airplane airplane;

    public GameWorld(int midPointY){
        airplane = new Airplane(33, midPointY - 5, 17, 12);
    }

    public void update(float delta){
        airplane.update(delta);

    }

    public Airplane getAirplane(){
        return airplane;
    }

}
