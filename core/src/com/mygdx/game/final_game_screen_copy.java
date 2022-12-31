package com.mygdx.game;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class final_game_screen_copy extends ScreenAdapter implements Screen {
    final MyGdxGame game;
//    TiledMap tiledMap;
    OrthographicCamera camera;
    OrthographicCamera gamecam;
    Skin mySkin;

    TiledMapRenderer tiledMapRenderer;

    SpriteBatch batch;
    Stage stage;
    float tempx;
    float tempy;
    Stage stage1;
    World world1;
    private Texture backgroundImage;
    private Texture backgroundImage1;
    Viewport gameport;
    Viewport viewport1;
    Body player;
    Array<Body> tempbodies= new Array<Body>();
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    public Vector2 impulse_start;
    public Vector2 impulse_start_new;
    float time_of_flight;
    private Texture myTexture1;
    private TextureRegion myTextureRegion1;
    private TextureRegionDrawable myTexRegionDrawable1;
    private ImageButton button1;
    private Texture myTexture2;
    private TextureRegion myTextureRegion2;
    private TextureRegionDrawable myTexRegionDrawable2;
    private ImageButton button2;
    private Texture myTexture3;
    private TextureRegion myTextureRegion3;
    private TextureRegionDrawable myTexRegionDrawable3;
    private ImageButton button3;
    private Texture myTexture4;
    private TextureRegion myTextureRegion4;
    private TextureRegionDrawable myTexRegionDrawable4;
    private ImageButton button4;
    private
    Texture t;
    private  Texture fuel;
    InputProcessor ip1;
    InputProcessor ip2;
//    Image small_img2;
    public Vector2 impulse_position;
    public Body b2body;
    //    TextureRegion r;
//    Image i;
    Texture small_image;
    Texture small_image1;
    Texture small_image2;
    TextureRegion small_region;
    TextureRegion small_region1;
    TextureRegion small_region2;
    boolean everything_proj;
    float startvel_x;
    float startvel_y;
    int radius_surround;
    float currenttime;
    float speed =50f;
    float playerx=337;
    float playery=325;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Box2DDebugRenderer b2dr1;
    Vector2 movement = new Vector2();
    Vector2 impulse = new Vector2();
    public player player1;
    public player player2;
    public player active_player,inactive_player;
    Skin tpskin;
    String active;
    Touchpad.TouchpadStyle tpstyle;
    Touchpad touchpad;
    missile m1;
    InputMultiplexer multiplexer;
    float start_x ;
    float start_y;
    String img;
    String img2;
    public int m;
    String img_missile;
    float disttime=0;
    public final_game_screen_copy(MyGdxGame game,String img,String img2,String img_missile) {
        this.game = game;
        this.img =img;
        this.img2=img2;
        this.img_missile=img_missile;
        radius_surround=150;
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false,1900,1200);
        gamecam.update();
        gameport = new FitViewport(1900,1200,gamecam);
        stage = new Stage(gameport);
        mapLoader =new TmxMapLoader();
        map = new TmxMapLoader().load("denmamaogame/denmamap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        mySkin =new Skin(Gdx.files.internal(game_constants.skin1));
//        player = new Rectangle();
        small_image = new Texture("bar_clipdrop-background-removal.png");
        small_region = new TextureRegion(small_image, 0, 0, 200, 200);
        small_region.setRegion(10, -6, 500, 350);
        Image small_img = new Image(small_region);

        small_img.setPosition(100, 100);

        fuel=new Texture(Gdx.files.internal("fuelbar.png"));

        small_image1 = new Texture("bar_clipdrop-background-removal.png");
        small_region1 = new TextureRegion(small_image1, 0, 0, 200, 200);
        small_region1.setRegion(10, -6, 500, 350);
        Image small_img1 = new Image(small_region1);

        small_img1.setPosition(100, 100);


        world = new World(new Vector2(0,-16),true);
        world1 = new World(new Vector2(0,-4),true);
        player1 = new player(game,695,605, world,"t1",img,img2);
        player2 = new player(game,1760,605,world,"t2",img,img2);
        active_player = player1;
        start_x = active_player.player_definition.getPosition().x;
        start_y = active_player.player_definition.getPosition().y;
        b2dr = new Box2DDebugRenderer();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
//        Class<? extends MapObject> RectangleMapObject;
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect= ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX()+rect.getWidth()/2, rect.getY()+rect.getHeight()/2);
            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

//        m1 =new missile(game,world);
        b2dr1 = new Box2DDebugRenderer();
        impulse_position = new Vector2();
        impulse_start = new Vector2(0,0);
        impulse_start_new = new Vector2(0,0);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
//        multiplexer = new InputMultiplexer(stage,new InputController());
//        Gdx.input.setInputProcessor(multiplexer);
        myTexture = new Texture(Gdx.files.internal("hamburger (2).png"));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable);
        button.setPosition(60, 1000);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
