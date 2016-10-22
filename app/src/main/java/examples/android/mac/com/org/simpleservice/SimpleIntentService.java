package examples.android.mac.com.org.simpleservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by User on 10/21/2016.
 */

public class SimpleIntentService extends IntentService {
    private static final String TAG = SimpleIntentService.class.getName();
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */


    public SimpleIntentService(){
        super("SimpleIntentService");

    }

    public SimpleIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
