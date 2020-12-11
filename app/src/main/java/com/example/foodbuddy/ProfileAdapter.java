package com.example.foodbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//So, its adapter and then the
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>{

    Context context;
    List<Profile> profileRecipes;


    public ProfileAdapter(Context context, List<Profile> profileRecipes) {
        this.context = context;
        this.profileRecipes = profileRecipes;
    }

    //This method creates the layout for the movie data
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //step 1, LayoutInflater.
        //step 2, from (context)- context comes from Context context
        //step 3, .Inflate()
        //step 4, inside inflate, R.layout.item_layout- comes from item_layout we created to display each movie with title and description
        //step 5, other parameter is parent
        //step 6, set false


        //we want to display it to view, so we create View movieView. movieView contains content to show the view
        View profileView = LayoutInflater.from(context).inflate(R.layout.profile_layout, parent, false);


        //we return
        return new ViewHolder(profileView);
    }

    //populating data into the view with the viewHolder
    //It will take the position and insert that into view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Profile profileRecipe = profileRecipes.get(position);
        holder.bind(profileRecipe);


    }

    //Return the size of the movie list
    @Override
    public int getItemCount() {
        return profileRecipes.size();
    }

    //first viewHolder class extends the recyclerView.ViewHolder

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //declaring the view types
        ImageView ivprofileImage;
        TextView tvprofileTitle;
        TextView tvprofileInstruction;

        RelativeLayout profilecontainer;

        //constructor to receive the each items
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //fetching the views by id

            tvprofileTitle = itemView.findViewById(R.id.tvprofileTitle);
            ivprofileImage = itemView.findViewById(R.id.ivprofileImage);
            tvprofileInstruction = itemView.findViewById(R.id.tvprofileInstruction);
            profilecontainer= itemView.findViewById(R.id.trendingcontainer);



        }

        public void bind(final Profile profileRecipe) {

            tvprofileTitle.setText(profileRecipe.getProfileTitle());

            tvprofileInstruction.setText(profileRecipe.getprofileInstruction());





//            ivprofileImage.setText(profileRecipe).getProfileInstruction();

//            String id = String.valueOf(recipe.id);



//
//            String imageItemUrl = recipe.getimagePath();
//
//
//
//
//            Glide.with(context).load(imageItemUrl).into(ivTrendingImage);


//            trendingcontainer.setOnClickListener(new View.OnClickListener(){
//
//                @Override
//                public void onClick(View v) {
//
//
//                    Intent intent = new Intent(context, DetailTrendingActivity.class);
//                    intent.putExtra("id", Integer.toString(recipe.getId()));
//                    context.startActivity(intent);







//                    Log.i("Message", "recipe " + context);
//
//                    Intent i = new Intent(context, DetailTrendingActivity.class);
////                    Toast.makeText(context, recipe.getId(), Toast.LENGTH_SHORT).show();
////                    i.putExtra("recipe", Parcels.wrap(recipe));
//                    context.startActivity(i);
//                }
//            });



        }
    }
}
