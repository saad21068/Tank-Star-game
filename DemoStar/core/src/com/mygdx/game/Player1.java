package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class Player1 extends Actor {
    Sprite sprite;
    private float fuel;

    public float getFuel() {
        return fuel;
    }

    public Player1(Texture Player) {
        this.fuel = 1f;
        this.sprite = new Sprite(Player);
        sprite.setSize(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/10 + 20 );
        sprite.setPosition(0,Gdx.graphics.getHeight()/3 - 47);
        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setTouchable(Touchable.enabled);
        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.D && fuel>0f){
                    MoveByAction mba = new MoveByAction();
                    mba.setAmount(10f,0);
                    mba.setDuration(1f);
                    com.mygdx.game.Player1.this.addAction(mba);
                    fuel -=0.03f;
                }
                if (keycode == Input.Keys.A && fuel>0f){
                    MoveByAction mba = new MoveByAction();
                    mba.setAmount(-10f,0);
                    mba.setDuration(1f);
                    com.mygdx.game.Player1.this.addAction(mba);
                    fuel -=0.03f;
                }
                return true;
            }

        });
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch,parentAlpha);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        sprite.setPosition(getX(),getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
