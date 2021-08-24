package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.profile_header_avatar)
    ImageView headerAvatar;
    @BindView(R.id.profile_header_name)
    TextView headerName;
    @BindView(R.id.profile_body_name)
    TextView bodyName;
    @BindView(R.id.profile_body_localisation_icon)
    ImageView localisationIcon;
    @BindView(R.id.profile_body_localisation_content)
    TextView localisationContent;
    @BindView(R.id.profile_body_phone_icon)
    ImageView phoneIcon;
    @BindView(R.id.profile_body_phone_content)
    TextView phoneContent;
    @BindView(R.id.profile_body_sociale_icon)
    ImageView socialeIcon;
    @BindView(R.id.profile_body_sociale_content)
    TextView socialeContent;
    @BindView(R.id.profile_bio_title)
    TextView bioTitle;
    @BindView(R.id.profile_bio_corpus)
    TextView bioCorpus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
    }

    public static void navigateToProfile(View.OnClickListener activity) {
        Intent intent = new Intent((Context) activity, ProfileNeighbourActivity.class);
        ((Context) activity).startActivity(intent);
    }

    public ImageView getHeaderAvatar() {
        return headerAvatar;
    }

    public void setHeaderAvatar(ImageView headerAvatar) {
        this.headerAvatar = headerAvatar;
    }

    public TextView getHeaderName() {
        return headerName;
    }

    public void setHeaderName(TextView headerName) {
        this.headerName = headerName;
    }

    public TextView getBodyName() {
        return bodyName;
    }

    public void setBodyName(TextView bodyName) {
        this.bodyName = bodyName;
    }

    public ImageView getLocalisationIcon() {
        return localisationIcon;
    }

    public void setLocalisationIcon(ImageView localisationIcon) {
        this.localisationIcon = localisationIcon;
    }

    public TextView getLocalisationContent() {
        return localisationContent;
    }

    public void setLocalisationContent(TextView localisationContent) {
        this.localisationContent = localisationContent;
    }

    public ImageView getPhoneIcon() {
        return phoneIcon;
    }

    public void setPhoneIcon(ImageView phoneIcon) {
        this.phoneIcon = phoneIcon;
    }

    public TextView getPhoneContent() {
        return phoneContent;
    }

    public void setPhoneContent(TextView phoneContent) {
        this.phoneContent = phoneContent;
    }

    public ImageView getSocialeIcon() {
        return socialeIcon;
    }

    public void setSocialeIcon(ImageView socialeIcon) {
        this.socialeIcon = socialeIcon;
    }

    public TextView getSocialeContent() {
        return socialeContent;
    }

    public void setSocialeContent(TextView socialeContent) {
        this.socialeContent = socialeContent;
    }

    public TextView getBioTitle() {
        return bioTitle;
    }

    public void setBioTitle(TextView bioTitle) {
        this.bioTitle = bioTitle;
    }

    public TextView getBioCorpus() {
        return bioCorpus;
    }

    public void setBioCorpus(TextView bioCorpus) {
        this.bioCorpus = bioCorpus;
    }
}