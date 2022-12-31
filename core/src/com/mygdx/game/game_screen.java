package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class game_screen extends ApplicationAdapter implements Screen {
    final MyGdxGame game;
    TiledMap tiledMap;
    OrthographicCamera camera;
    OrthographicCamera camera1;
    Skin mySkin;

    TiledMapRenderer tiledMapRenderer;

    SpriteBatch batch;
    Stage stage;
    Stage stage1;

    private Texture backgroundImage;
    private Texture backgroundImage1;
    Viewport viewport;
    Viewport viewport1;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;

    private Texture myTexture1;
    private TextureRegion myTextureRegion1;
    private TextureRegionDrawable myTexRegionDrawable1;
    private ImageButton button1;


    Texture small_image;
    Texture small_image1;
    Texture small_image2;
    TextureRegion small_region;
    TextureRegion small_region1;
    TextureRegion small_region2;

    public game_screen(MyGdxGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,1900,1200);
        camera.update();
        viewport = new FitViewport(1900,1200,camera);
        stage = new Stage(viewport);
        tiledMap = new TmxMapLoader().load("denmamap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin1));


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Texture t = new Texture("Tank3(1).png");
        TextureRegion r = new TextureRegion(t, 185, 100);
        Image i = new Image(r);
        i.setPosition(337,290);
        Texture t1 = new Texture("Tank2_inverse.png");
        TextureRegion r1 = new TextureRegion(t1, 185, 100);
        Image i1 = new Image(r1);
        i1.setPosition(1005,338);
        Texture t2 = new Texture("target.png");
        TextureRegion r2 = new TextureRegion(t2, 200, 200);
        Image i2 = new Image(r2);
        i2.setPosition(1600,100);

//        Texture t3 = new Texture("missile.png");
//        TextureRegion r3 = new TextureRegion(t3, 92, 72);
//        Image i3 = new Image(r3);
//        i3.setPosition(880,170);

        myTexture = new Texture(Gdx.files.internal("hamburger (2).png"));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable);
        button.setPosition(60,1100);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
//                game.setScreen(new choose_tank(game));
                stage.clear();
                popout();
            }
        });
        myTexture1 = new Texture(Gdx.files.internal("missile.png"));
        myTextureRegion1 = new TextureRegion(myTexture1);
        myTexRegionDrawable1 = new TextureRegionDrawable(myTextureRegion1);
        button1 = new ImageButton(myTexRegionDrawable1);
        button1.setPosition(880,170);
        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
//                game.setScreen(new choose_tank(game));
                stage.clear();
                popout_missile();
            }
        });
        Button pickbtn4=new TextButton("Fire",mySkin);
        pickbtn4.setSize(150,70);
        pickbtn4.setPosition(1100,170);
        pickbtn4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new game_screen(game));

            }
        });
        stage.addActor(i);
        stage.addActor(i1);
        stage.addActor(i2);
//        stage.addActor(i3);
        stage.addActor(pickbtn4);
        stage.addActor(button);
        stage.addActor(button1);
    }

    public void popout(){
        Button pickbtn=new TextButton("Resume",mySkin);
        pickbtn.setSize(400,100);
        pickbtn.setPosition(750,900);
        pickbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new game_screen(game));

            }
        });
        Button pickbtn1=new TextButton("Main Menu",mySkin);
        pickbtn1.setSize(400,100);
        pickbtn1.setPosition(750,675);
        pickbtn1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new MenuScreen(game));

            }
        });
        Button pickbtn2=new TextButton("Save and Exit",mySkin);
        pickbtn2.setSize(400,100);
        pickbtn2.setPosition(750,450);
        pickbtn2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new game_screen(game));

            }
        });
        Button pickbtn3=new TextButton("Exit",mySkin);
        pickbtn3.setSize(400,100);
        pickbtn3.setPosition(750,225);
        pickbtn3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new game_screen(game));

            }
        });


        stage.addActor((pickbtn));
        stage.addActor((pickbtn1));
        stage.addActor((pickbtn2));
        stage.addActor((pickbtn3));


    }

    public void popout_missile(){
        Texture t5 = new Texture("missile_backgound.jpg");
        TextureRegion r5 = new TextureRegion(t5, 500, 800);
        Image i5 = new Image(r5);
        i5.setPosition(700,200);

        stage.addActor(i5);

        Button pickbtn3=new TextButton("Back",mySkin);
        pickbtn3.setSize(300,100);
        pickbtn3.setPosition(800,225);
        pickbtn3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new game_screen(game));

            }
        });

        Texture t6 = new Texture("missile1.png");
        TextureRegion r6 = new TextureRegion(t6, 200, 180);
        Image i6 = new Image(r6);
        i6.setPosition(850,350);

        stage.addActor(i6);

        Texture t7 = new Texture("missile3.png");
        TextureRegion r7 = new TextureRegion(t7, 200, 180);
        Image i7 = new Image(r7);
        i7.setPosition(850,700);

        stage.addActor(i7);



        stage.addActor(pickbtn3);
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        game.batch.begin();
//        game.batch.draw(small_image2,1130,710, 250, 140);
        game.batch.end();

        stage.act();
        stage.draw();


    }

    @Override
    public void hide() {

    }

}
