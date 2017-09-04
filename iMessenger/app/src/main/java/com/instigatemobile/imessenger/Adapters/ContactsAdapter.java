package com.instigatemobile.imessenger.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.instigatemobile.imessenger.Contacts.ContactsFragment;
import com.instigatemobile.imessenger.Models.Contacts;
import com.instigatemobile.imessenger.R;

import java.util.ArrayList;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.PersonViewHolder> {

    ArrayList<Contacts> ContactsArray;
    private Context mContext;

    public ContactsAdapter(ArrayList<Contacts> ContactsArray) {
        this.ContactsArray = ContactsArray;
    }

    public ContactsAdapter(ArrayList<Contacts> ContactsArray, Context mContext) {
        this.ContactsArray = ContactsArray;
        this.mContext = mContext;
    }

    private void initializePerson() {
        ContactsArray = new ArrayList<>();
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
    }

    public ContactsAdapter() {
        initializePerson();
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
        holder.personImageView.setImageResource(ContactsArray.get(position).getImage());

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
                    int p=getLayoutPosition();
                    System.out.println("LongClick: "+p);


                  //  Toast.makeText(itemView.getContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();


                    AlertDialog alertDialog = new AlertDialog.Builder(itemView.getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown" + p);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    return true;// returning true instead of false, works for me
                }
            });
        }

        public PersonViewHolder(View itemView, ImageView personImageView, TextView personNameTextView, TextView ContactsurnameTextView, CardView cardView) {
            super(itemView);
            this.personImageView = personImageView;
            this.personNameTextView = personNameTextView;
            this.ContactsurnameTextView = ContactsurnameTextView;
            this.cardView = cardView;
        }
    }
}
