package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;

public class ProfileNeighbourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);

        getData();
    }

    private void getData() {
        if(getIntent().hasExtra("neighbour_url") && getIntent().hasExtra("neighbour_name")){

            String neighbourUrl = getIntent().getStringExtra("neighbour_url");
            String neighbourName = getIntent().getStringExtra("neighbour_name");
            String neighbourAdresse = getIntent().getStringExtra("neighbour_adresse");
            String neighbourPhone = getIntent().getStringExtra("neighbour_phone");
            String neighbourAboutMe = getIntent().getStringExtra("neighbour_aboutMe");
            String neighbourMedia = getString(R.string.social, neighbourName);

            setData(neighbourUrl, neighbourName, neighbourAdresse,
                    neighbourPhone, neighbourAboutMe, neighbourMedia);
        }
    }

    private void setData(String neighbourUrl, String neighbourName, String neighbourAdresse,
                         String neighbourPhone, String neighbourAboutMe, String neighbourMedia) {

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
    }
}