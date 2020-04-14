package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureCamera extends AppCompatActivity {

    private ImageView photoCamera;
    public static Bitmap PICTURE_BITMAP ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_camera);
        photoCamera = findViewById(R.id.imagePicture);
        photoCamera.setImageResource(R.drawable.level1_ballon);

        photoCamera.setImageBitmap(PICTURE_BITMAP);
    }
}
