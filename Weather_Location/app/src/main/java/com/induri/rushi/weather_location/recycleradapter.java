package com.induri.rushi.weather_location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sony on 09-03-2016.
 */
public class recycleradapter extends RecyclerView.Adapter<recycleradapter.myviewHolder>{
    private final List<Weather> list;
    LayoutInflater inflater;
    public recycleradapter(Context context,List<Weather> weatherlist){
        this.list=weatherlist;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public myviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.weather_card, parent, false);

        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder( myviewHolder holder, int position) {
        Weather curr=list.get(position);

        holder.maxTemp.setText(curr.maxTemp);
        holder.minTemp.setText(curr.minTemp);
        holder.dayTemp.setText(curr.dayTemp);
        holder.date.setText(curr.date);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void clearData() {
        int size = this.list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.list.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    public class myviewHolder extends RecyclerView.ViewHolder{
        TextView minTemp;
        TextView maxTemp;
        TextView dayTemp;
        TextView date;

        public myviewHolder(View itemView) {
            super(itemView);
            minTemp=(TextView)itemView.findViewById(R.id.mintemp);
            maxTemp=(TextView)itemView.findViewById(R.id.maxtemp);
            dayTemp=(TextView)itemView.findViewById(R.id.daytemp);
            date=(TextView)itemView.findViewById(R.id.date);


        }
    }

}
