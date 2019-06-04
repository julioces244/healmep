package com.tecsup.apaza.healmepaciente.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tecsup.apaza.healmepaciente.ApiService;
import com.tecsup.apaza.healmepaciente.Class.Office;
import com.tecsup.apaza.healmepaciente.Class.User;
import com.tecsup.apaza.healmepaciente.R;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> users;

    public UsersAdapter(){
        this.users = new ArrayList<>();
    }

    public void setDoctos(List<User> doctors){
        this.users = doctors;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView fotoImage;
        public TextView nameText;
        public TextView lastnameText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = (ImageView) itemView.findViewById(R.id.foto_image);
            nameText = (TextView) itemView.findViewById(R.id.name_text);
            lastnameText = (TextView) itemView.findViewById(R.id.lastname_text);
        }
    }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UsersAdapter.ViewHolder viewHolder, int position) {

        User user = this.users.get(position);

        viewHolder.nameText.setText(user.getName());
        viewHolder.lastnameText.setText(user.getLastname());

        //String url = ApiService.API_BASE_URL + "/images/" + user.getImagen();
        //Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }


}
