package ch.zli.aj.cardscanner;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;

public class CardService extends Service {

    /**
     * IMPORTANT: THIS IS CURRENTLY UNUSED, AS IM TOO DUMB TO UNDERSTAND SERVICES AND HOW THEY WORK ATM.
     */

    List<Card> cardList = new ArrayList<>();

    private final IBinder binder = new BoundBinder();

    public void createCard(Card card) {
        cardList.add(card);
        for (int i = 0; i < cardList.size(); i++){
            System.out.println(cardList.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "object: ";
    }

    public class BoundBinder extends Binder {
        CardService getService(){return CardService.this;}
    }

    @Override
    public IBinder onBind(Intent intent){
        return binder;
        //TODO: return the communication channel to the service
    }

    public void createCard(String firstname, String lastname, String company, String role){
        Card card = new Card(firstname, lastname, company, role);
        cardList.add(card);
    }
}
