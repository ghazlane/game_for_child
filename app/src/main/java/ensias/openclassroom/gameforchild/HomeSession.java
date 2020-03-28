package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ensias.openclassroom.gameforchild.beans.Session;

public class HomeSession extends AppCompatActivity {
    private TextView messageWelcome ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_session);
        messageWelcome = findViewById(R.id.messageWelcome);
        messageWelcome.setText("Welcome "+ Session.getPlayer().getNom());
    }
    
}
