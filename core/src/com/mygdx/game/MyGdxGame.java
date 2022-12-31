package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;


public class MyGdxGame extends Game implements Screen {
	SpriteBatch batch;
	Texture img;
	private Texture backgroundImage;
	private TextureRegion backgroundTexture;
	OrthographicCamera camera;

	First_interface ms;
	public First_interface game1;
	public First_interface gm1;
	public First_interface getInstancegame_new(){
		if(game1==null){
			game1 = new First_interface(this);
			return game1;

		}else{
			return game1;
		}
	}
	@Override
	public void create () {
//		screenPort = new ScreenViewport();
		batch = new SpriteBatch();
//		ms = new First_interface(this);
		gm1 = new First_interface(this);
		setScreen(gm1);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
