package com.example.cartoonapi.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cartoonapi.R;

import java.util.ArrayList;

public class CharAdapter extends RecyclerView.Adapter<CharAdapter.CharHolder> {
private ArrayList<DataModel> dataModels;

    public CharAdapter(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public CharHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartoon_item,parent,false);
        return new CharHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharHolder holder, int position) {
   holder.bind(dataModels.get(position));
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class CharHolder extends RecyclerView.ViewHolder{
        ImageView char_image;
        TextView char_name,char_status,char_gender,char_species;
        public CharHolder(@NonNull View itemView) {
            super(itemView);
            char_image=itemView.findViewById(R.id.charimg);
            char_name=itemView.findViewById(R.id.name);
            char_status=itemView.findViewById(R.id.status);
            char_gender=itemView.findViewById(R.id.gender);
            char_species=itemView.findViewById(R.id.species);
        }

        public void bind(DataModel dataModel) {
            char_name.setText("Name:"+ dataModel.getName());
            char_status.setText("Status:"+dataModel.getStatus());
            char_gender.setText("Gender:"+dataModel.getGender());
            char_species.setText("species:"+dataModel.getSpecies());
            //to load image
            Glide
                    .with(itemView.getContext())
                    .load(dataModel.getImage())
                    .centerCrop()
                    .into(char_image);
        }
    }

}
