package com.chinmay.movieapp.utils;

import android.support.annotation.Nullable;

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

    @Nullable
    private static String getPosterUrl(String posterPath, String type) {
        if(!StringUtils.empty(posterPath)) {
            return new StringBuffer(Constants.IMAGE_BASE_URL)
                    .append(type)
                    .append(posterPath)
                    .append("?api_key=")
                    .append(Constants.API_KEY)
                    .toString();
        }
        return null;
    }
}
