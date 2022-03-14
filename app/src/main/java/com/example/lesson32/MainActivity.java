package com.example.lesson32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   EditText email;
   EditText subject;
   EditText message;
   Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email_et);
        subject = findViewById(R.id.topic);
        message = findViewById(R.id.sms);

        send = findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty()
                && !message.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                   // intent.setType("message/rfc822");
                    intent.setData(Uri.parse("mailto:"));
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "There is no application that support this action",
                                Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Please fill all fields",
                            Toast.LENGTH_LONG).show();
                }
            }
        });




    }

}