package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import ensias.openclassroom.gameforchild.beans.Level;
import ensias.openclassroom.gameforchild.beans.Levels;
import ensias.openclassroom.gameforchild.beans.Question;
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
            final int finalI = i;
            listeImageView.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Levels.setNumLevels(finalI +1);
                    Levels.setNumQuestion(1);
                    Intent intent = new Intent(v.getContext(), QuestionActivity.class);
                    startActivity(intent);
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
        // level 1
        Question question1 = new Question((int) R.drawable.level1_ballon,"Ball",new ArrayList() {{ add("Ball"); add("Netbook"); add("Clock"); add("Sun"); }});
        Question question2 = new Question((int) R.drawable.level1_cahier,"Netbook",new ArrayList() {{ add("Bike"); add("Netbook"); add("cat"); add("Sun"); }});
        Question question3 = new Question((int) R.drawable.level1_chat,"Cat",new ArrayList() {{ add("Cat"); add("Netbook"); add("Clock"); add("Bike"); }});
        Question question4 = new Question((int) R.drawable.level1_chien,"Dog",new ArrayList() {{ add("Bike"); add("Netbook"); add("Dog"); add("Sun"); }});
        Question question5 = new Question((int) R.drawable.level1_couleur_rouge,"Color red",new ArrayList() {{ add("Color blue"); add("Color yellow"); add("Color green"); add("Sun"); }});
        Question question6 = new Question((int) R.drawable.level1_horloge,"Clock",new ArrayList() {{ add("Bike"); add("Netbook"); add("cat"); add("Clock"); }});
        Question question7 = new Question((int) R.drawable.level1_soliel,"Sun",new ArrayList() {{ add("Pen"); add("Clock"); add("Sun"); add("Bike"); }});
        Question question8 = new Question((int) R.drawable.level1_stylo,"Pen",new ArrayList() {{ add("Pen"); add("Netbook"); add("Dog"); add("Sun"); }});
        Question question9 = new Question((int) R.drawable.level1_velo,"Bike",new ArrayList() {{ add("Ball"); add("Bike"); add("Clock"); add("Sun"); }});
        Question question10 = new Question((int) R.drawable.level1_cahier,"Car",new ArrayList() {{ add("Cat"); add("Netbook"); add("Car"); add("Sun"); }});
        ArrayList<Question> listeQuestion = new ArrayList<>();
        listeQuestion.add(question1);
        listeQuestion.add(question2);
        listeQuestion.add(question3);
        listeQuestion.add(question4);
        listeQuestion.add(question5);
        listeQuestion.add(question6);
        listeQuestion.add(question7);
        listeQuestion.add(question8);
        listeQuestion.add(question9);
        listeQuestion.add(question10);
        ArrayList<Level> listeLevel = new ArrayList<>();
        listeLevel.add(new Level(listeQuestion));
        Levels.setListLevel(listeLevel);


    }

}
