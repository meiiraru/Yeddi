package yeddi;

import cinnamon.Cinnamon;
import cinnamon.Client;

public class Yeddi {

    public static void main(String[] args) {
        Client.getInstance().events.setMainScreen(JamMainMenu::new);
        new Cinnamon().run();
    }
}
