package ensias.openclassroom.gameforchild.beans;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Levels extends AppCompatActivity {

    private static ArrayList<Level> listLevel ;

    public Levels() {
    }

    public static ArrayList<Level> getListLevel() {
        return listLevel;
    }

    public static void setListLevel(ArrayList<Level> listLevel) {
        Levels.listLevel = listLevel;
    }

}