//                game.setScreen(new choose_tank(game));
                popout();
            }
        });

        Button pickbtn4=new TextButton("Fire",mySkin);
        pickbtn4.setSize(150,70);
        pickbtn4.setPosition(1200,170);
        pickbtn4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                m1 = new missile(game,start_x+10,start_y+10,img_missile,world);
                everything_proj=true;



            }
        });
        myTexture2 = new Texture(Gdx.files.internal("missile5.png"));
        myTextureRegion2 = new TextureRegion(myTexture2);
        myTexRegionDrawable2 = new TextureRegionDrawable(myTextureRegion2);
        button2 = new ImageButton(myTexRegionDrawable2);
        button2.setPosition(800, 170);
        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
                img_missile="missile5.png";

            }
        });
        myTexture3 = new Texture(Gdx.files.internal("missile7.png"));
        myTextureRegion3 = new TextureRegion(myTexture3);
        myTexRegionDrawable3 = new TextureRegionDrawable(myTextureRegion3);
        button3 = new ImageButton(myTexRegionDrawable3);
        button3.setPosition(930, 170);
        button3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
                img_missile="missile7.png";

            }
        });
        myTexture4 = new Texture(Gdx.files.internal("missile9.png"));
        myTextureRegion4 = new TextureRegion(myTexture4);
        myTexRegionDrawable4 = new TextureRegionDrawable(myTextureRegion4);
        button4 = new ImageButton(myTexRegionDrawable4);
        button4.setPosition(1050, 170);
        button4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked1");
                img_missile="missile9.png";

            }
        });

        Gdx.input.setInputProcessor(stage);

        tpmethod();
        stage.addActor(pickbtn4);
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(touchpad);
        Gdx.input.setInputProcessor(new InputController() {

            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Input.Keys.W:
                        movement.y = 1250;
                        break;

                    case Input.Keys.A:
                        movement.x = -105000;
                        break;

                    case Input.Keys.S:
                        movement.y = -1250;
                        break;

                    case Input.Keys.D:
                        movement.x = 105000;
                        break;
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                switch (keycode) {
                    case Input.Keys.W:
                        movement.y = 0;
                        break;

                    case Input.Keys.A:
                        movement.x = 0;
                        break;

                    case Input.Keys.S:
                        movement.y = 0;
                        break;

                    case Input.Keys.D:
                        movement.x = 0;
                        break;
                }
                return true;
            }


        });
        Gdx.input.setInputProcessor(stage);








    }
    public void tpmethod() {
        tpskin = new Skin();
        tpskin.add("touchBackground",new Texture("circle-removebg-preview.png"));
        tpskin.add("touchpadknob", new Texture("target.png"));
        tpstyle=new Touchpad.TouchpadStyle();
        Drawable tpbackground = tpskin.getDrawable("touchBackground");
        Drawable tpknob = tpskin.getDrawable("touchpadknob");
        tpbackground.setMinHeight(40);
        tpbackground.setMinWidth(40);
        tpknob.setMinHeight(100);
        tpknob.setMinWidth(102);

        tpstyle.background = tpbackground;
        tpstyle.knob=tpknob;

        touchpad = new Touchpad(5,tpstyle);
        touchpad.setBounds(1650,100,200,200);
        touchpad.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });

    }
    public void popout(){
        final Button pickbtn=new TextButton("Resume",mySkin);
        final Button pickbtn1=new TextButton("Main Menu",mySkin);
        final Button pickbtn2=new TextButton("Save and Exit",mySkin);
        final Button pickbtn3=new TextButton("Exit",mySkin);
        pickbtn.setSize(400,100);
        pickbtn.setPosition(750,900);
        pickbtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                pickbtn.remove();
                pickbtn1.remove();
                pickbtn2.remove();
                pickbtn3.remove();

            }
        });

        pickbtn1.setSize(400,100);
        pickbtn1.setPosition(750,675);
        pickbtn1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new MenuScreen(game));

            }
        });

        pickbtn2.setSize(400,100);
        pickbtn2.setPosition(750,450);
        pickbtn2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
                game.setScreen(new final_game_screen_copy(game,img,img2,img_missile));

            }
        });

        pickbtn3.setSize(400,100);
        pickbtn3.setPosition(750,225);
        pickbtn3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("this is clicked");
