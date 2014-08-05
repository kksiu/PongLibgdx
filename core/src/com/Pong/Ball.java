package com.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends Actor {
    private Pixmap pixmap;
    private Texture texture;
    private int widthDiv = 30;

    public Ball() {
        pixmap = new Pixmap(Gdx.graphics.getHeight() / widthDiv, Gdx.graphics.getHeight() / widthDiv, Pixmap.Format.RGB888);

        //fill ball with green
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        texture = new Texture(pixmap);

        //set the bounds of the object
        setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());

    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, this.getX(), this.getY());
    }
}
