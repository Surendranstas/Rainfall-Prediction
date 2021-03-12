package com.example.rainfallprediction;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class Login extends Fragment {
    private String usr_name = "adminteam";
    private String pwd = "peri1452";

    private TextView user , pswd , msg ;
    private Button login_btn , register_btn ;

    public static Login newInstance() {
        Login fragment = new Login();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_page, container, false);
        user = view.findViewById(R.id.username);
        pswd = view.findViewById(R.id.password);
        msg = view.findViewById(R.id.message);
        register_btn = view.findViewById(R.id.register_btn);
        login_btn = view.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((String.valueOf(user.getText()).equals(usr_name)) && String.valueOf(pswd.getText()).equals(pwd))
                    Navigation.findNavController(v).navigate(R.id.login_page_to_main_fragment);
                else
                    msg.setText("Username or Password is Incorrect !");
            }
        });
        return view;
    }


    }





