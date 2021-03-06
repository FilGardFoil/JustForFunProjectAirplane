package com.PandP.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.Preferences;


/**
 * Created by FilGardFoil.
 */
public class AssetLoader {
    public static Texture texture;
    public static TextureRegion bg, grass;
    public static Animation airplaneAnimation;
    public static TextureRegion airplane, airDown, airUp;
    public static TextureRegion towerUp, towerDown, bar;
    public static Sound crash, flap, coin;
    public static BitmapFont font, shadow;
    private static Preferences prefs;


    public static void load(){
        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);
        grass = new TextureRegion(texture, 0, 43, 143, 11);
        airDown = new TextureRegion(texture, 136, 0, 17, 12);
        airDown.flip(false, true);
        airplane = new TextureRegion(texture, 153, 0, 17, 12);
        airplane.flip(false, true);
        airUp = new TextureRegion(texture, 170, 0, 17, 12);
        airUp.flip(false, true);
        TextureRegion[] airplanes = { airDown, airplane, airUp};
        airplaneAnimation = new Animation(0.06f, airplanes);
        airplaneAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        towerUp = new TextureRegion(texture, 192, 0, 24, 14);
        towerDown = new TextureRegion(towerUp);
        towerDown.flip(false, true);
        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);
        crash = Gdx.audio.newSound(Gdx.files.internal("data/crash.mp3"));
        flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f, -.25f);
        prefs = Gdx.app.getPreferences("JustForFunProject");

        if (!prefs.contains("highScore")){
            prefs.putInteger("highScore", 0);
        }

    }

    public static void setHighScore(int val){
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    public static int getHighScore(){
        return prefs.getInteger("highScore");
    }

    public static void dispose(){
        texture.dispose();
        crash.dispose();
        flap.dispose();
        coin.dispose();
        font.dispose();
        shadow.dispose();
    }
}
