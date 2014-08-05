package com.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

/**
 * Created by Kenneth on 8/4/2014.
 */
public class Paddle extends Actor {
    private Pixmap pixmap;
    private Texture texture;

    public Paddle() {
        pixmap = new Pixmap(Gdx.graphics.getWidth() / 40, Gdx.graphics.getHeight() / 8, Pixmap.Format.RGB888);

        //fill column with white
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        texture = new Texture(pixmap);

        setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());

        this.addListener(new ActorGestureListener() {
            public void pan (InputEvent event, float x, float y, float deltaX, float deltaY) {
                if(getY() + deltaY < 0) {
                    setY(0);
                } else if(getY() + deltaY + getHeight() > Gdx.graphics.getHeight()) {
                    setY(Gdx.graphics.getHeight() - getHeight());
                } else {
                    setY(getY() + deltaY);
                }
            }
        });
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, this.getX(), this.getY());
    }

}
