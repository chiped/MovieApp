package com.chinmay.movieapp.utils;

/**
 * Created by ChiP on 1/7/2016.
 */
public class StringUtils {
    public static final String EMPTY_STRING = "";

    public static boolean empty(String posterPath) {
        return posterPath == null || EMPTY_STRING.equals(posterPath);
    }
}
