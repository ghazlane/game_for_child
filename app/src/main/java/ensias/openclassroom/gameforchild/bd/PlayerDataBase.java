package ensias.openclassroom.gameforchild.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ensias.openclassroom.gameforchild.beans.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayerDataBase extends RoomDatabase {
    public abstract PlayerDao playerDao();
}


