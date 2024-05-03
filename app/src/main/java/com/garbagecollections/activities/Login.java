package com.garbagecollections.activities;

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

import com.garbagecollections.AdminDrawerActivity;
import com.garbagecollections.DriverDrawerActivity;
import com.garbagecollections.MainActivity;
import com.garbagecollections.R;
import com.garbagecollections.activities.user.UserRegister;
import com.garbagecollections.utils.auth.Auth;
import com.garbagecollections.utils.models.UserHelper;

public class Login extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button login = findViewById(R.id.loginbtn);
        TextView userSignupNavigate = findViewById(R.id.navigate_user_signup);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.editpassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String UserPassword = password.getText().toString();

                if (userName.isEmpty() || UserPassword.isEmpty()){
                    Toast.makeText(Login.this, "All fields required.. !", Toast.LENGTH_SHORT).show();
                }else {
                    UserHelper userHelper = new UserHelper(userName, UserPassword);
                    Auth auth = new Auth();

                    // Call signIn method to authenticate the user
                    auth.signIn(userHelper, new Auth.AuthListener() {
                        @Override
                        public void onAuthSuccess(UserHelper user) {
                            System.out.println(user.getUser_type());
                            Toast.makeText(Login.this, "Login success", Toast.LENGTH_SHORT).show();
                            String userType = user.getUser_type();
                            switch (userType) {
                                case "ADMIN": {
                                    Intent mainActivity = new Intent(Login.this, AdminDrawerActivity.class);
                                    startActivity(mainActivity);
                                    break;
                                }
                                case "DRIVER": {
                                    Intent mainActivity = new Intent(Login.this, DriverDrawerActivity.class);
                                    startActivity(mainActivity);
                                    break;
                                }
                                case "USER": {
                                    Intent mainActivity = new Intent(Login.this, MainActivity.class);
                                    startActivity(mainActivity);
                                    break;
                                }
                                default:
                                    Toast.makeText(Login.this, "Something went wrong please try again..!", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }

                        @Override
                        public void onAuthFailed() {
                            Toast.makeText(Login.this, "Something went wrong please try again ....!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });


        userSignupNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userReg = new Intent(Login.this, UserRegister.class);
                startActivity(userReg);
                finish();
            }
        });


    }


//    @Override
//    public void onAuthSuccess(UserHelper use) {
//

//    }
//
//    @Override
//    public void onAuthFailed() {
//        Toast.makeText(this, "Something went wrong please try again..!", Toast.LENGTH_SHORT).show();
//    }
}