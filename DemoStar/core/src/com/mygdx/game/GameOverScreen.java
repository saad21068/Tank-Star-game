package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameOverScreen implements Screen {
    final Tank game;
    private Texture texture;
    private TextureRegion backgroundTexture;

    public GameOverScreen(Tank game) {
        this.game = game;
        game.setCamera(new OrthographicCamera());
        game.getCamera().setToOrtho(false,720,480);
        game.setViewport(new StretchViewport(720,480,game.getCamera()));
    }

    @Override
    public void show() {
        texture = new Texture(Gdx.files.internal(""));
        backgroundTexture = new TextureRegion(texture,0,0,720,480);
    }

    @Override
    public void render(float delta) {

    }
    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width,height);
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {

    }
}
