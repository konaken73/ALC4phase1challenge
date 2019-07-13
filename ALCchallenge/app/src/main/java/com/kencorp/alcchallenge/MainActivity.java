package com.kencorp.alcchallenge;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kenneth Ze Ondoua Kona
 */

public class MainActivity extends AppCompatActivity {

    private Button profile;
    private Button about;
    private Button shareLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        about = findViewById(R.id.about);

        profile = findViewById(R.id.profile);

        shareLink = findViewById(R.id.shareLink);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(v.getContext() ,AboutPage.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext() , Profile.class));
            }
        });

        shareLink.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                shareLink();
            }
        });
    }


    public void shareLink()
    {

        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("message/rfc2822");

        email.putExtra(Intent.EXTRA_SUBJECT,"Andela Learning Community");

        email.putExtra(Intent.EXTRA_TEXT,"click on this link:  "+"https://andela.com/alc/");

        startActivity(email);

    }


}
