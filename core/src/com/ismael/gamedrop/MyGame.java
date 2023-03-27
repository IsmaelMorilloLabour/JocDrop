package com.ismael.gamedrop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x = 1;
	float y = 1;

	float vx = 5.0f;
	float vy = 5.0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		if (y >= (Gdx.graphics.getHeight() - img.getHeight())) {
			vy = -vy;
			y = Gdx.graphics.getHeight() - img.getHeight();
		} else if (y <= 0) {
			vy = -vy;
			y = 0;
		}
		y += vy;

		if (x >= (Gdx.graphics.getWidth() - img.getWidth())) {
			vx = -vx;
			x = Gdx.graphics.getWidth() - img.getWidth();
		} else if (x <= 0) {
			vx = -vx;
			x = 0;
		}
		x += vx;

		ScreenUtils.clear(1, 1, 0, 1);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
