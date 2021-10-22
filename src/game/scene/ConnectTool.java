package game.scene;

;

import game.Menu.Mouse;
import game.core.Global;
import game.gameObj.Pact;
import game.gameObj.mapObj.MapObject;
import game.gameObj.obstacle.TransformObstacle;
import game.gameObj.players.Player;
import game.graphic.AllImages;
import game.network.Client.ClientClass;
import game.scene_process.Camera;
import game.utils.GameKernel;
import network.Client.CommandReceiver;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static game.gameObj.Pact.*;

public class ConnectTool implements GameKernel.GameInterface {
    private boolean isConnect;
    private Player mainPlayer;
    private ArrayList<Player> mainPlayers;
//    private ArrayList<MapObject> unPassMapObjects;      連接Scene時，建構子時{set自己角色(new 角色)，加進players}，Scenebegin()，再sent自己創角的訊息出去，server在等人連接的畫面只要一直consume即可。
//    private ArrayList<TransformObstacle> transformObstacles;


    public ConnectTool() {
        isConnect = false;
        mainPlayer = new Player(Global.SCREEN_X / 2, Global.SCREEN_Y / 2, AllImages.beige, Player.RoleState.HUNTER);
        this.mainPlayers = new ArrayList<>();
        mainPlayers.add(mainPlayer);
    }

    public void setIsConnect(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public void createRoom(int port) {
        game.network.Server.Server.instance().create(port);
        game.network.Server.Server.instance().start();
    }

    public String[] serverInformation() { //伺服器的資訊
        return game.network.Server.Server.instance().getLocalAddress();
    }

    public void connect(String host, int port) throws IOException {
        game.network.Client.ClientClass.getInstance().connect(host, port);
        if (mainPlayer != null) {
            mainPlayer.setID(game.network.Client.ClientClass.getInstance().getID());
        }
        isConnect = true;
    }

    public Player getSelf() {
        return mainPlayer;
    }

    public void setMainPlayer(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
    }

    public ArrayList<Player> getMainPlayers() {
        return mainPlayers;
    }

    public void clear() {
        mainPlayer = null;
        mainPlayers = null;
    }

    public void consume() {
        if (isConnect) {
            game.network.Client.ClientClass.getInstance().consume(new CommandReceiver() {
                @Override
                public void receive(int serialNum, int commandCode, ArrayList<String> strs) {
                    switch (commandCode) {
                        case DISCONNECT:
                            for (int i = 1; i < mainPlayers.size(); i++) {
                                if (mainPlayers.get(i).ID() == serialNum) {
                                    mainPlayers.remove(i);
                                    break;
                                }
                            }
                            break;

                        case CONNECT: ///這個要最先做 ==> 還要有很多Scene創房間 輸入等等
                            boolean isburn = false;
                            for (int i = 0; i < mainPlayers.size(); i++) {
                                if (mainPlayers.get(i).ID() == serialNum) {
                                    isburn = true;
                                    break;
                                }
                            }
                            if (!isburn) {
                                if (serialNum == 1) {
                                    mainPlayers.add(new Player(Global.SCREEN_X / 2, Global.SCREEN_Y / 2, AllImages.beige, Player.RoleState.HUNTER));
                                } else {
                                    mainPlayers.add(new Player(Global.MAP_PIXEL_WIDTH - 300, Global.MAP_PIXEL_HEIGHT - 300, AllImages.beige, Player.RoleState.HUNTER));
                                }
                                ClientClass.getInstance().sent(Pact.CONNECT, bale());
                            }
                            break;
                        case UPDATE:

                        case UP:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyPressed(Global.KeyCommand.UP.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case RELEASE_UP:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyReleased(Global.KeyCommand.UP.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case DOWN:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyPressed(Global.KeyCommand.DOWN.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case RELEASE_DOWN:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyReleased(Global.KeyCommand.DOWN.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case LEFT:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyPressed(Global.KeyCommand.LEFT.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case RELEASE_LEFT:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyReleased(Global.KeyCommand.LEFT.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case RIGHT:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyPressed(Global.KeyCommand.RIGHT.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case RELEASE_RIGHT:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyReleased(Global.KeyCommand.RIGHT.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case TRANSFORM:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyPressed(Global.KeyCommand.TRANSFORM.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                        case TELEPORTATION:
                            mainPlayers.forEach(player -> {
                                if (serialNum == player.ID()) {
                                    player.keyPressed(Global.KeyCommand.TELEPORTATION.getValue(), Long.parseLong(strs.get(0)));
                                }
                            });
                            break;
                    }
                }
            });
        }
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < mainPlayers.size(); i++) {
            mainPlayers.get(i).paint(g);
        }
    }

    @Override
    public void update() {
        for (int i = 1; i < mainPlayers.size(); i++) {
            mainPlayers.get(i).update();
        }
    }
}