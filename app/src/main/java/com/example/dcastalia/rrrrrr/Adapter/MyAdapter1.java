package com.example.dcastalia.rrrrrr.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dcastalia.rrrrrr.Model.FoodList;
import com.example.dcastalia.rrrrrr.Model.Resturent;
import com.example.dcastalia.rrrrrr.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAZ on 06-Feb-18.
 */

//here we need two things one is adapter and the other one is viewholder
public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {
    private final List<FoodList> foodLists;
    //define a list that will contain Kitchen only by passing the generic of Kitchens class
    private List<FoodList> foodList;
    private Context context;
    //create a variable for the interface
    private OnItemClickListener mListener;
    public static int kid;
    public static String kName;
    private ArrayList<Resturent> arrayList;


    public void setOnItemClickListener(OnItemClickListener listener) {

        mListener = listener;
    }


    public MyAdapter1(List<FoodList> foodLists, Context context) {
        this.foodLists = foodLists;
        this.context = context;
    }
/*this onCreateViewHolder method will be called when the viewholder is created
    that means when beneath viewholder class gives us a instance this method will be called*/

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //at first we will return the viewholder
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_food, parent, false);
        return new ViewHolder(v, mListener);
    }


    @Override
    /*// this method will bind the data to the viewholder . that means it will show the actual data to the recyclerview.
    //inside this we will bind the data to the viewobject(textView/listView/RecycleView) we will define the viewobject in the viewfolder class*/
    public void onBindViewHolder(ViewHolder holder, int position) {

    /*inside this we will get the current object.
        for this we can create the newkitchen list item object*/

        FoodList listItem = foodList.get(position);
        kid = listItem.getKitchenId();
        kName = String.valueOf(listItem.getKitchenName());
        holder.textViewHead.setText(listItem.getKitchenName());
        holder.textViewDesc.setText(listItem.getLocation());
        Picasso.with(context)
                .load(listItem.getImgSrc())
                .into(holder.imageView1);


    }


    @Override
    public int getItemCount() {
        /*we need to return the size of the list items here
*/
        return foodList.size();
    }


    public interface OnItemClickListener {
        //we pass the postion ... what item will be clicked that is being defined by the click
        void OnItemClick(int position);


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        /*   // defining the viewobject*/
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView1;

        //pass the listener  as constructor

        public ViewHolder(View itemView, final OnItemClickListener listener) {

            super(itemView);
          /*  // now with the help of this itemView ViewObject we will get the views from XML*/
            textViewHead = (TextView) itemView.findViewById(R.id.textFoodName);
            textViewDesc = (TextView) itemView.findViewById(R.id.textFoodCat);
            imageView1 = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*now when we click itemView which is our holder , we want to call onItemClick method {in the interface}
                        on our mListener . SO we pass the click in our activity  */

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }

                    }


                }
            });

        }
    }

    /*ublic void setFilter(ArrayList<Resturent> newList) {

        arrayList = new ArrayList<FoodList>();
        arrayList.addAll(newList);
        //we need to refresh theadapter now... and for refreshing.......

        notifyDataSetChanged();


    }*/


}