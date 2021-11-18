package ch.zli.aj.cardscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    //Button create = findViewById(R.id.create);
    //public List<Card> cards = new ArrayList<>();

    boolean rBound = false;
    CardService cardService;
    Button create;

    /*public Card createCard(String name, String lastname, String company, String role){
        Card card = new Card(name, lastname, company, role);

        return card;
    }*/

    public void switchActivity(View v) {
        if(v.getId() == R.id.create){ Intent intent = new Intent(this, CreateCardActivity.class); startActivity(intent);}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
    }
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CardService.BoundBinder binder = (CardService.BoundBinder) service;
            cardService = binder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, CardService.class);
        bindService(intent, connection, this.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        rBound = false;
    }


}