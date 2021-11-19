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

    List<Card> cards = new ArrayList<>();

    String firstname;
    String lastname;
    String company;
    String role;

    public void switchActivity(View v) {
        if(v.getId() == R.id.create){ Intent intent = new Intent(this, CreateCardActivity.class); startActivity(intent);}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Bundle bundle = getIntent().getExtras();
        if (getIntent().getExtras() != null) {
            firstname = bundle.get("firstname").toString();
            lastname = bundle.get("lastname").toString();
            company = bundle.get("company").toString();
            role = bundle.get("role").toString();

            Card card = new Card(firstname, lastname, company, role);

            cards.add(card);
            for (int i = 0; i < cards.size(); i++) {
                System.out.println(cards.get(i).toString());;
            }
        }


    }

    @Override
    public String toString() {
        return "CardActivity{" +
                "cards=" + cards +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                '}';
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