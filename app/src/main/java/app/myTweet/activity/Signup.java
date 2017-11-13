package app.myTweet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.mytweet.R;

import app.myTweet.main.MyTweetApp;
import app.myTweet.model.Portfolio;
import app.myTweet.model.User;


/**
 * Created by Patrick on 22/09/2017.
 */

public class Signup extends AppCompatActivity {

    private Portfolio portfolio;
    private MyTweetApp app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        app = (MyTweetApp) getApplication();

        portfolio = app.portfolio;

        Log.v("Tweet", "Signup page");



    }

    public void registerPressed(View view)
    {
        TextView firstName = (TextView)  findViewById(R.id.firstName);
        TextView lastName  = (TextView)  findViewById(R.id.lastName);
        TextView email     = (TextView)  findViewById(R.id.loginEmail);
        TextView password  = (TextView)  findViewById(R.id.Password);

        User user = new User (firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString());

        MyTweetApp app = (MyTweetApp) getApplication();
        app.newUser(user);
        Log.v("Tweet", "Signup " + email.getText());

        startActivity(new Intent(this, Welcome.class));
    }

    @Override
    public void onPause()
    {
        super.onPause();
        portfolio.saveUser();
        Log.v("Tweet", "User saved " );

    }
}
