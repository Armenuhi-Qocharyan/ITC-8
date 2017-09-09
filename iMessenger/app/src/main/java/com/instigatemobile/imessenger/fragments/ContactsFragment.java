package com.instigatemobile.imessenger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.instigatemobile.imessenger.R;

public class ContactsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        database.child(user.getUid()).child("contactsList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//TODO
//                ArrayList<Contacts> list = new ArrayList<Contacts>();
//                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
//                    String name = (String) messageSnapshot.child("user").getValue();
//                    String message = (String) messageSnapshot.child("lastMessage").getValue();
//                    String image = (String) messageSnapshot.child("image").getValue();
//                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                    recyclerView.setAdapter(new ContactsAdapter(list, getActivity()));
//                    list.add(new Contacts(name, message, image));
//                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}