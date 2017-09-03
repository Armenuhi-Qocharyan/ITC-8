package com.instigatemobile.imessenger.profile;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.instigatemobile.imessenger.R;
import java.util.List;


public class RVAdapter extends RecyclerView.Adapter <RVAdapter.ProfileViewHolder> {
    List<ProfileContent> profileContent;


    public static class ProfileViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView profileElement;
        TextView count;
        ImageView elementimage;

        ProfileViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            profileElement = (TextView)itemView.findViewById(R.id.element);
            count = (TextView)itemView.findViewById(R.id.count);
            elementimage = (ImageView)itemView.findViewById(R.id.elementImage);
        }
    }

    RVAdapter(List<ProfileContent> persons){
        this.profileContent = persons;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_content_item, parent, false);
        ProfileViewHolder pvh = new ProfileViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder personViewHolder, int i) {
        personViewHolder.profileElement.setText(profileContent.get(i).getElementName());
        personViewHolder.count.setText(profileContent.get(i).getCount() + "");
        personViewHolder.elementimage.setImageResource(profileContent.get(i).getImagePath());
    }

    @Override
    public int getItemCount() {
        return this.profileContent.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
