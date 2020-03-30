package ensias.openclassroom.gameforchild;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ensias.openclassroom.gameforchild.bd.PlayerDataBase;
import ensias.openclassroom.gameforchild.beans.Player;

public class SignUp extends AppCompatActivity  {
    private static final int RESULT_LOAD_IMAGE = 1;
    private ImageView imageUpload ;
    private Button buttonUploadImage;
    private Button addNewAccount;
    private EditText namekids;
    public static PlayerDataBase playerDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        imageUpload = this.findViewById(R.id.imageUpload);
        buttonUploadImage = this.findViewById(R.id.buttonUploadImage);
        addNewAccount = this.findViewById(R.id.addNewAccount);
        namekids = this.findViewById(R.id.namekids);
        playerDataBase =  Room.databaseBuilder(getApplicationContext(),PlayerDataBase.class,
                "player_bd").allowMainThreadQueries().build() ;
        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE );
                imageUpload.setImageResource(android.R.color.transparent);
            }
        });

        addNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(namekids.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "\n" +
                            "indicate your name", Toast.LENGTH_SHORT).show();
                }
                else{
                    Player player = new Player();
                    player.setDate_creation((new SimpleDateFormat("yyyy/MM/dd")).format(new Date()));
                    player.setNom(namekids.getText().toString());
                    player.setLevel(14);
                    player.setScore(0);
                    //traitement sur image
                    BitmapDrawable drawable = (BitmapDrawable) imageUpload.getDrawable();
                    Bitmap bmap = drawable.getBitmap();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bmap.compress(Bitmap.CompressFormat.PNG,100,bos);
                    byte[] imageOnByte = bos.toByteArray();
                    player.setImage_profil(imageOnByte);
                    //fin traitement image
                    SignUp.playerDataBase =  Room.databaseBuilder(getApplicationContext(),PlayerDataBase.class,
                            "player_bd").allowMainThreadQueries().build() ;
                    SignUp.playerDataBase.playerDao().addPlayer(player);
                    Toast.makeText(getApplicationContext(), "Votre compte a bien été créer"+player.getNom() ,
                            Toast.LENGTH_SHORT).show();
                   //player.setImage_profil();
                }
            }
        });
        buttonUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE );
                imageUpload.setImageResource(android.R.color.transparent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            imageUpload.setImageURI(selectedImage);
        }
    }
}
