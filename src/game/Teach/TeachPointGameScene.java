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
import game.scene.SinglePointGameScene;
import game.scene.SingleSurvivalGameScene;
import game.utils.CommandSolver;
import game.utils.Path;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TeachPointGameScene extends Scene implements CommandSolver.MouseCommandListener {
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
        labels.add(new Label(Global.SCREEN_X/4+30,Global.SCREEN_Y/4,"POINT GAME RULE",FontLoader.cuteChinese(60)));

        //規則(2~)
        labels.add(new Label(Global.SCREEN_X/8,Global.SCREEN_Y/4+inter,"1.玩家初始為Hunter",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(2).collider().left(),labels.get(2).collider().bottom()+inter,"2.獵捕其他獵物交換身分並奪取積分",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(3).collider().left(),labels.get(3).collider().bottom()+inter,"3.成為獵物時需透過移動來獲取積分",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(4).collider().left(),labels.get(4).collider().bottom()+inter,"4.當遊戲時間到時積分最多則為贏家",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(4).collider().left(),labels.get(4).collider().bottom()+inter,"4.當遊戲時間到時積分最多則為贏家",FontLoader.cuteChinese(40)));
        labels.add(new Label(labels.get(5).collider().left(),labels.get(5).collider().bottom()+inter,"5.遠離封閉區域，否則將會被扣分",FontLoader.cuteChinese(40)));

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
        if (state == CommandSolver.MouseState.CLICKED) {
            if (Global.mouse.isCollision(buttons.get(0))) {
                SceneController.getInstance().change(new SinglePointGameScene());
            }

            if (Global.mouse.isCollision(buttons.get(2))) {
                SceneController.getInstance().change(new SinglePointGameScene());
            }
        }
        Global.mouse.mouseTrig(e, state, trigTime);

    }
}
