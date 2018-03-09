package dehaagsehogeschool.cyberdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Tony on 2/20/2018.
 */

public class DigiVeiligSpelActivity extends AppCompatActivity {

    public final static String TAG = DigiVeiligSpelActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digiveilig_spel_activity);

        Log.i(TAG, "I am here!");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "I am paused!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "I am stopped!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "I am destroyed!");
    }

}