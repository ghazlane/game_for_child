package ensias.openclassroom.gameforchild;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ensias.openclassroom.gameforchild.beans.Session;

public class HomeSession extends Activity {
    private TextView messageWelcome;
    private LinearLayout choix1;
    private LinearLayout choix2;
    private LinearLayout choix3;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_session);
        messageWelcome = findViewById(R.id.messageWelcome);
        messageWelcome.setText("Welcome " + Session.getPlayer().getNom());
        choix1 = findViewById(R.id.choix1);
        choix2 = findViewById(R.id.choix2);
        choix3 = findViewById(R.id.choix3);
        choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TraitementChoix1();
            }
        });
        choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TraitementChoix2();
            }

        });
        choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void TraitementChoix1() {
        Intent intent = new Intent(this, ListLevel.class);
        startActivity(intent);
    }

    public void TraitementChoix2() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Intent intent = new Intent(this, PictureCamera.class);
            startActivity(intent);
            PictureCamera.PICTURE_BITMAP = imageBitmap;
            // imageView.setImageBitmap(imageBitmap);
            // imageView.setImageResource(R.drawable.level1_ballon);
            // imageView.setImageBitmap(imageBitmap);
        }
    }


}
