package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;

public class ProfileNeighbourActivity extends AppCompatActivity {

    Neighbour neighbour;

    @BindView(R.id.profile_header_name)
    public TextView tHeaderName;
    @BindView(R.id.profile_body_name)
    public TextView tBodyName;
    @BindView(R.id.profile_header_avatar)
    public ImageView iAvatarUrl;
    @BindView(R.id.profile_body_adresse)
    public TextView tAdresse;
    @BindView(R.id.profile_body_phone)
    public TextView tPhone;
    @BindView(R.id.profile_bio_corpus)
    public TextView tAboutMe;
    @BindView(R.id.profile_favorite_button)
    public FloatingActionButton fFavoriteStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);

        if (getIntent().hasExtra("neighbour_data")) {
            neighbour = getIntent().getParcelableExtra("neighbour_data");

            long id = neighbour.getId();
            boolean favoriteStatus = neighbour.isFavoriteStatus();

            tHeaderName.setText(neighbour.getName());
            tBodyName.setText(neighbour.getName());
            Glide.with(this)
                    .asBitmap()
                    .load(neighbour.getAvatarUrl())
                    .into(iAvatarUrl);
            tAdresse.setText(neighbour.getAddress());
            tPhone.setText(neighbour.getPhoneNumber());
            tAboutMe.setText(neighbour.getAboutMe());
            Glide.with(this)
                    .asBitmap()
                    .load(R.drawable.ic_star_border_white_24dp)
                    .into(fFavoriteStatus);

            fFavoriteStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!favoriteStatus) {
                        Glide.with(fFavoriteStatus)
                                .asBitmap()
                                .load(R.drawable.ic_star_white_24dp)
                                .into(fFavoriteStatus);
                        neighbour.setFavoriteStatus(true);

                    } else {
                        Glide.with(fFavoriteStatus)
                                .asBitmap()
                                .load(R.drawable.ic_star_border_white_24dp)
                                .into(fFavoriteStatus);
                        neighbour.setFavoriteStatus(false);
                    }
                    neighbour.setFavoriteStatus(favoriteStatus);
                }
            });
        }
    }
}