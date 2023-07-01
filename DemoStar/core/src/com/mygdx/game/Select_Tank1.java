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
import java.util.ArrayList;
public class Select_Tank1 implements Screen {
    public  int count = 0;
    public static int selected1;
    final Tank game;
    private Texture backgroundImage,leftTexture,tank1Texture, tank2Texture, tank3Texture,tank1Image,tank2Image,tank3Image,backTexture,nextTexture;
    private TextureRegion backgroundTexture,leftTextureRegion,tankTextureRegion1, tankTextureRegion2, tankTextureRegion3,tank1TextureRegion,backTextureRegion,nextTextureRegion;
    private Image menuBg,image1;
    private TextureRegion[] tanks1;
    public static ArrayList<Texture> Tanks1;
    private TextButton next,Left,Back;
    public Select_Tank1(Tank game) {
        this.game = game;
        game.setCamera(new OrthographicCamera());
        backgroundImage = new Texture(Gdx.files.internal("MenuTextures/MenuBg.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1280, 720);

        leftTexture = new Texture(Gdx.files.internal("left.png"));
        leftTextureRegion = new TextureRegion(leftTexture,0,0,840,879);

        backTexture = new Texture(Gdx.files.internal("backbutton.png"));
        backTextureRegion = new TextureRegion(backTexture,2000,2000);

        nextTexture = new Texture(Gdx.files.internal("next.png"));
        nextTextureRegion = new TextureRegion(nextTexture,550,550);

        tank1Texture = new Texture(Gdx.files.internal("tanks/Tank1.png"));
        tankTextureRegion1 = new TextureRegion(tank1Texture, 1920, 1080);

        tank2Texture = new Texture(Gdx.files.internal("tanks/Tank2.png"));
        tankTextureRegion2 = new TextureRegion(tank2Texture, 1920, 1080);

        tank3Texture = new Texture(Gdx.files.internal("tanks/Tank3.png"));
        tankTextureRegion3 = new TextureRegion(tank3Texture, 1920, 1080);

        tank1Image = new Texture(Gdx.files.internal("tanks/Tank1Image.png"));
        tank1TextureRegion = new TextureRegion(tank1Image,720,720);

        Tanks1 = new ArrayList<>();
        tanks1 = new TextureRegion[]{tankTextureRegion1,tankTextureRegion2,tankTextureRegion3};

        tank2Image = new Texture(Gdx.files.internal("tanks/Tank2Image.png"));
        tank3Image = new Texture(Gdx.files.internal("tanks/Tank3Image.png"));

        Tanks1.add(tank1Image);
        Tanks1.add(tank2Image);
        Tanks1.add(tank3Image);

        game.getCamera().setToOrtho(false, 1200, 720);
        game.setViewport(new StretchViewport(1200,720,game.getCamera()));
        game.setStage(new Stage(game.getViewport()));
        Gdx.input.setInputProcessor(game.getStage());

        menuBg = new Image(backgroundTexture);
        game.getStage().addActor(menuBg);
        image1=new Image(tank1TextureRegion);
        image1.setSize(500,600);
        image1.setPosition(100,0);
        game.getStage().addActor(image1);

        game.getFont().setColor(Color.BLACK);
        TextButton.TextButtonStyle backButtonStyle = new TextButton.TextButtonStyle();
        backButtonStyle.font = game.getFont();
        backButtonStyle.up = new TextureRegionDrawable(backTextureRegion);
        Back = new TextButton("",backButtonStyle);

        TextButton.TextButtonStyle nextButtonStyle = new TextButton.TextButtonStyle();
        nextButtonStyle.font = game.getFont();
        nextButtonStyle.up = new TextureRegionDrawable(nextTextureRegion);
        next = new TextButton("", nextButtonStyle);
    }
    @Override
    public void show() {
        Next_button();
        buttons_right();
        back_button();
    }
    @Override
    public void render(float delta) {
        game.getCamera().update();
        game.getBatch().begin();
        game.getBatch().draw(tanks1[count],600,200,690,360);
        game.getStage().act();
        game.getStage().draw();
        game.getBatch().end();
    }
    public void Next_button(){
        next.setPosition(720, 50);
        next.setSize(450, 300);
        next.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new Select_Tank_Screen2(game));
            }
        });
        game.getStage().addActor(next);
    }
    public void buttons_right(){
        game.getFont().setColor(Color.BLACK);
        TextButton.TextButtonStyle leftButtonStyle = new TextButton.TextButtonStyle();
        leftButtonStyle.font = game.getFont();
        leftButtonStyle.up = new TextureRegionDrawable(leftTextureRegion);
        Left = new TextButton("",leftButtonStyle);
        Left.setSize(100,100);
        Left.setPosition(Gdx.graphics.getWidth()/2 + 350, Gdx.graphics.getHeight()/2 - 37);
        game.getStage().addActor(Left);
        Left.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                count++;
                if(count>2){
                    count=0;
                }
                selected1 = count;
            }
        });
//        System.out.println(selected1);
    }
    public void back_button(){
        Back.setSize(backTexture.getWidth()/10 - 100 ,backTexture.getHeight()/10 - 100);
        Back.setPosition(Gdx.graphics.getWidth()/2 - 695, Gdx.graphics.getHeight()/2 + 220);
        game.getStage().addActor(Back);
        Back.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.setScreen(new MainMenu(game));
            }
        });
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