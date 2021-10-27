package game.Teach;

import game.Menu.Button;
import game.Menu.FontLoader;
import game.Menu.Label;
import game.Menu.MenuScene;
import game.controllers.SceneController;
import game.core.Global;
import game.graphic.AllImages;
import game.graphic.Animation;
import game.scene.Scene;
import game.scene.SingleSurvivalGameScene;
import game.utils.CommandSolver;
import game.utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TeachSurvivalGameScene extends Scene implements CommandSolver.MouseCommandListener {
    private Image img;
    private ArrayList<Label> labels;
    private ArrayList<game.Menu.Button> buttons;

    @Override
    public void sceneBegin() {
        img = SceneController.getInstance().imageController().tryGetImage(new Path().img().menu().Scene().scene8());

        labels=new ArrayList<>();
        buttons=new ArrayList<>();

        //略過鍵(轉到選單)
        buttons.add(new game.Menu.Button(Global.SCREEN_X - 100, 20, Global.UNIT_WIDTH, Global.UNIT_HEIGHT, new Animation(AllImages.cross)));
        buttons.add(new game.Menu.Button(Global.SCREEN_X - 100, 20, Global.UNIT_WIDTH, Global.UNIT_HEIGHT, new Animation(AllImages.inputButton)));

        //next
        labels.add(new game.Menu.Label(100,80,"", FontLoader.Blocks(50)));
        buttons.add(new Button(labels.get(0).collider().left()-10,labels.get(0).collider().bottom()-50,160,60,new Animation(AllImages.inputButton)));

        int inter=70;
        //標題(label1)
        labels.add(new Label(Global.SCREEN_X/2 - 170,Global.SCREEN_Y/4 -100,"SURVIVAL GAME RULE",FontLoader.cuteChinese(40)));
        labels.add(new Label(Global.SCREEN_X/2 -180 ,Global.SCREEN_Y/4 - 60,"      生存模式      ",FontLoader.cuteChinese(40)));

        //規則(2~)
        labels.add(new Label(Global.SCREEN_X/8,Global.SCREEN_Y/4+inter,"1.被獵人抓到就Game Over",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(3).collider().left(),labels.get(3).collider().bottom()+inter,"2.盡快取得越多道具，是生存下去的關鍵",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(4).collider().left(),labels.get(4).collider().bottom()+inter,"3.獵人會隨著時間進行 \"特殊能力\"越多",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(5).collider().left(),labels.get(5).collider().bottom()+inter,"4.變身為當前地圖角色時，能暫時迴避獵人追蹤",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(6).collider().left(),labels.get(6).collider().bottom()+inter,"5.這個模式 \"沒有\" 積分，活到時間結束就是Winner",FontLoader.cuteChinese(40)));

    }

    @Override
    public void sceneEnd() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, Global.SCREEN_X, Global.SCREEN_Y, null);

        for (int i = 0; i < buttons.size(); i++) {
            if(i==1) {
                if (Global.mouse.isCollision(buttons.get(i))) {
                    buttons.get(i).paint(g);
                }
                buttons.get(0).paint(g);
            }else if(i==2){
                if (Global.mouse.isCollision(buttons.get(2))) {
//                    buttons.get(2).paint(g);
                }
            }else {
                buttons.get(i).paint(g);
            }
        }


        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).paint(g);
        }


        Global.mouse.paint(g);
    }

    @Override
    public void update() {

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
        if (state == CommandSolver.MouseState.PRESSED) {
            if (Global.mouse.isCollision(buttons.get(0))) {
                SceneController.getInstance().change(new SingleSurvivalGameScene());
            }

            if (Global.mouse.isCollision(buttons.get(2))) {
                SceneController.getInstance().change(new SingleSurvivalGameScene());
            }
        }
        Global.mouse.mouseTrig(e, state, trigTime);

    }
}