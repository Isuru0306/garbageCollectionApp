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
import com.garbagecollections.utils.auth.Auth;
import com.garbagecollections.utils.models.helpers.FileHelper;
import com.garbagecollections.utils.models.helpers.UserHelper;

public class EditProfile extends AppCompatActivity {

    UserHelper editUserDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        EditText editName = findViewById(R.id.nameEd);
        EditText editEmail = findViewById(R.id.emailEd);
        EditText editPassword = findViewById(R.id.passwordEd);

        FileHelper fileHelper = new FileHelper(this, "logged_user.txt");
        String username = fileHelper.readFromFile();

        Auth auth = new Auth();
        auth.findUserByUsername(username, new Auth.AuthListener() {
            @Override
            public void onAuthSuccess(UserHelper use) {
                editUserDetails = use;
                editName.setText(use.getName());
                editEmail.setText(use.getEmail());
                editPassword.setText(use.getPassword());
            }

            @Override
            public void onAuthFailed() {
                Toast.makeText(EditProfile.this, "Something went wrong please try again later..", Toast.LENGTH_SHORT).show();
            }
        });


        Button saveData = findViewById(R.id.saveBtn);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String name  = editName.getText().toString();
                    String email  = editEmail.getText().toString();
                    String password  = editPassword.getText().toString();

                    editUserDetails.setName(name);
                    editUserDetails.setEmail(email);
                    editUserDetails.setPassword(password);

                    auth.updateUserDetails(editUserDetails, new Auth.UpdateListener() {
                        @Override
                        public void onUpdateSuccess() {
                            Toast.makeText(EditProfile.this, "Update successfully", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onUpdateFailed() {
                            Toast.makeText(EditProfile.this, "Update unsuccessfully", Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });

    }
}