package com.instigatemobile.imessenger.Contacts;

/**
 * Created by vachagan on 8/31/17.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.instigatemobile.imessenger.Adapters.ContactsAdapter;
import com.instigatemobile.imessenger.Adapters.PersonAdapter;
import com.instigatemobile.imessenger.Models.Contacts;
import com.instigatemobile.imessenger.R;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        RecyclerView recyclerView =(RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Contacts> ContactsArray = new ArrayList<>();
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        ContactsArray.add(new Contacts("name surname", "last message ...", R.drawable.avatar));
        recyclerView.setAdapter(new ContactsAdapter());
        return rootView;
    }
}