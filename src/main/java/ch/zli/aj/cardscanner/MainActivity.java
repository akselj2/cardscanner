package ch.zli.aj.cardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cards;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchActivity(View v){
        if (v.getId() == R.id.cards) {
            Intent intent = new Intent(this, CardActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.scan) {
            Intent intent = new Intent(this, ScannerActivity.class);
            startActivity(intent);
        }
    }
}