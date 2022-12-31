package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class missile extends ScreenAdapter implements Screen {
    final MyGdxGame game;
    public Body b2body1;
    public World world;
    public Vector2 impulse_missile;
    public Body missile_def;
    public missile(MyGdxGame game,float pos_x,float pos_y,String img_name,World w){
        this.game =game;

        this.world = w;
        missile_def = definemissile(pos_x,pos_y,img_name,world);

    }
    public Body definemissile(float pos_x,float pos_y,String img_name,World world){
        BodyDef bdef = new BodyDef();
        bdef.position.set(pos_x,pos_y);
        bdef.fixedRotation=true;
        bdef.type =BodyDef.BodyType.DynamicBody;
        b2body1 = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(9);
        fdef.shape= shape;
        fdef.density=0.35f;
        fdef.friction=1f;
        b2body1.createFixture(fdef);
        Sprite boxsprite = new Sprite(new Texture(img_name));
        boxsprite.setSize(50,30);
        boxsprite.setOrigin(boxsprite.getHeight()/2, boxsprite.getWidth()/2);
        b2body1.setUserData(boxsprite);
        shape.dispose();
        return b2body1;
    }

}
