package ch.zli.aj.cardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CreateCardActivity extends AppCompatActivity {

    Button createCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        createCard = findViewById(R.id.createCard);

        createCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCard();
            }
        });
    }

    public void createCard(){
        EditText firstnameText = (EditText) findViewById(R.id.firstname);
        EditText lastnameText = (EditText) findViewById(R.id.lastname);
        EditText companyText = (EditText) findViewById(R.id.company);
        EditText roleText = (EditText) findViewById(R.id.role);

        String firstname = firstnameText.getText().toString();
        String lastname = lastnameText.getText().toString();
        String company = companyText.getText().toString();
        String role = roleText.getText().toString();

        Intent intent = new Intent(this, CardActivity.class);
        intent.putExtra("firstname", firstname);
        intent.putExtra("lastname", lastname);
        intent.putExtra("company", company);
        intent.putExtra("role", role);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}