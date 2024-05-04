package com.garbagecollections.utils.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseConfig {

    protected FirebaseDatabase firebaseDatabase;
    protected DatabaseReference databaseReference;

    public FireBaseConfig(String path) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(path);
    }
}
