package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ensias.openclassroom.gameforchild.bd.PlayerDataBase;
import ensias.openclassroom.gameforchild.beans.Level;
import ensias.openclassroom.gameforchild.beans.Levels;
import ensias.openclassroom.gameforchild.beans.Player;
import ensias.openclassroom.gameforchild.beans.Session;

public class QuestionActivity extends AppCompatActivity {

    ImageView image, suivant;
    Button choixReponse1, choixReponse2, choixReponse3, choixReponse4;
    public static int score_level = 0;
    public boolean response_person;
    public static PlayerDataBase playerDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        suivant = findViewById(R.id.suivant);
        suivant.setImageDrawable(null);
        image = findViewById(R.id.imageView);
        choixReponse1 = findViewById(R.id.reponsechoix1);
        choixReponse2 = findViewById(R.id.reponsechoix2);
        choixReponse3 = findViewById(R.id.reponsechoix3);
        choixReponse4 = findViewById(R.id.reponsechoix4);
        Drawable drawable = getResources().getDrawable(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getIdImageDrawable());
        image.setImageDrawable(drawable);
        choixReponse1.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(0));
        choixReponse2.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(1));
        choixReponse3.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(2));
        choixReponse4.setText(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getListChoix().get(3));
        response_person = false;
        choixReponse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (response_person == false) {
                    response_person = true;
                    if (choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                        choixReponse1.setBackgroundColor(Color.parseColor("#00B83B"));
                        augmenterScore();
                    } else {
                        choixReponse1.setBackgroundColor(Color.parseColor("#e11a1a"));
                        if (choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse2.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse3.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse4.setBackgroundColor(Color.parseColor("#00B83B"));
                        }
                    }
                    lancerButtonNext();
                }
            }
        });

        choixReponse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (response_person == false) {
                    response_person = true;
                    if (choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                        choixReponse2.setBackgroundColor(Color.parseColor("#00B83B"));
                        augmenterScore();
                    } else {
                        choixReponse2.setBackgroundColor(Color.parseColor("#e11a1a"));
                        if (choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse1.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse3.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse4.setBackgroundColor(Color.parseColor("#00B83B"));
                        }
                    }
                    lancerButtonNext();
                }
            }
        });

        choixReponse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (response_person == false) {
                    response_person = true;
                    if (choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                        choixReponse3.setBackgroundColor(Color.parseColor("#00B83B"));
                        augmenterScore();
                    } else {
                        choixReponse3.setBackgroundColor(Color.parseColor("#e11a1a"));
                        if (choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse2.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse1.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse4.setBackgroundColor(Color.parseColor("#00B83B"));
                        }
                    }
                    lancerButtonNext();
                }
            }
        });

        choixReponse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (response_person == false) {
                    response_person = true;
                    if (choixReponse4.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                        choixReponse4.setBackgroundColor(Color.parseColor("#00B83B"));
                        augmenterScore();
                    } else {
                        choixReponse4.setBackgroundColor(Color.parseColor("#e11a1a"));
                        if (choixReponse2.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse2.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse3.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse3.setBackgroundColor(Color.parseColor("#00B83B"));
                        } else if (choixReponse1.getText().equals(Levels.getListLevel().get(Levels.getNumLevels()).getListQuestion().get(Levels.getNumQuestion()).getReponse())) {
                            choixReponse1.setBackgroundColor(Color.parseColor("#00B83B"));
                        }
                    }
                    lancerButtonNext();
                }
            }
        });

    }

    public void lancerButtonNext() {
        if (Levels.getNumQuestion() < 9) {
            suivant.setImageResource(R.drawable.next);
            Levels.setNumQuestion(Levels.getNumQuestion() + 1);
            suivant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), QuestionActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            suivant.setImageResource(R.drawable.myscore);
            suivant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ResultatLevel.class);
                    startActivity(intent);
                }
            });
            if (QuestionActivity.score_level >= 60) {
                QuestionActivity.playerDataBase = Room.databaseBuilder(getApplicationContext(), PlayerDataBase.class,
                        "player_bd").allowMainThreadQueries().build();
                if ((Levels.getNumLevels()) == (Session.getPlayer().getLevel() - 1)) {
                    QuestionActivity.playerDataBase.playerDao().updatePlayer(Session.getPlayer().getId(), Session.getPlayer().getLevel() + 1);
                    Session.getPlayer().setLevel(Session.getPlayer().getLevel() + 1);
                }
            }
        }
    }

    public void augmenterScore() {
        score_level += 10;
    }

    public static int getScore_level() {
        return score_level;
    }

    public static void setScore_level(int score_level) {
        QuestionActivity.score_level = score_level;
    }
}
