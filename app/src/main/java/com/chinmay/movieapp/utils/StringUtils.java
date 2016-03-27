package com.chinmay.movieapp.utils;

import java.util.List;

/**
 * Created by ChiP on 1/7/2016.
 */
public class StringUtils {
    public static final String EMPTY_STRING = "";
    public static final String BLANK_SPACE = " ";

    public static boolean empty(String posterPath) {
        return posterPath == null || EMPTY_STRING.equals(posterPath);
    }

    public static String asStringSeparated(List<String> list, String separtor) {
        StringBuilder genreString = new StringBuilder();
        for(int i=0; i<list.size() - 1; i++) {
            genreString.append(list.get(i));
            genreString.append(separtor);
        }
        genreString.append(list.get(list.size()-1));
        return genreString.toString();
    }
}
