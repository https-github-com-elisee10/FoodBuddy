package com.example.foodbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemAdapter.ViewHolder>{

    Context context;
    List<SearchItem> searchItems;

    public SearchItemAdapter(Context context, List<SearchItem> searchItems) {
        this.context = context;
        this.searchItems = searchItems;
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
        View searchItemView = LayoutInflater.from(context).inflate(R.layout.searchitem_layout, parent, false);


        //we return
        return new ViewHolder(searchItemView);
    }

    //populating data into the view with the viewHolder
    //It will take the position and insert that into view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchItem searchItem = searchItems.get(position);
        holder.bind(searchItem);


    }

    //Return the size of the movie list
    @Override
    public int getItemCount() {
        return searchItems.size();
    }

    //first viewHolder class extends the recyclerView.ViewHolder

    public class ViewHolder extends RecyclerView.ViewHolder{

        //declaring the view types
        ImageView ivSearchImage;
        TextView tvSearchTitle;
        TextView tvSearchTime;
        RelativeLayout searchContainer;

        //constructor to receive the each items
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //fetching the views by id

            tvSearchTitle = itemView.findViewById(R.id.tvSearchTitle);
            tvSearchTime= itemView.findViewById(R.id.tvSearchTime);
            ivSearchImage = itemView.findViewById(R.id.ivSearchImage);
            searchContainer = itemView.findViewById(R.id.searchContainer);



        }

        public void bind(final SearchItem searchItem) {


            tvSearchTitle.setText(searchItem.getTitle());

            //change the int to string for time

            String time = String.valueOf(searchItem.getTime());
            tvSearchTime.setText(time);



            String imageItemUrl = searchItem.getimagePath();




            Glide.with(context).load(imageItemUrl).into(ivSearchImage);


            searchContainer.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, DetailTrendingActivity.class);
                    intent.putExtra("id", Integer.toString(searchItem.getId()));
                    context.startActivity(intent);
                }
            });



        }
    }
}
