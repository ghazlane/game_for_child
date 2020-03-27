package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ensias.openclassroom.gameforchild.bd.PlayerDataBase;
import ensias.openclassroom.gameforchild.beans.Player;

public class MainActivity extends AppCompatActivity {
    private TextView signIn ;
    private TextView signUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn = this.findViewById(R.id.sin);
        signUp = this.findViewById(R.id.signup);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.playerDataBase = Room.databaseBuilder(getApplicationContext(), PlayerDataBase.class,
                                "player_bd").allowMainThreadQueries().build() ;
                List<Player> listePlayerDataBase = SignUp.playerDataBase.playerDao().getAllPlayer();
                PlayerAdapter.listPlayer= new ArrayList<>();
              //  PlayerAdapter.listPlayer.add(new Player("mohamme",1, "mohammed0",4 ));
                for(int i = 0; i<listePlayerDataBase.size(); i++) {
                    System.out.println("iteration *****************************************");
                    PlayerAdapter.listPlayer.add(listePlayerDataBase.get(i)) ;
                }
                System.out.println("fin iteration *****************************************");
                Intent intent = new Intent(v.getContext(), ListAccount.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SignUp.class);
                startActivity(intent);
             //   showMapTypeSelectorDialog();
            }
        });
    }
}
