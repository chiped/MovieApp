package com.chinmay.movieapp.categories.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.chinmay.movieapp.model.Genre;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChiP on 3/28/2016.
 */
public class GenreWrapper implements Parcelable {
    public enum ItemType {
        HEADER(0), ITEM(1), EMPTY(2);

        private static final Map<Integer, ItemType> intToTypeMap = new HashMap<>();
        private final int value;

        ItemType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        static {
            for (ItemType type : ItemType.values()) {
                intToTypeMap.put(type.value, type);
            }
        }

        public static ItemType fromInt(int i) {
            ItemType type = intToTypeMap.get(Integer.valueOf(i));
            return type;
        }
    }

    public enum GenreType {MOVIE, TV}

    private Genre genre;
    private String text;
    private ItemType type;
    private GenreType genreType;

    private GenreWrapper(Genre genre, String text, ItemType type, GenreType genreType) {
        this.genre = genre;
        this.text = text;
        this.type = type;
        this.genreType = genreType;
    }

    public String getText() {
        return text;
    }

    public ItemType getType() {
        return type;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public Genre getGenre() {
        return genre;
    }

    public static class Builder {
        private Genre genre;
        private String text;
        private ItemType type = ItemType.EMPTY;
        private GenreType genreType;

        public Builder setGenre(Genre genre) {
            this.genre = genre;
            this.type = ItemType.ITEM;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            this.type = ItemType.HEADER;
            return this;
        }

        public Builder setGenreType(GenreType genreType) {
            this.genreType = genreType;
            return this;
        }

        public GenreWrapper build() {
            return new GenreWrapper(genre, text, type, genreType);
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.genre, flags);
        dest.writeString(this.text);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
        dest.writeInt(this.genreType == null ? -1 : this.genreType.ordinal());
    }

    protected GenreWrapper(Parcel in) {
        this.genre = in.readParcelable(Genre.class.getClassLoader());
        this.text = in.readString();
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : ItemType.values()[tmpType];
        int tmpGenreType = in.readInt();
        this.genreType = tmpGenreType == -1 ? null : GenreType.values()[tmpGenreType];
    }

    public static final Parcelable.Creator<GenreWrapper> CREATOR = new Parcelable.Creator<GenreWrapper>() {
        @Override
        public GenreWrapper createFromParcel(Parcel source) {
            return new GenreWrapper(source);
        }

        @Override
        public GenreWrapper[] newArray(int size) {
            return new GenreWrapper[size];
        }
    };
}
