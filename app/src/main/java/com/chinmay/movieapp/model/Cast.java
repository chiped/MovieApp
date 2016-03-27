package com.chinmay.movieapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ChiP on 1/26/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cast implements Parcelable {
    private int id;
    private String name;
    private String character;
    private String profilePath;

    public Cast() {}

    public String getProfilePath() {
        return profilePath;
    }

    @JsonProperty("profile_path")
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Cast(Parcel in) {
        id = in.readInt();
        name = in.readString();
        character = in.readString();
        profilePath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(character);
        dest.writeString(profilePath);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cast> CREATOR = new Parcelable.Creator<Cast>() {
        @Override
        public Cast createFromParcel(Parcel in) {
            return new Cast(in);
        }

        @Override
        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreditsResponse {
        public List<Cast> cast;
    }
}
