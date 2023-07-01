package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
public class MainMenu implements Screen {
    final Tank game;
    private Texture backgroundImage;
    private Texture newgTexture,resumeTexture,exitTexture;
    private TextureRegion newgTextureRegion,resumeTextureRegion,exitTextureRegion;
    private TextureRegion backgroundTexture;
    private Image menuBg;
    private TextButton newg,resume,exit;
    public MainMenu(final Tank game) {
        this.game = game;
        game.setCamera(new OrthographicCamera());
        backgroundImage = new Texture(Gdx.files.internal("MenuTextures/MenuBg1.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1280, 720);
        // New game button
        newgTexture = new Texture(Gdx.files.internal("MenuTextures/NewGame.png"));
        newgTextureRegion = new TextureRegion(newgTexture,1920,1080);
        TextButton.TextButtonStyle newgButtonStyle = new TextButton.TextButtonStyle();
        newgButtonStyle.font = game.getFont();
        newgButtonStyle.up = new TextureRegionDrawable(newgTextureRegion);
        newg = new TextButton("",newgButtonStyle);
        // Resume game button
        resumeTexture = new Texture(Gdx.files.internal("MenuTextures/Resume.png"));
        resumeTextureRegion = new TextureRegion(resumeTexture,1920,1080);
        TextButton.TextButtonStyle resumeButtonStyle = new TextButton.TextButtonStyle();
        resumeButtonStyle.font = game.getFont();
        resumeButtonStyle.up = new TextureRegionDrawable(resumeTextureRegion);
        resume = new TextButton("", resumeButtonStyle);

        // exit button
        exitTexture = new Texture(Gdx.files.internal("MenuTextures/Exit.png"));
        exitTextureRegion = new TextureRegion(exitTexture,1920,1080);
        TextButton.TextButtonStyle exitButtonStyle = new TextButton.TextButtonStyle();
        exitButtonStyle.font = game.getFont();
        exitButtonStyle.up = new TextureRegionDrawable(exitTextureRegion);
        exit = new TextButton("", exitButtonStyle);
        game.getFont().setColor(Color.BLACK);
        game.getCamera().setToOrtho(false, 1200, 720);
        game.setViewport( new StretchViewport(1200,720,game.getCamera()));
        game.setStage(new Stage(game.getViewport()));
        Gdx.input.setInputProcessor(game.getStage());
        menuBg = new Image(backgroundTexture);
        game.getStage().addActor(menuBg);
    }

    public void buttons_newg(){
        newg.setPosition(680, 400);
        newg.setSize(500, 300);

        newg.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new Select_Tank1(game));
            }
        });
        game.getStage().addActor(newg);
    }
    public void buttons_Resume() {
        resume.setPosition(680, 230);
        resume.setSize(500, 300);
        resume.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
//                game.setScreen(new Select_Tank_Screen(game));

            }
        });
        game.getStage().addActor(resume);
    }
    public void buttons_exit(){
        exit.setPosition(680,50);
        exit.setSize(500,300);
        exit.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                Gdx.app.exit();
            }
        });
        game.getStage().addActor(exit);
    }

    @Override
    public void show() {
        buttons_newg();
        buttons_Resume();
        buttons_exit();
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
        game.getSkin().dispose();
        game.getStage().dispose();
    }
}
