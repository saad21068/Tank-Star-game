package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Pause_Screen implements Screen {
    private Tank game;
    private Texture backgroundImage,resumeTexture, exitTexture,sgTexture;
    private TextureRegion backgroundTexture,resumeTextureRegion, exitTextureRegion, sgTextureRegion;
    private Image bg1;

    private TextButton resume;
    public Pause_Screen(Tank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("Menu.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0,0 , 666, 374);

        resumeTexture = new Texture(Gdx.files.internal("resume.png"));
        resumeTextureRegion = new TextureRegion(resumeTexture,1920,1080);

        exitTexture = new Texture(Gdx.files.internal("exit.png"));
        exitTextureRegion = new TextureRegion(exitTexture,1920,1080);

        sgTexture = new Texture(Gdx.files.internal("save_game.png"));
        sgTextureRegion = new TextureRegion(sgTexture,1920, 1080);

        game.setCamera(new OrthographicCamera());
        game.getCamera().setToOrtho(false, 660, 380);
        game.setViewport(new StretchViewport(660,380,game.getCamera()));
        game.setStage(new Stage(game.getViewport()));
        Gdx.input.setInputProcessor(game.getStage());
        bg1 = new Image(backgroundTexture);
        game.getStage().addActor(bg1);

        TextButton.TextButtonStyle resumeButtonStyle = new TextButton.TextButtonStyle();
        resumeButtonStyle.font = game.getFont();
        resumeButtonStyle.up = new TextureRegionDrawable(resumeTextureRegion);
        resume = new TextButton("", resumeButtonStyle);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.getCamera().update();
        game.getBatch().begin();
        game.getStage().act();
        game.getStage().draw();
        game.getBatch().end();
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
        game.getScreen().dispose();
        game.getStage().dispose();
    }
}
