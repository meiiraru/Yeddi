package yeddi;

import cinnamon.gui.Screen;
import cinnamon.gui.widgets.types.Button;
import cinnamon.model.GeometryHelper;
import cinnamon.render.MatrixStack;
import cinnamon.render.batch.VertexConsumer;
import cinnamon.utils.Resource;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class JamMainMenu extends Screen {

    private static final Resource MENU = new Resource("yeddi", "main_menu.png");

    @Override
    public void init() {
        Button play = new Button(151, 123, 194, 30, null, butt -> client.setScreen(new JamScreen(this)));
        play.setInvisible(true);
        addWidget(play);
        Button tutorial = new Button(151, 163, 194, 30, null, butt -> client.setScreen(new TutorialScreen(this)));
        tutorial.setInvisible(true);
        addWidget(tutorial);
        Button credits = new Button(151, 200, 194, 30, null, butt -> client.setScreen(new CreditsScreen(this)));
        credits.setInvisible(true);
        addWidget(credits);
        super.init();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        VertexConsumer.GUI.consume(GeometryHelper.quad(matrices, 0, 0, width, height), MENU);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean keyPress(int key, int scancode, int action, int mods) {
        if (action == GLFW_PRESS && key == GLFW_KEY_ESCAPE) {
            client.window.exit();
            return true;
        }
        return super.keyPress(key, scancode, action, mods);
    }
}
