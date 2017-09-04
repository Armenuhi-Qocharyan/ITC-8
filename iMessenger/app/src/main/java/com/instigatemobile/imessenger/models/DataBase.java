package com.instigatemobile.imessenger.models;

import android.print.PageRange;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.instigatemobile.imessenger.data.Profile;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataBase {
    private DatabaseReference database;
    private static DataBase dataBase;

    private DataBase() {
        database = FirebaseDatabase.getInstance().getReference();
    }

    public static DataBase initDataBase() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return  dataBase;
    }

    public boolean insertProfile(Profile profile) {
        FirebaseUser auth =  FirebaseAuth.getInstance().getCurrentUser();

        database.child("users");
        database.child(auth.getUid()).child("id").setValue(auth.getUid());
        database.child(auth.getUid()).child("name").setValue(profile.getName());
        database.child(auth.getUid()).child("email").setValue(profile.getEmail());
        database.child(auth.getUid()).child("avatar").setValue(profile.getAvatar());
        database.child(auth.getUid()).child("background").setValue(profile.getBackground());
        database.child(auth.getUid()).child("favoritesCount").setValue(profile.getFavoritesCount());
        database.child(auth.getUid()).child("contactsCount").setValue(profile.getContactsCount());

        return true;
    }



}
