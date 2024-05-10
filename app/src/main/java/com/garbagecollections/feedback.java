package com.garbagecollections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText username =(EditText) findViewById(R.id.Username);
        EditText feedback =(EditText) findViewById(R.id.Feedback);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL,new String("xyz@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT,"feedback from app");
                i.putExtra(Intent.EXTRA_TEXT,"Name:"+username.getText()+"\n Message:"+feedback.getText());
                try{
                    startActivity(Intent.createChooser(i,"please select email"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(feedback.this, "There are no Email Clients", Toast.LENGTH_SHORT).show();
                }
            }
                                }


        );
    }
    }
