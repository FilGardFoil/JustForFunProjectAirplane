package com.PandP.game;

import com.PandP.helpers.AssetLoader;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MainClassGame extends Game {

	@Override
	public void create(){
		Gdx.app.log("MainClassGame","created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}

}
