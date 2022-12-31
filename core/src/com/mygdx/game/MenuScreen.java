package com.mygdx.game;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen extends ScreenAdapter implements Screen {
    final MyGdxGame game;

    private Skin mySkin;
    Stage stage;

    SpriteBatch s;
    Stage background;
    Viewport viewport;
    //    Viewport backview;
    float Screenwidth=1920;
    float Screenheight=1080;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private Music menuMusic;
    public int t;
    OrthographicCamera camera;
    Texture small_image;
    TextureRegion small_region;
    Texture myTexture;
    TextureRegion myTextureRegion;
    TextureRegionDrawable myTexRegionDrawable;
    ImageButton button;

    public MenuScreen(MyGdxGame game) {
        this.game = game;
//        small_image = new Texture("settings_icon.png");
//        small_region = new TextureRegion(small_image, 0, 0, 70, 70);
//        small_region.setRegion(5, -7, 70, 70);
//        Image small_img = new Image(small_region);
//
//        small_img.setPosition(100, 100);
        t=0;

        backgroundImage = new Texture(Gdx.files.internal("mm.jpg"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 878, 495);
        camera = new OrthographicCamera();
        viewport = new FitViewport(1200,600,camera);
        camera.setToOrtho(false, 1200, 600);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin));
        stage =new Stage(viewport);


    }

    public void popout1(){
        Button pickbtn=new TextButton("Music:0n/0ff",mySkin);
        pickbtn.setSize(200,100);
        pickbtn.setPosition(550,450);
        pickbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
//                game.setScreen(new game_screen(game));
                if (t==1){
                    menuMusic.setLooping(false);
                    menuMusic.pause();
                    t=0;
                }else {
                    menuMusic = Gdx.audio.newMusic(Gdx.files.internal("a-hero-of-the-80s-126684.ogg"));
                    menuMusic.setLooping(true);
                    menuMusic.play();
                    t=1;
                }



            }
        });
        Button pickbtn1=new TextButton("Terms and Privacy Policy",mySkin);
        pickbtn1.setSize(200,100);
        pickbtn1.setPosition(550,300);
        pickbtn1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.net.openURI("https://aigames.ae/policy#h.v7mztoso1wgw");
                event.handle();
            }
        });
        Button pickbtn2=new TextButton("Back",mySkin);
        pickbtn2.setSize(200,100);
        pickbtn2.setPosition(550,150);
        pickbtn2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new MenuScreen(game));

            }
        });
        stage.addActor(pickbtn);
        stage.addActor(pickbtn1);
        stage.addActor(pickbtn2);
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

//        game.batch.draw(small_region, 20, 520); // implement more than two image


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

        myTexture = new Texture(Gdx.files.internal("settings_icon.png"));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable);
        button.setPosition(20,520);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
//                game.setScreen(new choose_tank(game));
                stage.clear();
                popout1();
            }
        });

        TextButton startbtn=new TextButton("Start Game",mySkin);
        startbtn.setSize(250,70);
        startbtn.setPosition(820,350);
        startbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("this is clicked");
                game.setScreen(new load_screen(game));


            }
        });

        Button settingsbtn=new TextButton("Exit Game",mySkin);
        settingsbtn.setSize(250,70);
        settingsbtn.setPosition(820, 140);
        settingsbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                Gdx.app.exit();


            }
        });



//        stage.addActor(gameTitle);
        stage.addActor((startbtn));
        stage.addActor(settingsbtn);
        stage.addActor(button);
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
