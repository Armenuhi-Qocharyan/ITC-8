package com.itc.iblog.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itc.iblog.R;
import com.itc.iblog.models.UsersModel;

import java.util.ArrayList;


public class AboutUsAdapter extends RecyclerView.Adapter<AboutUsAdapter.ViewHolder> {
    ArrayList<UsersModel> developers;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.text_view_name);
            imageView = (ImageView) view.findViewById(R.id.user_image);
        }
    }

    public AboutUsAdapter(ArrayList<UsersModel> developers) {
        this.developers = developers;
    }

    @Override
    public AboutUsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.about_us_row, parent, false);

        return new AboutUsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewName.setText(developers.get(position).userName);
        Context context = holder.imageView.getContext();
        int id = context.getResources().getIdentifier(developers.get(position).url, "drawable", context.getPackageName());
        holder.imageView.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

}
