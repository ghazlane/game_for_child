package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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


        for(int i = 0 ; i<Session.getPlayer().getLevel()-1 ; i++){
            String nameLevel = "sucess_"+(i+1);
            Resources res = getResources();
            int resID = res.getIdentifier(nameLevel , "drawable", getPackageName());
            Drawable drawable = res.getDrawable(resID );
            listeImageView.get(i).setImageDrawable(drawable);
            listeImageView.get(i).getLayoutParams().height = 150 ;
            listeImageView.get(i).getLayoutParams().width = 150 ;
            listeImageView.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            //listeImageView.get(i).getLayoutParams().
            /*
            int resID = getResources().getIdentifier(nameLevel, "id", getPackageName());
            mImageView.setImageResource(getResources().getDrawable());*/
        }

        String nameLevel = "encour_"+(Session.getPlayer().getLevel());
        Resources res = getResources();
        int resID = res.getIdentifier(nameLevel , "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID );
        listeImageView.get(Session.getPlayer().getLevel()-1).setImageDrawable(drawable);

        listeImageView.get(Session.getPlayer().getLevel()-1).getLayoutParams().height = 150 ;
        listeImageView.get(Session.getPlayer().getLevel()-1).getLayoutParams().width = 150 ;

        for(int i = Session.getPlayer().getLevel() ; i< 20; i++){
            listeImageView.get(i).getLayoutParams().height = 150 ;
            listeImageView.get(i).getLayoutParams().width = 150 ;
        }

        initialisationLevel();
    }

    private void initialisationLevel(){
        
    }

}
