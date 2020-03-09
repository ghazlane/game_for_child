package ensias.openclassroom.gameforchild;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class SignUp extends AppCompatActivity  {
    private static final int RESULT_LOAD_IMAGE = 1;
    private ImageView imageUpload ;
    private Button buttonUploadImage;
    private Button addNewAccount;
    private EditText namekids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageUpload = this.findViewById(R.id.imageUpload);
        buttonUploadImage = this.findViewById(R.id.buttonUploadImage);
        addNewAccount = this.findViewById(R.id.addNewAccount);
        namekids = this.findViewById(R.id.namekids);

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
