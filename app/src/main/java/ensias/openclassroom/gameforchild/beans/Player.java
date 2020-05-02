package ensias.openclassroom.gameforchild.beans;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Base64;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player")
public class Player {
    //autoGenerate
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @ColumnInfo(name = "name_account")
    private String nom;
    @ColumnInfo(name = "level")
    private int level;
    @ColumnInfo(name = "date_creation")
    private String date_creation;
    @ColumnInfo(name = "score")
    private int score;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image_profil;


    public Player() {
        super();
    }

    public Player(String nom, int level, String date_creation, int score) {
        this.nom = nom;
        this.level = level;
        this.date_creation = date_creation;
        this.score = score;
    }

    public Player(int id, String nom, int level, String date_creation, int score, byte[] image_profil) {
        this.id = id;
        this.nom = nom;
        this.level = level;
        this.date_creation = date_creation;
        this.score = score;
        this.image_profil = image_profil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public byte[] getImage_profil() {
        return image_profil;
    }

    public void setImage_profil(byte[] image_profil) {
        this.image_profil = image_profil;
    }
}
