package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Tank extends Game {
	private SpriteBatch batch;
	private BitmapFont font;
	private OrthographicCamera camera;
	private Viewport viewport;
	private Skin skin;
	private Stage stage;

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public BitmapFont getFont() {
		return font;
	}

	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Viewport getViewport() {
		return viewport;
	}
	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}
	public Skin getSkin() {
		return skin;
	}
	public void setSkin(Skin skin) {
		this.skin = skin;
	}
	public OrthographicCamera getCamera() {
		return camera;
	}
	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		camera = new OrthographicCamera();
		viewport = new StretchViewport(800,480,camera);
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(viewport);
		this.setScreen( new SplashScreen(this));
	}
	@Override
	public void render () {
		super.render();
		gameExit();
	}
	public void gameExit(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
	}
	@Override
	public void dispose () {
		super.dispose();
	}
	@Override
	public void pause() {
		super.pause();
	}
	@Override
	public void resume() {
		super.resume();
	}
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
