package ensias.openclassroom.gameforchild;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import ensias.openclassroom.gameforchild.bd.PlayerDataBase;
import ensias.openclassroom.gameforchild.beans.Levels;
import ensias.openclassroom.gameforchild.beans.Session;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PictureCamera extends AppCompatActivity {

    private ImageView photoCamera;
    public static Bitmap PICTURE_BITMAP;
    public TextView answer3, answer4, answer2, answer1;
    public boolean response_person;
    public String reponse_string;
    public Button suivant2 ;
    public final ArrayList<String> liste_choix = new ArrayList() {{
        add("Glass");
        add("Shirt");
        add("window");
        add("Bike");
        add("Pen");
        add("Hotem");
        add("Silver");
        add("window");
        add("Computer");
        add("Castle");
        add("Egg");
        add("Window");
        add("Table");
        add("Comb");
        add("Glass");
        add("Bike");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_camera);
        photoCamera = findViewById(R.id.imagePicture);
        photoCamera.setImageResource(R.drawable.level1_ballon);
        answer3 = findViewById(R.id.reponsechoix3_picture);
        answer2 = findViewById(R.id.reponsechoix2_picture);
        answer1 = findViewById(R.id.reponsechoix1_picture);
        answer4 = findViewById(R.id.reponsechoix4_picture);
        suivant2 = findViewById(R.id.suivant2);
        photoCamera.setImageBitmap(PICTURE_BITMAP);
        answer3.setText("test");
        connectServer();
    }

    void connectServer() {

        String postUrl = "http://192.168.1.3:5000/";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        // Read BitMap by file path
        PICTURE_BITMAP.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        RequestBody postBodyImage = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", "androidFlask.jpg", RequestBody.create(MediaType.parse("image/*jpg"), byteArray))
                .build();

        answer3.setText("Please wait ...");
        answer1.setText("Please wait ...");
        answer2.setText("Please wait ...");
        answer4.setText("Please wait ...");
        postRequest(postUrl, postBodyImage);
    }

    void postRequest(String postUrl, RequestBody postBody) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(postUrl)
                .post(postBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Cancel the post on failure.
                call.cancel();

                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        answer3.setText("Failed to Connect to Server");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    int correctResponse;

                    @Override
                    public void run() {
                        try {
                            int lower = 1;
                            int higher = 15;
                            int secondheigher = 3;
                            int random = (int) (Math.random() * (secondheigher - lower)) + lower;
                            System.out.println("******************* *****************I am here");
                            reponse_string = response.body().string();
                            if (random == 0) {
                                answer3.setText(reponse_string);
                                answer4.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer2.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer1.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                correctResponse = 3;
                            } else if (random == 1) {
                                answer4.setText(reponse_string);
                                answer3.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer2.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer1.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                correctResponse = 4;
                            } else if (random == 2) {
                                answer2.setText(reponse_string);
                                answer4.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer3.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer1.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                correctResponse = 2;
                            } else{
                                answer1.setText(reponse_string);
                                answer4.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer2.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                answer3.setText(liste_choix.get((int) (Math.random() * (higher - lower)) + lower));
                                correctResponse = 1;
                            }

                            response_person = false;
                            answer1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (response_person == false) {
                                        response_person = true;
                                        if (answer1.getText().equals(reponse_string)) {
                                            answer1.setBackgroundColor(Color.parseColor("#00B83B"));
                                        } else {
                                            answer1.setBackgroundColor(Color.parseColor("#e11a1a"));
                                            if (answer2.getText().equals(reponse_string)) {
                                                answer2.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer3.getText().equals(reponse_string)) {
                                                answer3.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer4.getText().equals(reponse_string)) {
                                                answer4.setBackgroundColor(Color.parseColor("#00B83B"));
                                            }
                                        }
                                        lancerButtonNext();
                                    }
                                }
                            });


                            answer2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (response_person == false) {
                                        response_person = true;
                                        if (answer2.getText().equals(reponse_string)) {
                                            answer2.setBackgroundColor(Color.parseColor("#00B83B"));
                                        } else {
                                            answer2.setBackgroundColor(Color.parseColor("#e11a1a"));
                                            if (answer1.getText().equals(reponse_string)) {
                                                answer1.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer3.getText().equals(reponse_string)) {
                                                answer3.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer4.getText().equals(reponse_string)) {
                                                answer4.setBackgroundColor(Color.parseColor("#00B83B"));
                                            }
                                        }
                                        lancerButtonNext();
                                    }
                                }
                            });

                            answer3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (response_person == false) {
                                        response_person = true;
                                        if (answer3.getText().equals(reponse_string)) {
                                            answer3.setBackgroundColor(Color.parseColor("#00B83B"));
                                        } else {
                                            answer3.setBackgroundColor(Color.parseColor("#e11a1a"));
                                            if (answer2.getText().equals(reponse_string)) {
                                                answer2.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer4.getText().equals(reponse_string)) {
                                                answer4.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer4.getText().equals(reponse_string)) {
                                                answer4.setBackgroundColor(Color.parseColor("#00B83B"));
                                            }
                                        }
                                        lancerButtonNext();
                                    }
                                }
                            });

                            answer4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (response_person == false) {
                                        response_person = true;
                                        if (answer4.getText().equals(reponse_string)) {
                                            answer4.setBackgroundColor(Color.parseColor("#00B83B"));
                                        } else {
                                            answer1.setBackgroundColor(Color.parseColor("#e11a1a"));
                                            if (answer2.getText().equals(reponse_string)) {
                                                answer2.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer3.getText().equals(reponse_string)) {
                                                answer3.setBackgroundColor(Color.parseColor("#00B83B"));
                                            } else if (answer1.getText().equals(reponse_string)) {
                                                answer1.setBackgroundColor(Color.parseColor("#00B83B"));
                                            }
                                        }
                                        lancerButtonNext();
                                    }
                                }
                            });



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }
        });
    }

    public void lancerButtonNext() {
        suivant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeSession.class);
                startActivity(intent);
            }
        });
    }

}
