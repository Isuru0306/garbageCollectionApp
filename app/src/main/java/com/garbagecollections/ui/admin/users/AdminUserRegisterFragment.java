package com.garbagecollections.ui.admin.users;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.garbagecollections.R;
import com.garbagecollections.activities.user.UserRegister;
import com.garbagecollections.utils.auth.Auth;
import com.garbagecollections.utils.models.helpers.UserHelper;

public class AdminUserRegisterFragment extends Fragment {

    private String userType;
    public static AdminUserRegisterFragment newInstance() {
        return new AdminUserRegisterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert inflater != null;
        View rootView = inflater.inflate(R.layout.fragment_admin_user_register, null);

        Spinner dropdown = rootView.findViewById(R.id.user_type);
        String[] items = new String[]{"ADMIN", "DRIVER"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                userType  = (String) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected
            }
        });


        Button registerBtn = rootView.findViewById(R.id.admin_register_button);
        EditText regName = rootView.findViewById(R.id.admin_reg_name);
        EditText regUsername = rootView.findViewById(R.id.admin_reg_username);
        EditText regEmail = rootView.findViewById(R.id.admin_reg_user_email);
        EditText regPassword = rootView.findViewById(R.id.admin_reg_password);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = regName.getText().toString();
                String username = regUsername.getText().toString();
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();

                if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || userType.isEmpty()){
                    Toast.makeText(requireContext(), "All fields required ..!", Toast.LENGTH_SHORT).show();
                }else{
                    UserHelper userHelper = new UserHelper(name, email, username, password, userType);
                    Auth auth = new Auth();
                    if(auth.signUp(userHelper)){
                        Toast.makeText(requireContext(), "User Registration Successfully", Toast.LENGTH_SHORT).show();
                        regName.setText("");
                        regUsername.setText("");
                        regEmail.setText("");
                        regPassword.setText("");
                    }else {
                        Toast.makeText(requireContext(), "User Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return rootView;
    }

    @NonNull
    @Override
    public String toString(){
        return "AdminUserRegisterFragment";
    }

}