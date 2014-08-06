package com.Pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Random;

public class Pong extends ApplicationAdapter {
	private Stage stage;
    Paddle lPaddle;
    Paddle rPaddle;
    Ball ballGame;
    Random rand;

	@Override
	public void create () {
        stage = new Stage();

        //add paddles
        lPaddle = new Paddle();
        lPaddle.setPosition(0, (Gdx.graphics.getHeight() / 2) - (lPaddle.getHeight() / 2));
        stage.addActor(lPaddle);

        rPaddle = new Paddle();
        rPaddle.setPosition(Gdx.graphics.getWidth() - rPaddle.getWidth(), (Gdx.graphics.getHeight() / 2) - (rPaddle.getHeight() / 2));
        stage.addActor(rPaddle);

        //add ball
        ballGame = new Ball();
        ballGame.setPosition((Gdx.graphics.getWidth() / 2) - (ballGame.getWidth() / 2), (Gdx.graphics.getHeight() / 2) - (ballGame.getHeight() / 2));
        stage.addActor(ballGame);

        //set input processor to be the stage
        Gdx.input.setInputProcessor(stage);

        rand = new Random();
	}

    public void update(float deltaTime) {


        boolean lBool = collides(lPaddle, ballGame);
        boolean rBool = collides(rPaddle, ballGame);

        //check if it has hit the paddles
        if(lBool || rBool) {
            ballGame.ballSpeedX *= -1.1;
            ballGame.ballSpeedY = rand.nextInt(50);

            if(rand.nextInt() % 2 == 0) {
                ballGame.ballSpeedY *= -1;
            }
        }

        //check if it has hit the walls
        if((ballGame.getY() < 0) ||
                (ballGame.getY() + ballGame.getHeight() > Gdx.graphics.getHeight())) {
            ballGame.ballSpeedY *= -1;
        }

        float addX = deltaTime * ballGame.ballSpeedX;
        float addY = deltaTime * ballGame.ballSpeedY;

        ballGame.setPosition(ballGame.getX() + addX, ballGame.getY() + addY);
    }

	@Override
	public void render () {
        float deltaTime = Gdx.graphics.getDeltaTime();
        update(deltaTime);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(deltaTime);
        stage.draw();
	}

    //determines whether or not two actors collided
    public boolean collides(Actor a, Actor b) {
        Rectangle aRect = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
        Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());

        if(aRect.overlaps(bRect)) {
            return true;
        }

        return false;
    }
}
