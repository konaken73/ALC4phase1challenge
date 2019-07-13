package com.kencorp.alcchallenge;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Kenneth Ze Ondoua Kona
 */

public class Profile extends AppCompatActivity {

    private ImageView imageView;
    private TextView fullName;
    private TextView track;
    private TextView country;
    private TextView phone;
    private TextView email;
    private TextView slackUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         User user = new User("Kenneth Ze Ondoua Kona","Android","Cameroon"
                ,"konaken73@gmail.com","237696853617","@konaken");

        fullName = findViewById(R.id.myName);
        track = findViewById(R.id.content_track);
        country = findViewById(R.id.content_country);
        phone = findViewById(R.id.content_phone);
        email = findViewById(R.id.content_email);
        slackUsername = findViewById(R.id.content_slack_username);

        fullName.setText(user.getFullName());
        track.setText(user.getTrack());
        country.setText(user.getCountry());
        email.setText(user.getEmail());
        slackUsername.setText(user.getSlackUsername());
        phone.setText(user.getPhone());

        imageView = findViewById(R.id.picture);
        try {
            int id = this.getRawResIdByName("konaken");
             imageView.setImageURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }


    }

    // Find ID corresponding to the name of the resource (in the directory raw).
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.v("ALC challenge", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }



}
