package com.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Date;
import java.util.Random;

public class Ball extends Actor {
    private Pixmap pixmap;
    private Texture texture;
    private int widthDiv = 30;
    private int initialSpeed = 100;

    public float ballSpeedX;
    public float ballSpeedY;



    public Ball() {
        pixmap = new Pixmap(Gdx.graphics.getHeight() / widthDiv, Gdx.graphics.getHeight() / widthDiv, Pixmap.Format.RGB888);

        //fill ball with green
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        texture = new Texture(pixmap);

        //set the bounds of the object
        setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());

        ballSpeedX = (new Random((new Date()).getTime()).nextInt() > 0) ? (initialSpeed) : -1 * (initialSpeed);
        ballSpeedY = 0;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, this.getX(), this.getY());
    }
}
