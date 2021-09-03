package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Neighbour implements Parcelable {

    private final long id;
    private final String name;
    private final String avatarUrl;
    private final String address;
    private final String phoneNumber;
    private final String aboutMe;
    boolean favoriteStatus;

    public Neighbour(long id, String name, String avatarUrl, String address,
                     String phoneNumber, String aboutMe,boolean favoriteStatus) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.aboutMe = aboutMe;
        this.favoriteStatus = favoriteStatus;
    }

    protected Neighbour(Parcel in) {
        id = in.readLong();
        name = in.readString();
        avatarUrl = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
        aboutMe = in.readString();
        favoriteStatus = in.readByte() != 0;
    }


    public static final Creator<Neighbour> CREATOR = new Creator<Neighbour>() {
        @Override
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }

        @Override
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public boolean isFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(avatarUrl);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeString(aboutMe);
        dest.writeByte((byte) (favoriteStatus ? 1 : 0));
    }

}
