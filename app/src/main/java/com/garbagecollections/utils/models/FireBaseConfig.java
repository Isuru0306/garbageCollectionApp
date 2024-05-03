package com.garbagecollections.utils.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseConfig {

    protected FirebaseDatabase firebaseDatabase;
    protected DatabaseReference databaseReference;

    public FireBaseConfig() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users");
    }
}
