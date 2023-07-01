package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import java.util.ArrayList;
public class GamePlayScreen implements Screen {
    private Tank game;
    private Texture background,background2,menuTexture;
    private ArrayList<Texture> list1,list2;
    private Player1 player1;
    private Player2 player2;
    private Image bg1,bg2;
    private TextureRegion backgroundTexture,backgroundTexture2,menuTextureRegion;
    private TextButton menu;

    public GamePlayScreen(Tank game){
        //Initialising Game
        this.game = game;
        this.list1 = Select_Tank1.Tanks1;
        this.list2 = Select_Tank_Screen2.Tanks2;
        player1=new Player1(list1.get(Select_Tank1.selected1));
        player2 = new Player2(list2.get(Select_Tank_Screen2.selected2));
        //For Blue Background
        background = new Texture(Gdx.files.internal("GamePlay/background1.png"));
        backgroundTexture = new TextureRegion(background, 0, 0, 1280, 720);

        //For Ground Background
        background2 = new Texture(Gdx.files.internal("GamePlay/background21.png"));
        backgroundTexture2 = new TextureRegion(background2,0,0,1200,650);

        //For Menu Button
        menuTexture = new Texture(Gdx.files.internal("GamePlay/MenuButton.png"));
        menuTextureRegion = new TextureRegion(menuTexture,1920,1080);
        //Initialising Camera
        game.setCamera(new OrthographicCamera());
        game.getCamera().setToOrtho(false, 1200, 720);
        //Initialising Viewport and Stage
        game.setViewport(new StretchViewport(1200,720,game.getCamera()));
        game.setStage(new Stage(game.getViewport()));
        Gdx.input.setInputProcessor(game.getStage());

        bg1 = new Image(backgroundTexture);
        game.getStage().addActor(bg1);

        bg2 = new Image(backgroundTexture2);
        game.getStage().addActor(bg2);

        game.getFont().setColor(Color.BLACK);
        TextButton.TextButtonStyle menuButtonStyle = new TextButton.TextButtonStyle();
        menuButtonStyle.font = game.getFont();
        menuButtonStyle.up = new TextureRegionDrawable(menuTextureRegion);
        menu = new TextButton("",menuButtonStyle);
        game.getStage().addActor(player1);
        game.getStage().addActor(player2);
        func1();
        buttons_pause();
    }
    @Override
    public void show() {
    }
    public void func1(){
        game.getStage().setKeyboardFocus(player1);
    }
    @Override
    public void render(float delta) {
        game.getCamera().update();
        game.getBatch().begin();
        game.getBatch().setColor(Color.WHITE);
        game.getStage().act();
        game.getStage().draw();
        game.getBatch().end();
    }
    public void buttons_pause(){
        menu.setSize(background.getWidth()/10 + 50,background.getHeight()/6);
        menu.setPosition(Gdx.graphics.getWidth()/2 - 750, Gdx.graphics.getHeight()/2 + 225);
        game.getStage().addActor(menu);
        menu.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new Pause_Screen(game));
            }
        });
        game.getStage().addActor(menu);
    }

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height);
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
        game.getStage().dispose();
        game.getScreen().dispose();
    }
}