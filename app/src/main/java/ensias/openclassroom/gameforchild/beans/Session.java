package ensias.openclassroom.gameforchild.beans;

public class Session {
    public static Player player;

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Session.player = player;
    }
}
