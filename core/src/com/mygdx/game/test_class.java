package com.mygdx.game;

import com.sun.net.httpserver.Authenticator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class test_class {
    MyGdxGame game;
    MenuScreen menu;
    load_screen ls;
    load_game lg;
    player pl;
    choose_tank t1;
    choose_tank1 t11;
    public test_class(MyGdxGame g){
        game = g;
        menu = new MenuScreen(game);
        ls =new load_screen(game);
        lg = new load_game(game);
        t1 = new choose_tank(game);
        t11 =new choose_tank1(game);

    }
    class MyTest {
        @Test
        public void testSum() {
            assertEquals(menu.t, 1);
            assertEquals(ls.d,4);
            assertEquals(lg.f,10);
            assertEquals(t1.g,45);
            assertEquals(t11.u,12);


        }
    }

    public static void main(String[] args) {
        Result result= JUnitCore.runClasses(MyTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
