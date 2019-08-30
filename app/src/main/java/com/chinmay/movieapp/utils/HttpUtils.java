package com.chinmay.movieapp.utils;

import androidx.annotation.Nullable;

import com.chinmay.movieapp.BuildConfig;
import com.chinmay.movieapp.Constants;

/**
 * Created by ChiP on 1/7/2016.
 */
public class HttpUtils {
    public static String getSmallUrl(String posterPath) {
        return getPosterUrl(posterPath, Constants.SMALL);
    }

    public static String getLargeUrl(String posterPath) {
        return getPosterUrl(posterPath, Constants.LARGE);
    }

    public static String get780Url(String posterPath) {
        return getPosterUrl(posterPath, Constants.IMAGE_780);
    }

    public static String get300Url(String posterPath) {
        return getPosterUrl(posterPath, Constants.IMAGE_300);
    }

    public static String getProfilePhotoUrl(String profilePath) {
        return getPosterUrl(profilePath, Constants.IMAGE_PROFILE);
    }

    @Nullable
    private static String getPosterUrl(String posterPath, String type) {
        if(!StringUtils.empty(posterPath)) {
            return new StringBuffer(Constants.IMAGE_BASE_URL)
                    .append(type)
                    .append(posterPath)
                    .append("?api_key=")
                    .append(BuildConfig.TMDB_API_KEY)
                    .toString();
        }
        return null;
    }
}
