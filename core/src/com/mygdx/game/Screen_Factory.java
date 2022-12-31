package com.mygdx.game;

public class Screen_Factory extends Factory{
    public Screen_Factory(MyGdxGame game){
        super (game);
    }

    @Override
    public Object screen(String need, MyGdxGame game) {
        if (need.equals("MenuScreen")){
            return new MenuScreen(game);
        }else if (need.equals("Load screen")){
            return new load_screen(game);
        }
        return null;
    }
}
