package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
public class SplashScreen implements Screen {
    final Tank game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    public SplashScreen(final Tank game) {
        this.game = game;
        game.setCamera(new OrthographicCamera());

        backgroundImage = new Texture(Gdx.files.internal("texture/image.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1229);
        game.getCamera().setToOrtho(false, 800, 480);
        game.setViewport(new StretchViewport(800,480,game.getCamera()));
        game.setFont(new BitmapFont(Gdx.files.internal("font.fnt")));
    }
    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);
        game.getCamera().update();
        game.getBatch().setProjectionMatrix(game.getCamera().combined);
        game.getBatch().begin();
        game.getBatch().draw(backgroundTexture, 0,0, 800, 480);
        game.getFont().draw(game.getBatch(),"Click anywhere to Begin!",230,100);
        game.getBatch().end();
        tap_anuywhere_to_change();
    }

    public void tap_anuywhere_to_change(){
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            dispose();
        }
    }
    @Override
    public void resize(int width, int height){
        game.getViewport().update(width,height);
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {}
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
    }
}



