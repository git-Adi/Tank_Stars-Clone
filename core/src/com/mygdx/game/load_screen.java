package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class load_screen extends ScreenAdapter implements Screen {
    final MyGdxGame game;
    Viewport viewport;
    private Skin mySkin;
    Stage stage;
    SpriteBatch s;
    Stage background;
    public int d ;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;


    public load_screen(MyGdxGame game) {

        this.game = game;
        d=4;
        backgroundImage = new Texture(Gdx.files.internal("mm.jpg"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 878, 495);
        camera = new OrthographicCamera();
        viewport=new FitViewport(1200,600,camera);
        camera.setToOrtho(false, 1200, 600);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin));
        stage =new Stage(viewport);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();


        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        game.batch.draw(backgroundImage, 0,0, 1200, 600);
//        super.render();

//        game.batch.draw(small_region, 100, 100); // implement more than two image


        game.batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Button startbtn=new TextButton("New Game",mySkin);
        startbtn.setSize(250,70);
        startbtn.setPosition(820,400);
        startbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("this is clicked");
                game.setScreen(new choose_tank(game));
            }
        });

        Button settingsbtn=new TextButton("Load Game",mySkin);
        settingsbtn.setSize(250,70);
        settingsbtn.setPosition(820,250);
        settingsbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("this is clicked");
                game.setScreen(new load_game(game));
            }
        });
//        System.out.println(gameConstants.centerX+121);

        Button back=new TextButton("Back",mySkin);
        back.setSize(250,70);
        back.setPosition(820,100);
//        System.out.print(gameConstants.centerX+121);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("this is clicked");
                game.setScreen(new MenuScreen(game));
            }
        });
//        stage.addActor(gameTitle);
        stage.addActor((startbtn));
        stage.addActor(settingsbtn);
        stage.addActor(back);
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
