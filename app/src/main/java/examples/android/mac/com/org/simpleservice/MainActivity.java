package examples.android.mac.com.org.simpleservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    BoundService mBoundService;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    public void startTheService(View view) {
        Log.d(TAG, "startTheService");
        Intent intent = new Intent(this, SimpleService.class);
        startService(intent);
    }

    public void stopTheService(View view) {
        Log.d(TAG, "stopTheService");
        Intent intent = new Intent(this, SimpleService.class);
        stopService(intent);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            BoundService.LocalBinder binder = (BoundService.LocalBinder)service;
            mBoundService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected");
            isBound = false;
        }
    };


    public void doMagic(View view) {
        Log.d(TAG, "doMagic");
        mBoundService.doMagic();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        unbindService(serviceConnection);
        isBound = false;
    }

    public void startIntentService(View view) {
        Log.d(TAG, "startIntentService");
        startService(new Intent(this, SimpleIntentService.class));
    }
}
