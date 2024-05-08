package com.garbagecollections;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;

import kotlin.jvm.internal.Ref;

public class feedback extends AppCompatActivity {
private Firebase Ref;
private EditText username,Feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        username=(EditText) findViewById(R.id.Username);
        Feedback= (EditText) findViewById(R.id.Feedback);
        Firebase.setAndroidContext(this);
        Ref=new Firebase (url:"")
    };
    public void feedbacksent (view view){
        String usernameinput =username.getText().toString();
        String feedbackinput =Feedback.getText().toString();
        Firebase Reusername=Ref.child("Username");
        Reeusername.setValue(usernameinput);
        Firebase ReFeedback=Ref.child("Feedback");
        ReFeedback.setValue(feedbackinput);

    }
    }
