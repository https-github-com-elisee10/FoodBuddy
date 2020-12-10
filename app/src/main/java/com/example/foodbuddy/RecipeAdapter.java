package com.example.foodbuddy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import org.parceler.Parcels;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//The first thing we want to define is a class, here we have movieAdapter

//The movie Adapter will extend RecyclerView.Adapter as step 1

//Inside the adapter we put the viewHolder class we created, which is movieAdapter.ViewHolder


//This will create 3 methods by itself, oncreateViewholder, onBindViewHolder, getItemCount


//Then we have the ViewHolder class that extends recyclerView.ViewHolder

//So, its adapter and then the
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    Context context;
    List<Recipe> recipes;

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
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
        View recipeView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);


        //we return
        return new ViewHolder(recipeView);
    }

    //populating data into the view with the viewHolder
    //It will take the position and insert that into view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.bind(recipe);


    }

    //Return the size of the movie list
    @Override
    public int getItemCount() {
        return recipes.size();
    }

    //first viewHolder class extends the recyclerView.ViewHolder

    public class ViewHolder extends RecyclerView.ViewHolder{

        //declaring the view types
        ImageView ivTrendingImage;
        TextView tvTrendingTitle;
        TextView tvTrendingTime;
        RelativeLayout trendingcontainer;

        //constructor to receive the each items
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //fetching the views by id

            tvTrendingTitle = itemView.findViewById(R.id.tvTrendingTitle);
            tvTrendingTime= itemView.findViewById(R.id.tvTrendingTime);
            ivTrendingImage = itemView.findViewById(R.id.ivTrendingImage);
            trendingcontainer= itemView.findViewById(R.id.trendingcontainer);



        }

        public void bind(final Recipe recipe) {

            tvTrendingTitle.setText(recipe.getTitle());

            //change the int to string for time

            String time = String.valueOf(recipe.getTime());
            tvTrendingTime.setText(time);

//            String id = String.valueOf(recipe.id);




            String imageItemUrl = recipe.getimagePath();




            Glide.with(context).load(imageItemUrl).into(ivTrendingImage);


            trendingcontainer.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(context, DetailTrendingActivity.class);
                    intent.putExtra("id", Integer.toString(recipe.getId()));
                    context.startActivity(intent);

//                    Log.i("Message", "recipe " + context);
//
//                    Intent i = new Intent(context, DetailTrendingActivity.class);
////                    Toast.makeText(context, recipe.getId(), Toast.LENGTH_SHORT).show();
////                    i.putExtra("recipe", Parcels.wrap(recipe));
//                    context.startActivity(i);
                }
            });



        }
    }
}
