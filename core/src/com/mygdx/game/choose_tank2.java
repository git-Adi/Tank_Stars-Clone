package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;
// red
public class choose_tank2 extends ScreenAdapter implements Screen {
    final MyGdxGame game;
    private Skin mySkin;
    Stage stage;
    SpriteBatch s;
    Stage background;
    Viewport viewport;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    Texture small_image;
    Texture small_image1;
    Texture small_image2;
    Texture small_image3;
    Texture small_image4;
    Texture small_image5;
    TextureRegion small_region;

    TextureRegion small_region1;

    TextureRegion small_region2;

    OrthographicCamera camera;
    private Texture myTexture1;
    private TextureRegion myTextureRegion1;
    private TextureRegionDrawable myTexRegionDrawable1;
    private ImageButton button1;
    private Texture myTexture2;
    private TextureRegion myTextureRegion2;
    private TextureRegionDrawable myTexRegionDrawable2;
    private ImageButton button2;


    public choose_tank2(MyGdxGame game) {
        this.game = game;
        small_image = new Texture("Tank2.png");
        small_region = new TextureRegion(small_image, 0, 0, 200, 200);
        small_region.setRegion(10, -6, 350, 350);
        Image small_img = new Image(small_region);

        small_img.setPosition(100, 100);

        small_image1 = new Texture("Tank3.png");
        small_region1 = new TextureRegion(small_image1, 0, 0, 200, 200);
        small_region1.setRegion(10, -24, 350, 350);
        Image small_img1 = new Image(small_region1);

        small_img1.setPosition(100, 100);

        small_image2 = new Texture("t3.png");
        small_region2 = new TextureRegion(small_image2, 0, 0, 200, 200);
        small_region2.setRegion(10, -80, 350, 350);
        Image small_img2= new Image(small_region2);

        small_img2.setPosition(100, 100);

        small_image3 = new Texture("logo.png");
//        small_image4 = new Texture("arrow.png");
        small_image5 = new Texture("un.png");
//        small_region3 = new TextureRegion(small_image3, 0,0, 200, 200);
//        small_region3.setRegion(-10,50, 600, 98);
//        Image small_img3= new Image(small_region3);

//        small_img3.setPosition(100, 100);
        backgroundImage = new Texture(Gdx.files.internal("aditya_proj.png"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 840, 630);
        camera = new OrthographicCamera();
        viewport = new FitViewport(1200,600,camera);
        camera.setToOrtho(false, 1200, 600);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin));
        stage =new Stage(viewport);
//        Rectangle hello = new Rectangle();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();


        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, 1200, 600);
        game.batch.draw(small_region, 100, 7);
        game.batch.draw(small_region1, 500, -28);
        game.batch.draw(small_region2, 890, 99);
//        game.batch.draw(small_region3, 0, 50);
        game.batch.draw(small_image3, 300, 500, 600, 98);
//        game.batch.draw(small_image4,1130,310, 50, 50);
        game.batch.draw(small_image5,25,300, 50, 50);
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
//        game.batch.begin();
//        game.batch.draw(small_image4,1130,310, 50, 50);
//
//        game.batch.end();
//
//        stage.act();
//        stage.draw();
        myTexture1 = new Texture(Gdx.files.internal("arrow.png"));
        myTextureRegion1 = new TextureRegion(myTexture1);
        myTexRegionDrawable1 = new TextureRegionDrawable(myTextureRegion1);
        button1 = new ImageButton(myTexRegionDrawable1);
        button1.setPosition(1130,310);
        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
                game.setScreen(new choose_tank(game));
//                stage.clear();
//                popout_missile();
            }
        });
        myTexture2 = new Texture(Gdx.files.internal("un.png"));
        myTextureRegion2 = new TextureRegion(myTexture2);
        myTexRegionDrawable2 = new TextureRegionDrawable(myTextureRegion2);
        button2 = new ImageButton(myTexRegionDrawable2);
        button2.setPosition(25,300);
        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
                game.setScreen(new choose_tank1(game));
//                stage.clear();
//                popout_missile();
            }
        });
        Button pickbtn=new TextButton("Pick",mySkin);
        pickbtn.setSize(200,70);
        pickbtn.setPosition(510,60);
        pickbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("this is clicked");
                game.setScreen(new final_game_screen_copy(game,"Tank3.png","Tank3(1)_inverse.png","missile_clipdrop-background-removal.png"));
            }
        });
        stage.addActor((pickbtn));
        stage.addActor(button1);
        stage.addActor(button2);
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
