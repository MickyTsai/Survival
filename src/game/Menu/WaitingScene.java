package game.Menu;

import game.controllers.AudioResourceController;
import game.controllers.SceneController;
import game.core.Global;
import game.core.Position;
import game.gameObj.players.Player;
import game.graphic.AllImages;
import game.graphic.Animation;
import game.graphic.ImgArrAndType;
import game.network.Client.ClientClass;
import game.network.Server.Server;
import game.scene.ConnectPointGameScene;
import game.scene.ConnectTool;
import game.scene.Scene;
import game.utils.CommandSolver;
import game.utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import static game.gameObj.Pact.*;

public class WaitingScene extends Scene implements CommandSolver.MouseCommandListener {
    private Image img;
    private Button buttons;
    //文字(標題)
    //文字(star)
    private Label start;
    private String IP;
    private String name;
    private ImgArrAndType imgArrAndType;
    private int port;
    private int x;
    private int y;
    private Label number;//多少人進來
    private Button backButton;

    public WaitingScene(String IP, String name, ImgArrAndType imgArrAndType, int port) {
        this.name = name;
        this.imgArrAndType = imgArrAndType;
        Position position = randomPosition();
        x = position.intX();
        y = position.intY();
        ConnectTool.instance().setMainPlayer(new Player(position.intX(), position.intY(), this.imgArrAndType, Player.RoleState.PREY, this.name));
        this.IP = IP;
        this.port = port;
        number = new Label(100, 100, "NUMBER:" + " " + ConnectTool.instance().getMainPlayers().size(), FontLoader.Future(40));
        backButton = new Button(Global.SCREEN_X - 100, 20, Global.UNIT_WIDTH, Global.UNIT_HEIGHT, new Animation(AllImages.cross));
    }

    @Override
    public void sceneBegin() {
        img = SceneController.getInstance().imageController().tryGetImage(new Path().img().menu().Scene().scene9());

        start = new Label(Global.SCREEN_X / 2 + 200, Global.SCREEN_Y / 2 + 180, "START", FontLoader.Blocks(40));
        buttons = new Button(start.collider().right()  , start.collider().bottom()-40, Global.UNIT_WIDTH * 2 + 50, Global.UNIT_HEIGHT, start);
        try {
            ConnectTool.instance().connect(IP, port);

        } catch (Exception e) {
            e.getStackTrace();
            AudioResourceController.getInstance().pause(new Path().sound().background().lovelyflower());
            SceneController.getInstance().change(new MenuScene());
        }
    }

    @Override
    public void sceneEnd() {
        img = null;
        start = null;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, Global.SCREEN_X, Global.SCREEN_Y, null);
        if (ClientClass.getInstance().getID() == 100) {
            buttons.paint(g);
        }
        number.paint(g);
        for (int i = 0; i < ConnectTool.instance().getMainPlayers().size(); i++) {
            Player player = ConnectTool.instance().getMainPlayers().get(i);
            player.getOriginalAnimation().paint(Global.SCREEN_X / 2 - ConnectTool.instance().getMainPlayers().size() * (Global.UNIT_WIDTH * 2 + 10) + Global.UNIT_WIDTH * 2 * i, Global.SCREEN_Y / 2, Global.UNIT_WIDTH * 2, Global.UNIT_HEIGHT * 2, g);
            player.getNameLabel().setXY(Global.SCREEN_X / 2 - ConnectTool.instance().getMainPlayers().size() * (Global.UNIT_WIDTH * 2 + 10) + Global.UNIT_WIDTH * 2 * i + 45 - player.getName().length() * 4, Global.SCREEN_Y / 2 - 15);
            player.getNameLabel().paint(g);
        }
        backButton.paint(g);
        Global.mouse.paint(g);
    }

    @Override
    public void update() {
        ClientClass.getInstance().sent(CONNECT, bale(Integer.toString(x), Integer.toString(y), Integer.toString(ChooseRoleScene.imgArrAndTypeParse(imgArrAndType)), name));
        buttons.update();
        number.setWords("NUMBER:" + " " + ConnectTool.instance().getMainPlayers().size());
        ConnectTool.instance().consume();
        for (int i = 0; i < ConnectTool.instance().getMainPlayers().size(); i++) {
            ConnectTool.instance().getMainPlayers().get(i).getOriginalAnimation().update();
        }
    }

    @Override
    public CommandSolver.MouseCommandListener mouseListener() {
        return this;
    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }

    @Override
    public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
        if (state == CommandSolver.MouseState.MOVED) {
            Global.mouse.mouseTrig(e, state, trigTime);
        }
        if (state == CommandSolver.MouseState.PRESSED) {
            if (Global.mouse.isCollision(buttons)) {
                if (ClientClass.getInstance().getID() == 100) {
                    ClientClass.getInstance().sent(START_GAME, bale());
                }
            }
            if (Global.mouse.isCollision(backButton)) {
                if (!ConnectTool.instance().isConnect()) {
                    AudioResourceController.getInstance().pause(new Path().sound().background().lovelyflower());
                    SceneController.getInstance().change(new MenuScene());
                    ConnectTool.reset();
                    return;
                }
                if (ClientClass.getInstance().getID() == 100) {
                    ConnectTool.instance().disconnect();
                    Server.instance().close();
                } else {
                    ConnectTool.instance().disconnect();
                }
                ConnectTool.reset();
                AudioResourceController.getInstance().pause(new Path().sound().background().lovelyflower());
                SceneController.getInstance().change(new MenuScene());
            }
        }
    }

    public static Position randomPosition() {
        int number = Global.random(1, 4);
        switch (number) {
            case 1:
                return new Position(1680, 2850);
            case 2:
                return new Position(3000, 3000);
            case 3:
                return new Position(200, 2288);
            case 4:
                return new Position(1700, 300);
            case 5:
                return new Position(2100, 789);
            case 6:
                return new Position(980, 2500);
            case 7:
                return new Position(2634, 2718);
            default:
                return new Position(250, 300);
        }
    }
}
