package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ensias.openclassroom.gameforchild.beans.Session;

public class HomeSession extends AppCompatActivity {
    private TextView messageWelcome ;
    private LinearLayout choix1;
    private LinearLayout choix2;
    private LinearLayout choix3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_session);
        messageWelcome = findViewById(R.id.messageWelcome);
        messageWelcome.setText("Welcome "+ Session.getPlayer().getNom());
        choix1 = findViewById(R.id.choix1);
        choix2 = findViewById(R.id.choix2);
        choix3 = findViewById(R.id.choix3);
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("************************************ On click");
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("************************************ choix2");
            }
        });
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("************************************ choix3");
            }
        });
    }

}
