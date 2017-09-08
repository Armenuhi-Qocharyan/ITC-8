package com.instigatemobile.imessenger.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.instigatemobile.imessenger.R;
import com.instigatemobile.imessenger.activities.MainActivity;
import com.instigatemobile.imessenger.activities.MessangerActivity;
import com.instigatemobile.imessenger.models.Contacts;

import java.util.ArrayList;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.PersonViewHolder> {

    ArrayList<Contacts> ContactsArray;
    private Context mContext;

    public ContactsAdapter(ArrayList<Contacts> ContactsArray) {
        this.ContactsArray = ContactsArray;
    }

    public ContactsAdapter(ArrayList<Contacts> ContactsArray, Context context) {
        this.ContactsArray = ContactsArray;
        this.mContext = context;
    }

    public ContactsAdapter(Context context) {
        initializePerson();
        mContext = context;
    }

    public ContactsAdapter() {
        throw new UnknownError("Don't use me");
    }

    private void initializePerson() {
        ContactsArray = new ArrayList<>();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personNameTextView.setText(ContactsArray.get(position).getUser());
        holder.ContactsurnameTextView.setText(ContactsArray.get(position).getLastMessage());
        holder.setIcon(ContactsArray.get(position).getImage(),mContext);
    }

    @Override
    public int getItemCount() {
        return this.ContactsArray.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView personImageView;
        TextView personNameTextView;
        TextView ContactsurnameTextView;
        CardView cardView;

        public PersonViewHolder(final View itemView) {
            super(itemView);
            this.personNameTextView = (TextView) itemView.findViewById(R.id.person_name_text_view);
            this.ContactsurnameTextView = (TextView) itemView.findViewById(R.id.person_surname_text_view);
            this.personImageView = (ImageView) itemView.findViewById(R.id.person_image_view);
            this.cardView = cardView;
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int p = getLayoutPosition();
                    System.out.println("LongClick: " + p);
                    AlertDialog alertDialog = new AlertDialog.Builder(itemView.getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert messanger to be shown" + p);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    return true;
                }
            });
            itemView.setOnClickListener( new ContactClickListener());
        }

        public PersonViewHolder(View itemView, ImageView personImageView, TextView personNameTextView, TextView ContactsurnameTextView, CardView cardView) {
            super(itemView);
          //  this.personImageView = personImageView;
            this.personNameTextView = personNameTextView;
            this.ContactsurnameTextView = ContactsurnameTextView;
            this.cardView = cardView;
        }

        public void setIcon(String url, Context context) {
           // GlideUtil.loadProfileIcon(url, personImageView);//
            Glide.with(context).load(url).into(personImageView);
        }
    }

    class ContactClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent redirect = new Intent(mContext, MessangerActivity.class);
            mContext.startActivity(redirect);
        }
    }
}
