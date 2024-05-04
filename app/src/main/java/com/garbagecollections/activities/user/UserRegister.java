package com.garbagecollections.activities.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.garbagecollections.R;
import com.garbagecollections.activities.Login;
import com.garbagecollections.utils.auth.Auth;
import com.garbagecollections.utils.models.helpers.UserHelper;

public class UserRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button registerButton = findViewById(R.id.register_button);
        TextView loginNavigation = findViewById(R.id.navigate_login);
        EditText regName = findViewById(R.id.reg_name);
        EditText regUsername = findViewById(R.id.reg_username);
        EditText regEmail = findViewById(R.id.reg_user_email);
        EditText regPassword = findViewById(R.id.reg_password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = regName.getText().toString();
                String username = regUsername.getText().toString();
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(UserRegister.this, "All fields required ..!", Toast.LENGTH_SHORT).show();
                }else{
                    UserHelper userHelper = new UserHelper(name, email, username, password, "USER");
                    Auth auth = new Auth();
                    if(auth.signUp(userHelper)){
                        Toast.makeText(UserRegister.this, "User Registration Successfully", Toast.LENGTH_SHORT).show();
                        regName.setText("");
                        regUsername.setText("");
                        regEmail.setText("");
                        regPassword.setText("");
                    }else {
                        Toast.makeText(UserRegister.this, "User Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        loginNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(UserRegister.this, Login.class);
                startActivity(login);
                finish();
            }
        });


    }
}