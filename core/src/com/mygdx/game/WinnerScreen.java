package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class WinnerScreen extends ScreenAdapter implements Screen {
    final MyGdxGame game;
    public int player;
    private Texture backgroundImage;
    private  Texture player1,player2;
    private  Texture coin,gameover,trophy;
    TextureRegion coinregion;
    OrthographicCamera camera;

    Viewport viewport;
    Stage stage;
    float delay = 10;
    float curr;
    public WinnerScreen(MyGdxGame game,int player,String img1,String img2){
        this.game=game;
        this.player=player;
        backgroundImage = new Texture(Gdx.files.internal("p1vp2new.jpg"));
        player1=new Texture(Gdx.files.internal(img1));
        player1=new Texture(Gdx.files.internal(img2));
        trophy=new Texture(Gdx.files.internal("trophy.png"));
        gameover=new Texture(Gdx.files.internal("game_over1.png"));

        camera = new OrthographicCamera();
        viewport = new FitViewport(1200,600,camera);
        camera.setToOrtho(false, 1200, 600);
        stage =new Stage(viewport);

    }

    @Override
    public void show() {
        Timer.schedule(new Timer.Task(){
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, delay);

    }

    @Override
    public void render(float delta) {
        curr+=delta;
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();


        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        game.batch.draw(player1,170,200,100,100);

        game.batch.draw(player1,1000,200,100,100);
        game.batch.draw(backgroundImage, 0,0, 1200, 600);
        //game.batch.draw(Player1won, 500, -40, 250, 250);
        if(player==2) {

            if(curr<1) {
                game.batch.draw(trophy, 825, 200, 270, 270);
            }
            if(curr>=1 && curr<2) {
                game.batch.draw(trophy, 892, 267, 135, 135);
            }
            if(curr>=2 && curr<3) {
                game.batch.draw(trophy, 825, 200, 270, 270);
            }
            if(curr>=3 && curr<4) {
                game.batch.draw(trophy, 892, 267, 135, 135);
            }
            if(curr>=4 && curr<5) {
                game.batch.draw(trophy, 825, 200, 270, 270);
            }
            if(curr>=5 && curr<6) {
                game.batch.draw(trophy, 892, 267, 135, 135);
            }
            if(curr>=6 && curr<7) {
                game.batch.draw(trophy, 825, 200, 270, 270);
            }
            if(curr>=7 && curr<8) {
                game.batch.draw(trophy, 892, 267, 135, 135);
            }
            if(curr>=8 && curr<9) {
                game.batch.draw(trophy, 825, 200, 270, 270);
            }
            if(curr>=9) {
                game.batch.draw(trophy, 892, 267, 135, 135);
            }


        }
        else {

            if(curr<1) {
                game.batch.draw(trophy, 175, 200, 270, 270);
            }
            if(curr>=1 && curr<2) {
                game.batch.draw(trophy, 242, 267, 135, 135);
            }
            if(curr>=2 && curr<3) {
                game.batch.draw(trophy, 175, 200, 270, 270);
            }
            if(curr>=3 && curr<4) {
                game.batch.draw(trophy, 242, 267, 135, 135);
            }
            if(curr>=4 && curr<5) {
                game.batch.draw(trophy, 175, 200, 270, 270);
            }
            if(curr>=5 && curr<6) {
                game.batch.draw(trophy, 242, 267, 135, 135);
            }
            if(curr>=6 && curr<7) {
                game.batch.draw(trophy, 175, 200, 270, 270);
            }
            if(curr>=7 && curr<8) {
                game.batch.draw(trophy, 242, 267, 135, 135);
            }
            if(curr>=8 && curr<9) {
                game.batch.draw(trophy, 175, 200, 270, 270);
            }
            if(curr>=9) {
                game.batch.draw(trophy, 242, 267, 135, 135);
            }
        }
        if(curr<1) {
            game.batch.draw(gameover, 510, 370, 230, 230);
        }
        if(curr>=1 && curr<2) {
            game.batch.draw(gameover, 460, 320, 330, 330);
        }

        if(curr>=2 && curr<3) {
            game.batch.draw(gameover, 510, 370, 230, 230);
        }
        if(curr>=3 && curr<4) {
            game.batch.draw(gameover, 460, 320, 330, 330);
        }
        if(curr>=4 && curr<5) {
            game.batch.draw(gameover, 510, 370, 230, 230);
        }
        if(curr>=5 && curr<6) {
            game.batch.draw(gameover, 460, 320, 330, 330);
        }

        if(curr>=6 && curr<7) {
            game.batch.draw(gameover, 510, 370, 230, 230);
        }
        if(curr>=7 && curr<8) {
            game.batch.draw(gameover, 460, 320, 330, 330);
        }
        if(curr>=8 && curr<9) {
            game.batch.draw(gameover, 510, 370, 230, 230);
        }
        if(curr>=9) {
            game.batch.draw(gameover, 460, 320, 330, 330);
        }

        game.batch.end();

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        super.resize(width, height);

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
