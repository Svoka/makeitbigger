package artem.osipov.jokedisplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        String joke;

        if (getIntent().hasExtra(EXTRA_JOKE)) {
            joke = getIntent().getStringExtra(EXTRA_JOKE);
        } else {
            joke = getString(R.string.no_joke);
        }

        TextView jokeView = findViewById(R.id.tv_joke);
        jokeView.setText(joke);
    }
}
