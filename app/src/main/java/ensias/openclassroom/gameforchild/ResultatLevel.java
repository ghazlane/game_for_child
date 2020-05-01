package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultatLevel extends AppCompatActivity {
    TextView score ;
    ImageView suivant_list_level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_level);
        score = findViewById(R.id.score_level);
        score.setText(String.valueOf(QuestionActivity.getScore_level())+"/100");
        suivant_list_level = findViewById(R.id.suivant_list_level);
        suivant_list_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionActivity.setScore_level(0);
                Intent intent = new Intent(v.getContext(), ListLevel.class);
                startActivity(intent);
            }
        });

    }
}
