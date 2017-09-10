package com.instigatemobile.imessenger.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.instigatemobile.imessenger.models.User;

public class DataBase {
    private static DataBase DB;
    private ProfileCallbackInterface callback;
    private DatabaseReference database;

    private DataBase() {
        database = FirebaseDatabase.getInstance().getReference("users");
    }

    public static DataBase initDataBase() {
        if (DB == null) {
            DB = new DataBase();
        }
        return DB;
    }

    public boolean insertProfile(User profile) {
//TODO
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        database.child(user.getUid()).setValue(profile);
//        Contacts contact = new Contacts(profile.getName(), profile.getEmail(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq-k0_QiFEaZ2RUGq0fIv0_vUL7MefkpPQHxJjRy7CRjBcigZUrg");
//        Map<String, Contacts> contactsList = new HashMap<String, Contacts>();
//        contactsList.put("contact1", contact);
//        database.child(user.getUid()).child("contactsList").setValue(contactsList);
        return true;
    }

    public void changeProfileAvatar(String url) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        database.child(user.getUid()).child("avatar").setValue(url);
    }

    public void changeProfileBackground(String url) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        database.child(user.getUid()).child("background").setValue(url);
    }

    public void getCurrentProfile(ProfileCallbackInterface profileCallback) {
//TODO
//        this.callback = profileCallback;
//        FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
//        database.child(auth.getUid()).addListenerForSingleValueEvent(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        Profile profile = new Profile();
//                        callback.responseProfile(profile);
//                    }
//                });
    }
}
