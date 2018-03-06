package dehaagsehogeschool.cyberdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    public void startQuiz(View view) {

        Intent intent = new Intent(this, QuizSpelAnnouncement.class);
        startActivity(intent);
    }

    public void startDigiveilig(View view) {

        Intent intent = new Intent(this, DigiVeiligSpelActivity.class);
        startActivity(intent);
    }

    public void startHelp(View view) {

        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);

    }
}
