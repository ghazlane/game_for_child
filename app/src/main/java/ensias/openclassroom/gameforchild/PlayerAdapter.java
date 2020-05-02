package ensias.openclassroom.gameforchild;


import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ensias.openclassroom.gameforchild.beans.Player;
import ensias.openclassroom.gameforchild.beans.Session;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {
    public static ArrayList<Player> listPlayer = new ArrayList();
    public static Context parent2;
    // public static Context parent2 ;

    @Override
    // retournele nb total de cellule que contiendra la liste
    public int getItemCount() {
        return listPlayer.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //pour créer un laouyt depuis un XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        parent2 = parent.getContext();
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Player player = (Player) listPlayer.get(position);
        holder.display(player);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private ImageView profil;
        private Player currentPlayer;

        public MyViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            profil = itemView.findViewById(R.id.profil);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //open session
                    Session.setPlayer(currentPlayer);
                    Intent intent = new Intent(parent2, HomeSession.class);
                    parent2.startActivity(intent);
                }
            });

        }

        public void display(Player player) {
            currentPlayer = player;
            name.setText(player.getNom());
            Bitmap bitmap = BitmapFactory.decodeByteArray(player.getImage_profil(), 0, player.getImage_profil().length);
            profil.setImageBitmap(bitmap.createScaledBitmap(bitmap, 20, 20, true));
            //   bitmap.createScaledBitmap(bitmap,(int)(bitmap.getWidth()*0.5), (int)(bitmap.getHeight()*0.5), true);
            //   profil.setImageBitmap(bitmap);
        }
    }


}