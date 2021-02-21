package com.example.zsombor.activitydemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    private Button loginButton;
    private EditText usernameField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.button);
        usernameField = (EditText) findViewById(R.id.editText);
        passwordField = (EditText) findViewById(R.id.editText2);

        builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(usernameField.getText().toString().equals("demo") && passwordField.getText().toString().equals("demo")){
                    Intent intent = new Intent(context,Secret.class);
                    startActivity(intent);
                } else {
                    builder.setTitle("Error")
                            .setMessage("Incorrect credentials entered")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    usernameField.setText("");
                                    passwordField.setText("");
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            }

        });
    }
}
