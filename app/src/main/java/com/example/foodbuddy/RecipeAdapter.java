package com.example.foodbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<Recipe> recipies;

    public RecipeAdapter(Context context, List<Recipe> recipies) {
        this.context = context;
        this.recipies = recipies;
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
        Recipe recipe = recipies.get(position);
        holder.bind(recipe);


    }

    //Return the size of the movie list
    @Override
    public int getItemCount() {
        return recipies.size();
    }

    //first viewHolder class extends the recyclerView.ViewHolder

    public class ViewHolder extends RecyclerView.ViewHolder {

        //declaring the view types
        ImageView ivImage;
        TextView tvTitle;
        TextView tvOverview;

        //constructor to receive the each items
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //fetching the views by id

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivImage = itemView.findViewById(R.id.ivImage);


        }

        public void bind(Recipe recipe) {

            tvTitle.setText(recipe.getTitle());
            tvOverview.setText(recipe.getOverView());
            String imageUrl = recipe.getImage();;




            Glide.with(context).load(imageUrl).into(ivImage);
        }
    }
}