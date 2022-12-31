package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class player extends SpriteBatch implements Screen {
    final MyGdxGame game;
    public Body b2body;
    private World world;
    public int health;
    public int fuel;
    public Vector2 positon;
    public Body player_definition;

    public player(MyGdxGame game,float posx,float posy,World world,String s,String img,String img2) {
        this.game = game;
        health =100;
        fuel =100;

        player_definition = defineplayer(posx,posy,world,s,img,img2);


        
    }
    public Body defineplayer(float posx,float posy,World world,String s,String img,String img2){
        if (s.equals("t1")){
            BodyDef bdef = new BodyDef();
            bdef.position.set(posx,posy);
            bdef.fixedRotation=true;
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body= world.createBody(bdef);
            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(12);
            fdef.shape = shape;
            fdef.density= 50f;
            fdef.friction=0.85f;
            b2body.createFixture(fdef);
            Sprite boxsprite = new Sprite(new Texture(img));
            boxsprite.setSize(150, 80);
            boxsprite.setOrigin(boxsprite.getHeight()/2, boxsprite.getWidth()/2);
            b2body.setUserData(boxsprite);
            shape.dispose();
        }else{
            BodyDef bdef = new BodyDef();
            bdef.position.set(posx,posy);
            bdef.fixedRotation=true;
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body= world.createBody(bdef);
            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(12);
            fdef.shape = shape;
            fdef.density= 50f;
            fdef.friction=0.85f;
            b2body.createFixture(fdef);
            Sprite boxsprite = new Sprite(new Texture(img2));
            boxsprite.setSize(150, 80);
            boxsprite.setOrigin(boxsprite.getHeight()/2, boxsprite.getWidth()/2);
            b2body.setUserData(boxsprite);
            shape.dispose();
        }

        return b2body;
    }
    @Override
    public void show() {
        update(Gdx.graphics.getDeltaTime());
    }

    private void update(float deltaTime) {
    }

    @Override
    public void render(float delta) {

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
}
