package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

import ensias.openclassroom.gameforchild.beans.Session;

public class ListLevel extends AppCompatActivity {

    private ArrayList<ImageView> listeImageView = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_level);
       // remplissageTableau() ;

        for(int i = 1 ; i< 21 ; i++){
            String nameLevel = "level_"+i;
            int resID = getResources().getIdentifier(nameLevel, "id", getPackageName());
            listeImageView.add((ImageView) findViewById(resID));
        }

        for(int i = 1 ; i<Session.getPlayer().getLevel() ; i++){
            
        }
    }

}
