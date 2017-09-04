package com.instigatemobile.imessenger.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.instigatemobile.imessenger.Models.Persons;
import com.instigatemobile.imessenger.R;

import java.util.ArrayList;


public class PersonAdapter  extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    ArrayList<Persons> personsArray;
    private Context mContext;

    public PersonAdapter(ArrayList<Persons> personsArray) {
        this.personsArray = personsArray;
    }

    public PersonAdapter(ArrayList<Persons> personsArray, Context mContext) {
        this.personsArray = personsArray;
        this.mContext = mContext;
    }

    private void initializePerson(){
        personsArray = new ArrayList<>();
        personsArray.add(new Persons("Aaa", "Aaaaa", R.drawable.avatar));
        personsArray.add(new Persons("Bbb", "Bbbbb", R.drawable.avatar));
        personsArray.add(new Persons("Ccc", "Ccccc", R.drawable.avatar));
        personsArray.add(new Persons("Ddd", "Ddddd", R.drawable.avatar));
        personsArray.add(new Persons("Aaa", "Aaaaa", R.drawable.avatar));
        personsArray.add(new Persons("Bbb", "Bbbbb", R.drawable.avatar));
        personsArray.add(new Persons("Ccc", "Ccccc", R.drawable.avatar));
        personsArray.add(new Persons("Ddd", "Ddddd", R.drawable.avatar));
    }

    public PersonAdapter() {
        initializePerson();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personNameTextView.setText(personsArray.get(position).getPersonName());
        holder.personSurnameTextView.setText(personsArray.get(position).getPersonSurname());
        holder.personImageView.setImageResource(personsArray.get(position).getPersonImage());
    }

    @Override
    public int getItemCount() {
        return this.personsArray.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView personImageView;
        TextView personNameTextView;
        TextView personSurnameTextView;
        CardView cardView;

        public PersonViewHolder(View itemView) {
            super(itemView);
            this.personNameTextView = (TextView) itemView.findViewById(R.id.person_name_text_view);
            this.personSurnameTextView = (TextView) itemView.findViewById(R.id.person_surname_text_view);
            this.personImageView = (ImageView) itemView.findViewById(R.id.person_image_view);
            this.cardView = cardView;
        }

        public PersonViewHolder(View itemView, ImageView personImageView, TextView personNameTextView, TextView personSurnameTextView, CardView cardView) {
            super(itemView);
            this.personImageView = personImageView;
            this.personNameTextView = personNameTextView;
            this.personSurnameTextView = personSurnameTextView;
            this.cardView = cardView;
        }
    }
}
