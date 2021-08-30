package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.OnClick;

public class ProfileNeighbourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);

        getData();
    }

    private void getData() {

        if(getIntent().hasExtra("neighbour_url") && getIntent().hasExtra("neighbour_name") &&
                getIntent().hasExtra("neighbour_adresse") && getIntent().hasExtra("neighbour_phone") &&
                getIntent().hasExtra("neighbour_aboutMe") && getIntent().hasExtra("neighbour_status")){

            String neighbourUrl = getIntent().getStringExtra("neighbour_url");
            String neighbourName = getIntent().getStringExtra("neighbour_name");
            String neighbourAdresse = getIntent().getStringExtra("neighbour_adresse");
            String neighbourPhone = getIntent().getStringExtra("neighbour_phone");
            String neighbourAboutMe = getIntent().getStringExtra("neighbour_aboutMe");
            String neighbourMedia = getString(R.string.social, neighbourName);
            Boolean neighbourStatus = getIntent().getBooleanExtra("neighbour_status", false);



            setData(neighbourUrl, neighbourName, neighbourAdresse,
                    neighbourPhone, neighbourAboutMe, neighbourMedia, neighbourStatus);
        }
        else Toast.makeText(this, "No data..", Toast.LENGTH_LONG).show();
    }

    private void setData(String neighbourUrl, String neighbourName, String neighbourAdresse,
                         String neighbourPhone, String neighbourAboutMe, String neighbourMedia,
                         Boolean neighbourStatus) {

        ImageView headerAvatar = findViewById(R.id.profile_header_avatar);
        Glide.with(this)
                .asBitmap()
                .load(neighbourUrl)
                .into(headerAvatar);
        TextView headerName = findViewById(R.id.profile_header_name);
        headerName.setText(neighbourName);
        TextView bodyName = findViewById(R.id.profile_body_name);
        bodyName.setText(neighbourName);
        TextView bodyAdresse = findViewById(R.id.profile_body_adresse);
        bodyAdresse.setText(neighbourAdresse);
        TextView bodyPhone = findViewById(R.id.profile_body_phone);
        bodyPhone.setText(neighbourPhone);
        TextView bioAboutMe = findViewById(R.id.profile_bio_corpus);
        bioAboutMe.setText(neighbourAboutMe);
        TextView bodyMedia = findViewById(R.id.profile_body_sociale_content);
        bodyMedia.setText(neighbourMedia);
        FloatingActionButton statusCheck = findViewById(R.id.profile_favorite_button);
        if (!neighbourStatus) {
            Glide.with(this)
                    .asBitmap()
                    .load(R.drawable.ic_star_border_white_24dp)
                    .into(statusCheck);
        }else
            Glide.with(this)
                    .asBitmap()
                    .load(R.drawable.ic_star_white_24dp)
                    .into(statusCheck);
    }
}



























