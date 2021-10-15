package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileNeighbourActivity extends AppCompatActivity {

    Neighbour neighbour;
    NeighbourApiService mApiService;

    @BindView(R.id.profile_header_return)
    public ImageButton iHeaderReturn;
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
    @BindView(R.id.profile_body_sociale_content)
    public TextView tSociale;
    @BindView(R.id.profile_bio_corpus)
    public TextView tAboutMe;
    @BindView(R.id.profile_favorite_button)
    public FloatingActionButton fFavoriteStatus;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
        ButterKnife.bind(this);

        iHeaderReturn.setOnClickListener(v -> onBackPressed());

        mApiService = DI.getNeighbourApiService();

        if (getIntent().hasExtra("neighbour_data")) {
            neighbour = getIntent().getParcelableExtra("neighbour_data");

            tHeaderName.setText(neighbour.getName());
            tBodyName.setText(neighbour.getName());
            Glide.with(this)
                    .asBitmap()
                    .load(neighbour.getAvatarUrl())
                    .into(iAvatarUrl);
            tAdresse.setText(neighbour.getAddress());
            tPhone.setText(neighbour.getPhoneNumber());
            tSociale.setText("www.facebook.com/"+ neighbour.getName());
            tAboutMe.setText(neighbour.getAboutMe());

            fFavoriteStatus.setImageResource(neighbour.isFavoriteStatus() ?
                    R.drawable.ic_star_white_24dp : R.drawable.ic_star_border_white_24dp);

            fFavoriteStatus.setOnClickListener(v -> {
                if (neighbour.isFavoriteStatus()) {
                    neighbour.setNeighbourFavoriteStatus(false);
                    mApiService.setFavoriteStatus(neighbour.getId(), false);
                    fFavoriteStatus.setImageResource(R.drawable.ic_star_border_white_24dp);
                } else {
                    neighbour.setNeighbourFavoriteStatus(true);
                    mApiService.setFavoriteStatus(neighbour.getId(), true);
                    fFavoriteStatus.setImageResource(R.drawable.ic_star_white_24dp);
                }
            });
        }
    }
}