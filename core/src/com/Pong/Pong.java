package com.Pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Pong extends ApplicationAdapter {
	private Stage stage;
	
	@Override
	public void create () {
        stage = new Stage();

        //add paddle
        Paddle lPaddle = new Paddle();
        lPaddle.setPosition(0, (Gdx.graphics.getHeight() / 2) - (lPaddle.getHeight() / 2));
        stage.addActor(lPaddle);

        Paddle rPaddle = new Paddle();
        rPaddle.setPosition(Gdx.graphics.getWidth() - rPaddle.getWidth(), (Gdx.graphics.getHeight() / 2) - (rPaddle.getHeight() / 2));
        stage.addActor(rPaddle);

        //set input processor to be the stage
        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}
}
