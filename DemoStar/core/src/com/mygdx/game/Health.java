package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;

public class Health {
    private float health;
    private Texture healthBar;

    public Health(float Health) {
        this.health = Health;
        this.healthBar = new Texture(Gdx.files.internal("first.png"));
    }

}
