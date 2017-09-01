package com.itc.iblog.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itc.iblog.R;
import com.itc.iblog.models.DataModel;

import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.MyViewHolder> {

    private List<DataModel> cardList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.info_text);
            image = (ImageView) view.findViewById(R.id.post_image);
        }
    }


    public listAdapter(List<DataModel> cardList) {
        this.cardList = cardList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataModel post = cardList.get(position);
        holder.title.setText(post.getName());
        holder.image.setImageResource(post.getImage());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


}
