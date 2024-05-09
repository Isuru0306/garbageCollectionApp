package com.garbagecollections.activities.user;

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

import com.garbagecollections.R;
import com.garbagecollections.utils.models.feedback.Feedback;
import com.garbagecollections.utils.models.helpers.FeedbackHelper;

public class UserFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_feedback);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText name = findViewById(R.id.feed_back_user_name);
        EditText message = findViewById(R.id.feed_back_msg);
        Button submit = findViewById(R.id.feed_back_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userFeedback = message.getText().toString();

                if(userName.isEmpty() || userFeedback.isEmpty()){
                    Toast.makeText(UserFeedback.this, "Fill all fields...!", Toast.LENGTH_SHORT).show();
                }else{
                    FeedbackHelper feedbackHelper = new FeedbackHelper(userName, userFeedback);
                    Feedback feedback = new Feedback();
                    if(feedback.insertFeedBack(feedbackHelper)){
                        Toast.makeText(UserFeedback.this, "Thank you..! your feedback..", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        message.setText("");
                        finish();
                    }else{
                        Toast.makeText(UserFeedback.this, "Something went wrong please try again later", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}