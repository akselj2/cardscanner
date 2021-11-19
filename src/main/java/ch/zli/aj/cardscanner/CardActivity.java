package ch.zli.aj.cardscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    public void createCard(String name, String company, String role){
        cards.add(new Card(name, company, role));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);



        try {
            Bundle bundle = getIntent().getExtras();
            if (getIntent().getExtras() != null) {

                firstname = bundle.get("firstname").toString();
                lastname = bundle.get("lastname").toString();
                company = bundle.get("company").toString();
                role = bundle.get("role").toString();

                String name = firstname + " " + lastname;

                Card card = new Card(name, company, role);

                cards.add(card);
                for (int i = 0; i < cards.size(); i++) {
                    System.out.println(cards.get(i).toString());;
                }
            }
        } catch (Exception e){
            System.out.println("BUNDLED FAILED, REASON:" + e);
        }

        RecyclerView recyclerView =  (RecyclerView) findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(cards);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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