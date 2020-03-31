package ensias.openclassroom.gameforchild.beans;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Levels extends AppCompatActivity {

    private static ArrayList<Level> listLevel ;
    private static int numLevels ;
    private static int numQuestion ;

    public Levels() {
    }

    public static ArrayList<Level> getListLevel() {
        return listLevel;
    }

    public static void setListLevel(ArrayList<Level> listLevel) {
        Levels.listLevel = listLevel;
    }

    public static int getNumLevels() {
        return numLevels;
    }

    public static void setNumLevels(int numLevels) {
        Levels.numLevels = numLevels;
    }

    public static int getNumQuestion() {
        return numQuestion;
    }

    public static void setNumQuestion(int numQuestion) {
        Levels.numQuestion = numQuestion;
    }
}
