package com.example.accessthephotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    int changer=0;
    String UN = "abcd";
    String PW = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button) findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (changer==0) {
                    validate(Name.getText().toString(), Password.getText().toString());
                }
                else{
                    UN=Name.getText().toString();
                    PW=Password.getText().toString();
                    changer=0;
                    Name.setText("");
                    Password.setText("");
                    Toast.makeText(getApplicationContext(), "Credentials changed successfully!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Login again!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals(UN))&&(userPassword.equals(PW))){
            Intent intent = new Intent (MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Incorrect Entries! Try again!", Toast.LENGTH_SHORT).show();
            Name.setText("");
            Password.setText("");
        }
    }

    public void change(View view) {
        changer=1;
        Name.setText("");
        Password.setText("");
        Toast.makeText(getApplicationContext(), "Enter new credentials and click Login!", Toast.LENGTH_SHORT).show();

    }
}