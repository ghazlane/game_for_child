package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ensias.openclassroom.gameforchild.beans.Levels;

public class QuestionActivity extends AppCompatActivity {

    ImageView image ;
    Button choixReponse1,choixReponse2,choixReponse3,choixReponse4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        image = findViewById(R.id.imageView);
        choixReponse1 = findViewById(R.id.reponsechoix1);
        choixReponse2 = findViewById(R.id.reponsechoix2);
        choixReponse3 = findViewById(R.id.reponsechoix3);
        choixReponse4 = findViewById(R.id.reponsechoix4);
        Resources res = getResources();
        Drawable drawable = res.getDrawable(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getIdImageDrawable() );
        image.setImageDrawable(drawable);
       choixReponse1.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(0));
        choixReponse2.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(1));
        choixReponse3.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(2));
        choixReponse4.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(3));

        choixReponse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                    choixReponse1.setBackgroundColor(Color.GREEN);
                }else{
                    choixReponse1.setBackgroundColor(Color.RED);
                    if(choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse2.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse3.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse4.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        });

        choixReponse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                    choixReponse2.setBackgroundColor(Color.GREEN);
                }else{
                    choixReponse2.setBackgroundColor(Color.RED);
                    if(choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse1.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse3.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse4.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        });

        choixReponse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                    choixReponse3.setBackgroundColor(Color.GREEN);
                }else{
                    choixReponse3.setBackgroundColor(Color.RED);
                    if(choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse2.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse1.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse4.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        });

        choixReponse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                    choixReponse4.setBackgroundColor(Color.GREEN);
                }else{
                    choixReponse4.setBackgroundColor(Color.RED);
                    if(choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse2.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse3.setBackgroundColor(Color.GREEN);
                    }else if(choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())){
                        choixReponse1.setBackgroundColor(Color.GREEN);
                    }
                }
            }
        });

    }
}
