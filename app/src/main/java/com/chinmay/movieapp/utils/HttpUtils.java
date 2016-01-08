package com.chinmay.movieapp.utils;

import com.chinmay.movieapp.Constants;

/**
 * Created by ChiP on 1/7/2016.
 */
public class HttpUtils {
    public static String getSmallUrl(String posterPath) {
        if(!StringUtils.empty(posterPath)) {
            return new StringBuffer(Constants.IMAGE_BASE_URL)
                    .append(Constants.SMALL)
                    .append(posterPath)
                    .append("?api_key=")
                    .append(Constants.API_KEY)
                    .toString();
        }
        return null;
    }
}
