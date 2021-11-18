package ch.zli.aj.cardscanner;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CardService extends Service {
    private final IBinder binder = new BoundBinder();
    public class BoundBinder extends Binder {
        CardService getService(){return CardService.this;}
    }

    @Override
    public IBinder onBind(Intent intent){
        return binder;
        //TODO: return the communication channel to the service
    }
}
