package com.example.indurirushyendra.movie_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indurirushyendra on 13/03/16.
 */
public class MovieAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public MovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{
        ImageView poster;
        TextView title;
        TextView rate;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
         return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;

        if(row == null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout,parent,false);
            handler = new DataHandler();
            handler.poster = (ImageView) row.findViewById(R.id.movie_poster);
            handler.title = (TextView) row.findViewById(R.id.movie_title);
            handler.rate = (TextView) row.findViewById(R.id.movie_rating);
            row.setTag(handler);

        }

        else {
            handler = (DataHandler) row.getTag();
        }

        MovieDataProvider provider = (MovieDataProvider) this.getItem(position);

        handler.poster.setImageResource(provider.getMovie_poster_resource());
        handler.title.setText(provider.getMovie_tite());
        handler.rate.setText(provider.getMovie_rating());

        return row;
    }
}
