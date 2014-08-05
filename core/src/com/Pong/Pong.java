package com.Pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Pong extends ApplicationAdapter {
	private Stage stage;
    Paddle lPaddle;
    Paddle rPaddle;
    Ball ballGame;

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
	}

    public void update(float deltaTime) {

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
}
