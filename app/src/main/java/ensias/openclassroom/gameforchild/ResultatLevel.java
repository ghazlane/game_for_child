package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultatLevel extends AppCompatActivity {
    TextView score ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_level);
        score = findViewById(R.id.score_level);
        score.setText(QuestionActivity.getScore_level());
    }
}