//                game.setScreen(new final_game_screen_copy(game,img,img2));
                Gdx.app.exit();
            }
        });


        stage.addActor((pickbtn));
        stage.addActor((pickbtn1));
        stage.addActor((pickbtn2));
        stage.addActor((pickbtn3));


    }


    public void update(float delt){

        world.step(1/60f,8,3);


    }

    @Override
    public void render(float delta) {

        start_x = active_player.player_definition.getPosition().x;
        start_y = active_player.player_definition.getPosition().y;

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        gamecam.update();
        game.batch.setProjectionMatrix(gamecam.combined);
        active_player.player_definition.applyForce(movement, new Vector2(active_player.player_definition.getPosition().x,active_player.player_definition.getPosition().y),true);
//        m1.missile_def.applyLinearImpulse(impulse_start_new,new Vector2(active_player.player_definition.getPosition().x,active_player.player_definition.getPosition().y),true);



        renderer.setView(gamecam);
        gamecam.update();
        renderer.render();
        update(delta);

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            disttime+=delta;
            System.out.println("dist time "+disttime);
            if(disttime<3) {
                movement.x = 1200000;
                movement.y = -1000000;
                System.out.println("w is pressed");
            }
            else{
                movement.x=0;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            disttime+=delta;
            if(disttime<3) {
                movement.x = -1200000;
                movement.y = -1000000;
                System.out.println("w is pressed");
            }
            else{
                movement.x=0;
            }
            System.out.println("w is pressed");
        }


        if(touchpad.getKnobPercentX()!=0){
            impulse.x = 50 * touchpad.getKnobPercentX()*50;
        }if(touchpad.getKnobPercentY()!=0){
            impulse.y= Math.abs(50 * touchpad.getKnobPercentY()*50);
        }
        if(everything_proj){
            m1.missile_def.applyLinearImpulse(impulse,active_player.player_definition.getPosition(),true);
            currenttime += delta;


            startvel_x = 500 * touchpad.getKnobPercentX()*50;
            startvel_y = 500 * touchpad.getKnobPercentY()*50;

            time_of_flight=(startvel_y/10f);

            if (currenttime>=9){
                m=1;
                if(active_player == player1){
//                    world.destroyBody(m1.missile_def);
                    active_player = player2;
                    inactive_player=player1;

                }
                else{
//                    world.destroyBody(m1.missile_def);
                    active_player = player1;
                    inactive_player=player2;
                }
                float seperationx = Math.abs(active_player.player_definition.getPosition().x-m1.missile_def.getPosition().x);
                System.out.println("separationx "+seperationx);
                System.out.println(active_player.health);
                System.out.println("player pos "+active_player.player_definition.getPosition().x);
                System.out.println("miss pos"+ m1.missile_def.getPosition().x);
                float seperationy = Math.abs(active_player.player_definition.getPosition().y-m1.missile_def.getPosition().y);
                System.out.println("separationy "+seperationx);
                if (seperationx<100 && seperationy<100){
                    active_player.health=active_player.health-25;


                }
                world.destroyBody(m1.missile_def);
                reset();
            }

//            everything_proj = false;

        }


//        impulse_start_new.y = tempy;


        int winner=determineWinner();
        if(winner==1) {
            System.out.println("1 won");
            game.setScreen(new WinnerScreen(game,winner,this.img,this.img2));
        }
        if (winner==2){
            System.out.println("2 won");
            game.setScreen(new WinnerScreen(game,winner,this.img,this.img2));
        }
        impulse.angleDeg();
//        world.step(1/60f,8,3);
        b2dr.render(world,gamecam.combined);

        int h1=player1.health;
        int ret1=h1/25;
        ret1=ret1/4;
        small_region.setRegionWidth((500/100)*(h1));
        int h2=player2.health;
        System.out.println("h2 "+h2);
        int ret2=h2/25;
        ret2=ret2/4;
        System.out.println("ret1 "+ret1);
        System.out.println("ret2 "+ret2);
        float k=3-disttime;
        if(k<0){
            k=0;
        }
        small_region1.setRegionWidth((500/100)*(h2));
        game.batch.begin();
        game.batch.draw(fuel,700,1000,(k)*(500/3),100);
        game.batch.draw(small_region, 200, 700);
        game.batch.draw(small_region1, 1200, 700);
//        game.batch.draw(small_region2,640,170);
        world.getBodies(tempbodies);
        for(Body b: tempbodies){
            if(b.getUserData() != null && b.getUserData() instanceof Sprite){
                Sprite sprite = (Sprite) b.getUserData();
                sprite.setPosition(b.getPosition().x - sprite.getWidth()/2, b.getPosition().y - sprite.getHeight()/2);
                sprite.setRotation(b.getAngle()* MathUtils.radiansToDegrees);
                sprite.draw(game.batch);
            }
        }
        game.batch.end();

        stage.act();
        stage.draw();
    }
    int determineWinner(){
        if (player1.health==0){
            return 2;
        }
        else if(player2.health==0){
            return 1;
        }
        return 0;
    }
    public void reset(){
        disttime=0;
        everything_proj=false;
        currenttime = 0;
    }

    @Override
    public void resize(int width, int height) {
        gamecam.viewportWidth= width;
        gamecam.viewportHeight= height;
        gamecam.update();
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
        map.dispose();
        renderer.dispose();
    }
//    public void handleInput(float dt){
//        if (Gdx.input.isTouched())
//    }
}
