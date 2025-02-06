package yeddi;

import cinnamon.Cinnamon;
import cinnamon.Client;
import cinnamon.events.EventType;
import cinnamon.utils.Resource;

public class Yeddi {

    public static void main(String[] args) {
        Cinnamon.WIDTH = 1000;
        Cinnamon.HEIGHT = 600;
        Cinnamon.TITLE = "Yeddi";
        Cinnamon.ICON = new Resource("yeddi", "icon.png");

        Client c = Client.getInstance();
        c.mainScreen = JamMainMenu::new;
        c.events.registerEvent(EventType.SCROLL, o -> {
            double y = (double) o[1];
            int scale = (int) Math.min(c.window.width / 500f, c.window.height / 300f);
            scale = Math.max(1, scale + (int) Math.signum(y));
            c.window.guiScale = scale;
            c.window.resize(500 * scale, 300 * scale);
        });

        new Cinnamon().run();
    }
}
