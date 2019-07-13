package com.kencorp.alcchallenge;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String fullName;
    private String track;
    private String country;
    private String email;
    private String phone;
    private String slackUsername;


   public User(String fullName, String track, String country,
               String email, String phone, String slackUsername ) {

      this.fullName = fullName;
        this.track = track;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.slackUsername = slackUsername;

    }

    protected User(Parcel in) {
        fullName = in.readString();
        track = in.readString();
        country = in.readString();
        email = in.readString();
        phone = in.readString();
        slackUsername = in.readString();

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSlackUsername() {
        return slackUsername;
    }

    public void setSlackUsername(String slackUsername) {
        this.slackUsername = slackUsername;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(track);
        dest.writeString(country);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(slackUsername);
     }

}
