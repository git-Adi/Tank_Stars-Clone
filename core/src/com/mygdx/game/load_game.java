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
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class load_game extends ScreenAdapter implements Screen {

    final MyGdxGame game;
    TiledMap tiledMap;
    OrthographicCamera camera;
    Skin mySkin;

    TiledMapRenderer tiledMapRenderer;

    SpriteBatch batch;
    Stage stage;

    private Texture backgroundImage;
    Viewport viewport;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    int t;
    public int f;
    Texture small_image;
    Texture small_image1;
    Texture small_image2;
    Texture small_image3;
    Texture small_image4;
    Texture small_image5;
    TextureRegion small_region;

    TextureRegion small_region1;

    TextureRegion small_region2;
    TextureRegion small_region3;


    public load_game(MyGdxGame game) {
        this.game = game;
        f=10;
        small_image = new Texture("save_game1.png");
        small_region = new TextureRegion(small_image, 0, 0, 400, 200);
        small_region.setRegion(10, -6, 400, 200);
        Image small_img = new Image(small_region);

        small_img.setPosition(100, 100);

        small_image1 = new Texture("save_game1.png");
        small_region1 = new TextureRegion(small_image1, 0, 0, 400, 200);
        small_region1.setRegion(10, -6, 400, 200);
        Image small_img1 = new Image(small_region1);

        small_img1.setPosition(100, 100);

        small_image2 = new Texture("save_game1.png");
        small_region2 = new TextureRegion(small_image2, 0, 0, 400, 200);
        small_region2.setRegion(10, -6, 400, 200);
        Image small_img2 = new Image(small_region2);

        small_img2.setPosition(100, 100);

        small_image3 = new Texture("save_game1.png");
        small_region3 = new TextureRegion(small_image3, 0, 0, 400, 200);
        small_region3.setRegion(10, -6, 400, 200);
        Image small_img3 = new Image(small_region3);

        small_img.setPosition(100, 100);

        backgroundImage = new Texture(Gdx.files.internal("aditya_proj.png"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 840, 630);
        camera = new OrthographicCamera();
        viewport = new FitViewport(1200,600,camera);
        camera.setToOrtho(false, 1200, 600);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin));
        stage =new Stage(viewport);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        myTexture = new Texture(Gdx.files.internal("back.png"));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable);
        button.setPosition(20,520);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
                game.setScreen(new load_screen(game));

            }
        });
        stage.addActor(button);

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
        game.batch.draw(small_region, 100, 50,400,200);
        game.batch.draw(small_region1, 100, 350,400,200);
        game.batch.draw(small_region2, 700, 50,400,200);
        game.batch.draw(small_region3,700,350,400,200);
        game.batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
