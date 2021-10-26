package game.scene;

import game.Menu.*;
import game.Menu.Button;
import game.Menu.Label;
import game.controllers.AudioResourceController;
import game.controllers.SceneController;
import game.core.Global;
import game.graphic.AllImages;
import game.graphic.Animation;
import game.utils.CommandSolver;
import game.utils.GameKernel;
import game.utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class PauseWindow implements GameKernel.GameInterface, CommandSolver.MouseCommandListener {
    private boolean isPause;
    private ArrayList<Button> buttons;
    private ArrayList<Label> labels;
    private Image pauseImg;
    private String soundsPath;
    private GameOver scene;

    public PauseWindow(String soundsPath, GameOver currentScene) {
        this.soundsPath = soundsPath;
        scene = currentScene;
        pauseImg = SceneController.getInstance().imageController().tryGetImage(new Path().img().menu().Button().button());
        labels = new ArrayList<Label>();
        buttons = new ArrayList<Button>();
        //文字
        labels = new ArrayList<game.Menu.Label>();
        labels.add(new game.Menu.Label(Global.SCREEN_X / 3 + 30, Global.SCREEN_Y / 4 - 30, "Pause", FontLoader.Blocks(100)));
        labels.add(new game.Menu.Label(Global.SCREEN_X / 3 + 30, labels.get(0).painter().bottom() + 200, "  Continue ", FontLoader.Blocks(36), Color.black));
        labels.add(new game.Menu.Label(Global.SCREEN_X / 3 + 30, labels.get(1).painter().bottom() + 100, "   Exit ", FontLoader.Blocks(36), Color.black));


        //按鈕
        buttons = new ArrayList<Button>();
        buttons.add(new Button(labels.get(1).painter().left(), labels.get(1).painter().top() - 40, 360, 40, new Animation(AllImages.pauseLabel)));
        buttons.add(new Button(labels.get(2).painter().left(), labels.get(2).painter().top() - 40, 360, 40, new Animation(AllImages.pauseLabel)));
    }

    @Override
    public void paint(Graphics g) {
        if (isPause) {
            g.drawImage(pauseImg, Global.SCREEN_X / 3 - 35, Global.SCREEN_Y / 4 , 500, 400, null);
            buttons.forEach(button -> button.paint(g));
            labels.forEach(label -> label.paint(g));
        }
    }

    @Override
    public void update() {

    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean pause) {
        isPause = pause;
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        if (state == CommandSolver.MouseState.CLICKED && isPause) {
            if (Global.mouse.isCollision(buttons.get(0))) {
                setPause(false);
                AudioResourceController.getInstance().play(soundsPath);
            }
            if (Global.mouse.isCollision(buttons.get(1))) {
                AudioResourceController.getInstance().stop(soundsPath);
                scene.gameOver();
            }
        }
        Global.mouse.mouseTrig(e, state, trigTime);
    }
}
