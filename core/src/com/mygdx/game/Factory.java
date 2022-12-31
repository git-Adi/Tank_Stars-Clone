package com.mygdx.game;

public abstract class Factory {
    MyGdxGame new_game;
    public Factory(MyGdxGame game){
        new_game =game;
    }
    public abstract Object screen(String need, MyGdxGame game);
}
