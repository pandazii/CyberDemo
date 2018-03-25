package dehaagsehogeschool.digiveilig.toets;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

import dehaagsehogeschool.digiveilig.GameSettings;
import dehaagsehogeschool.digiveilig.HomeActivity;
import dehaagsehogeschool.digiveilig.R;
import dehaagsehogeschool.digiveilig.managers.ResultManager;

public class DigiveiligToetsEndActivity extends AppCompatActivity {

    public final static String TAG = DigiveiligToetsEndActivity.class.getSimpleName();
    private TextView newScoreLabel;

    SharedPreferences gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize
        super.onCreate(savedInstanceState);
        initializeObject();

        // Get the result
        Double result = calculateResult();

        // Set result in the view
        DecimalFormat decimalFormat = new DecimalFormat("##.0");
        newScoreLabel.setText("Behaalde score: " + decimalFormat.format(result));

        // Add result to results
        ResultManager resultManager = new ResultManager(GameSettings.LOCATION_SHARED_PREFERENCES, getApplicationContext());
        resultManager.addResult(result);
    }

    private void initializeObject() {
        Log.i(TAG, "I am created!");

        setContentView(R.layout.digiveilig_toets_result_activity);
        newScoreLabel = findViewById(R.id.score_result_current_score);
    }

    private Double calculateResult() {
        int questions = getIntent().getIntExtra(GameSettings.QUESTIONS_AMOUNT, 0);
        int score = getIntent().getIntExtra(GameSettings.RESULT_SCORE, 0);

        double result = (double) score / (double) questions * 10.0;
        if (result < 1) result = 1;

        return result;
    }

    public void ToResultsScreen(View view) {
        Intent intent = new Intent(this, DigiveiligToetsResultsActivity.class);
        startActivity(intent);
        finish();
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

    public void backToMainScreen(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}