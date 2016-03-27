package com.chinmay.movieapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.chinmay.movieapp.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ChiP on 1/6/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Parcelable {

    private int id;
    private String title;
    private Date releaseDate;
    private double rating;
    private String posterPath;
    private String overview;
    private String displayTitle;

    public Movie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    @JsonProperty("vote_average")
    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        long tmpReleaseDate = in.readLong();
        releaseDate = tmpReleaseDate != -1 ? new Date(tmpReleaseDate) : null;
        rating = in.readDouble();
        posterPath = in.readString();
        overview = in.readString();
        displayTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeLong(releaseDate != null ? releaseDate.getTime() : -1L);
        dest.writeDouble(rating);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeString(displayTitle);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getDisplayTitle() {
        if(releaseDate == null) {
            return title;
        } else if(displayTitle != null) {
            return displayTitle;
        }
        return new StringBuffer(title)
                .append(StringUtils.BLANK_SPACE)
                .append(new SimpleDateFormat("(yyyy)").format(releaseDate))
                .toString();
    }
}
