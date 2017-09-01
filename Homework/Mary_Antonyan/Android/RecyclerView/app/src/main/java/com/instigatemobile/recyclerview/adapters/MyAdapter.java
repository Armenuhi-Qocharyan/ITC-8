package com.instigatemobile.recyclerview.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.instigatemobile.recyclerview.R;
import com.instigatemobile.recyclerview.models.Film;

import java.util.List;

/**
 * Created by student on 9/1/17.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.FilmViewHolder>{
    private List<Film> films;

    public MyAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        FilmViewHolder fvh = new FilmViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
        holder.title.setText(films.get(position).getTitle());
        holder.description.setText(films.get(position).getDescription());
        holder.image.setImageView(films.get(position).getimage());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView description;
        ImageView image;
        FilmViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView)itemView.findViewById(R.id.card_image);
        }
    }
}
