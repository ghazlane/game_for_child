package ensias.openclassroom.gameforchild.bd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ensias.openclassroom.gameforchild.beans.Player;

@Dao
public interface PlayerDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    public void addPlayer(Player player);
    /*@Query("select * from players where login = :login")
    public List<User> getUser(String login);*/
    @Query("select * from player")
    public List<Player> getAllPlayer();
    @Delete
    public void deletePlayer(Player player);
    @Query("UPDATE player SET level = :level WHERE id = :id")
    int updatePlayer(int id, int level);
}
