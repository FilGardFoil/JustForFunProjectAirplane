package com.PandP.game;


import com.PandP.gameworld.GameRenderer;
import com.PandP.gameworld.GameWorld;
import com.PandP.helpers.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by FilGardFoil.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight/(screenWidth/gameWidth);

        int midPointY = (int) (gameHeight/2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world);

        Gdx.input.setInputProcessor(new InputHandler(world.getAirplane()));
    }

    @Override
    public void render(float delta){

       world.update(delta);
       renderer.render();

    }

    @Override
    public void resize(int width, int heght){
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show(){
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide(){
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause(){
        Gdx.app.log("GameScreen", "pause caled");
    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume caled");
    }

    @Override
    public void dispose(){
        //leave activity
    }

}
