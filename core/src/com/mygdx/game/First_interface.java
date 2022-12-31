package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class First_interface extends ScreenAdapter implements Screen {
    final MyGdxGame game;
    Stage stage;
    private Skin mySkin;
    SpriteBatch s;
    Viewport viewport;
    Animation<TextureRegion> animation;
    float elapsed;
    float Screenwidth=1920;
    float Screenheight=1080;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    Texture small_image;
    Texture small_image3;
    TextureRegion small_region;
    float delay = 2;


    public First_interface(MyGdxGame game) {
        this.game = game;

        backgroundImage = new Texture(Gdx.files.internal("first_interface.jpg"));

        camera = new OrthographicCamera();
        viewport = new FitViewport(1200,600,camera);
        camera.setToOrtho(false, 1200, 600);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin));
        stage =new Stage(viewport);

        small_image3 = new Texture("loading.png");
    }



    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();


        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        game.batch.draw(backgroundImage, 0,0, 1200, 600);
        game.batch.draw(small_image3, 500, -40, 250, 250);

        game.batch.end();


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        super.resize(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Timer.schedule(new Timer.Task(){
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, delay);
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
