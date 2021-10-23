package game.graphic;

import game.controllers.SceneController;
import game.core.Global;
import game.utils.Path;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AllImages {

    //角色
    public static ImgArrAndType beige = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Beige_walk1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Beige_walk2()))), Global.MapAreaType.NONE);

    public static ImgArrAndType blue = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Blue_walk1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Blue_walk2()))), Global.MapAreaType.NONE);

    public static ImgArrAndType green = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Green_walk1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Green_walk2()))), Global.MapAreaType.NONE);

    public static ImgArrAndType pink = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Pink_walk1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Pink_walk2()))), Global.MapAreaType.NONE);

    public static ImgArrAndType yellow = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Yellow_walk1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().walk().Yellow_walk2()))), Global.MapAreaType.NONE);

    //爆炸狀態
    public static ImgArrAndType bump = new ImgArrAndType(new ArrayList<Image>(List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().bump().Bump1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().bump().Bump2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().bump().Bump3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().bump().Bump4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().actors().bump().Bump5()))), Global.MapAreaType.NONE);

    //可移動物件
    //怪物(火山)

    public static ImgArrAndType barnacle = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().barnacle1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().barnacle2()))), Global.MapAreaType.VOLCANO);
    //蝙蝠(火山)
    public static ImgArrAndType bat = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bat1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bat2()))), Global.MapAreaType.VOLCANO);
    //蜜蜂(森林)
    public static ImgArrAndType bee = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bee1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bee2()))), Global.MapAreaType.FOREST);
    //bunny1(森林)
    public static ImgArrAndType bunny1 = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bunny1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bunny2()))), Global.MapAreaType.FOREST);
    //bunny2(森林)
    public static ImgArrAndType bunny2 = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bunny21()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().bunny22()))), Global.MapAreaType.FOREST);
    //fishGreen
    public static ImgArrAndType fishGreen = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().fishGreen1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().fishGreen2()))), Global.MapAreaType.ICEFIELD);

    //fishPink
    public static ImgArrAndType fishPink = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().fishPink1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().fishPink2()))), Global.MapAreaType.ICEFIELD);

    //fly(村莊)
    public static ImgArrAndType fly = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().fly1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().fly2()))), Global.MapAreaType.VILLAGE);

    //flyMan(村莊)
    public static ImgArrAndType flyMan = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().flyMan1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().flyMan2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().flyMan3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().flyMan4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().flyMan5()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().flyMan6()))), Global.MapAreaType.VILLAGE);

    //frog(森林)

    public static ImgArrAndType frog = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().frog1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().frog2()))), Global.MapAreaType.FOREST);

    //ladyBug(火山)
    public static ImgArrAndType ladyBug = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(

            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().ladyBug1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().ladyBug2()))), Global.MapAreaType.VOLCANO);

    //mouse(村莊)
    public static ImgArrAndType mouse = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().mouse1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().mouse2()))), Global.MapAreaType.VILLAGE);

    //slime(冰原)

    public static ImgArrAndType slime = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().slime1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().slime2()))), Global.MapAreaType.ICEFIELD);

    //slimeBlue(冰原)
    public static ImgArrAndType slimeBlue = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().slimeBlue1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().slimeBlue2()))), Global.MapAreaType.ICEFIELD);

    //slimeGreen(冰原)
    public static ImgArrAndType slimeGreen = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(

            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().slimeGreen1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().slimeGreen2()))), Global.MapAreaType.ICEFIELD);

    //snail(森林)
    public static ImgArrAndType snail = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snail1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snail2()))), Global.MapAreaType.FOREST);

    //snack(森林)
    public static ImgArrAndType snack = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snake1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snake2()))), Global.MapAreaType.FOREST);

    //snakeLava(火山)
    public static ImgArrAndType snakeLava = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snakeLava1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snakeLava2()))), Global.MapAreaType.VOLCANO);

    //snakeSlime(火山)

    public static ImgArrAndType snakeSlime = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snakeSlime1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().snakeSlime2()))), Global.MapAreaType.VOLCANO);

    //spider(村莊)
    public static ImgArrAndType spider = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().spider1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().move().spider2()))), Global.MapAreaType.VILLAGE);

//    //addSpeed
//    public static ImgArrAndType addSpeed = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
//            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().addSpeed()))), Global.MapAreaType.NONE);

    //questionBox
    public static ImgArrAndType questionBox = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().question1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().question2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().question3()))), Global.MapAreaType.NONE);

    //runnerDark順移動具不可使用
    public static ImgArrAndType runnerDark = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().runnerDark()))), Global.MapAreaType.NONE);

    //runnerLight順移可使用
    public static ImgArrAndType runnerLight = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().runnerLight()))), Global.MapAreaType.NONE);

    //runnerLight順移可使用
    public static ImgArrAndType runnerNormal = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().runnernormal()))), Global.MapAreaType.NONE);

    //變身格
    public static ImgArrAndType changeBody = new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().changeBody()))), Global.MapAreaType.NONE);

    public static ImgArrAndType getRandomImgArrAndType() {
        int random = Global.random(1, 8);
        switch (random) {
            case 1:
                return snack;
            case 2:
                return snail;
            case 3:
                return spider;
            case 4:
                return snakeLava;
            case 5:
                return slimeBlue;
            case 6:
                return slimeGreen;
            case 7:
                return slime;
            default:
                return mouse;
        }

    }

    //WARNING
    public static ImgArrAndType WARNING=new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().warningLabel()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().dontMove().nothing()))),Global.MapAreaType.NONE);
    //no
    public static ImgArrAndType no=new ImgArrAndType(new ArrayList<Image>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().objs().no()))),Global.MapAreaType.NONE);

    //lightning
    public static ImgArrAndType lightning = new ImgArrAndType(new ArrayList<>(List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning0()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning5()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning6()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning7()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning8()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning9()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning10()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning11()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning12()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning13()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning14()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning15()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning16()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().lightning17()))),Global.MapAreaType.NONE);

    //道具動畫（superStar）
    public static ImgArrAndType star = new ImgArrAndType(new ArrayList<>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star5()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star6()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star7()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star8()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star9()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star10()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star11()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().star12()))),Global.MapAreaType.NONE);


    //道具動畫（gameTimeDecrease）
    public static ImgArrAndType gameTimeDecrease = new ImgArrAndType(new ArrayList<>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease5()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease6()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease7()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease8()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().gameTimeDecrease9()))),Global.MapAreaType.NONE);

    //道具動畫（hunterWatcher）
    public static ImgArrAndType hunterWatcher = new ImgArrAndType(new ArrayList<>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher5()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher6()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher7()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher8()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher9()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().hunterWatcher10()))),Global.MapAreaType.NONE);

    //道具動畫（teleportation）
    public static ImgArrAndType teleportation = new ImgArrAndType(new ArrayList<>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().teleportation()))),Global.MapAreaType.NONE);

    //道具動畫（addSpeed）
    public static ImgArrAndType addSpeed = new ImgArrAndType(new ArrayList<>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed1()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed2()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed3()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed4()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed5()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed6()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed7()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed8()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed9()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed10()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed11()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed12()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed13()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed14()),
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().addSpeed15()))),Global.MapAreaType.NONE);

    //道具動畫（teleportation）
    public static ImgArrAndType timeStop = new ImgArrAndType(new ArrayList<>(java.util.List.of(
            SceneController.getInstance().imageController().tryGetImage(new Path().img().propsAnimation().timeStop()))),Global.MapAreaType.NONE);


}
