package com.garbagecollections.utils.auth;


import androidx.annotation.NonNull;

import com.garbagecollections.utils.config.FireBaseConfig;
import com.garbagecollections.utils.models.helpers.UserHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Auth extends FireBaseConfig {

    public Auth() {
        super("users");
    }


    public boolean signUp(UserHelper userHelper){
        try{
            this.databaseReference.child(userHelper.getUsername()).setValue(userHelper);
            return  true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void signIn(@NonNull UserHelper userHelper, AuthListener listener) {
        Query query = databaseReference.orderByChild("username").equalTo(userHelper.getUsername());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String DBPassword = Objects.requireNonNull(snapshot.child(userHelper.getUsername()).child("password").getValue()).toString();

                    if (userHelper.getPassword().equals(DBPassword)) {
                        String name = Objects.requireNonNull(snapshot.child(userHelper.getUsername()).child("name").getValue()).toString();
                        String email = Objects.requireNonNull(snapshot.child(userHelper.getUsername()).child("email").getValue()).toString();
                        String user_type = Objects.requireNonNull(snapshot.child(userHelper.getUsername()).child("user_type").getValue()).toString();
                        UserHelper user = new UserHelper(name, email, user_type);
                        listener.onAuthSuccess(user);
                    } else {
                        System.out.println("fuc");
                        listener.onAuthFailed();
                    }
                } else {
                    System.out.println("fuc1");
                    listener.onAuthFailed();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onAuthFailed();
            }
        });
    }

    public void findUserByUsername(@NonNull String username, AuthListener listener) {
        Query query = databaseReference.orderByChild("username").equalTo(username);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                        String name = Objects.requireNonNull(snapshot.child(username).child("name").getValue()).toString();
                        String email = Objects.requireNonNull(snapshot.child(username).child("email").getValue()).toString();
                        String userName = Objects.requireNonNull(snapshot.child(username).child("username").getValue()).toString();
                        String password = Objects.requireNonNull(snapshot.child(username).child("password").getValue()).toString();
                        String user_type = Objects.requireNonNull(snapshot.child(username).child("user_type").getValue()).toString();
                        UserHelper user = new UserHelper(name, email, userName, password, user_type);
                        listener.onAuthSuccess(user);
                } else {
                    listener.onAuthFailed();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onAuthFailed();
            }
        });
    }


    public  void  updateUserDetails(@NonNull UserHelper userHelper, UpdateListener listener){
        Query query = databaseReference.orderByChild("username").equalTo(userHelper.getUsername());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getRef().child(userHelper.getUsername()).child("name").setValue(userHelper.getName());
                snapshot.getRef().child(userHelper.getUsername()).child("email").setValue(userHelper.getEmail());
                snapshot.getRef().child(userHelper.getUsername()).child("password").setValue(userHelper.getPassword());


                listener.onUpdateSuccess();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onUpdateFailed();
            }
        });
    }




    public interface AuthListener {
        public abstract void onAuthSuccess(UserHelper use);

        public abstract void onAuthFailed();
    }

    public interface UpdateListener{
        public abstract void onUpdateSuccess();

        public abstract void onUpdateFailed();
    }

}
