package com.chinmay.movieapp.categories.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChiP on 3/28/2016.
 */
public class GenreWrapper {
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

    private String text;
    private ItemType type;

    public GenreWrapper(String text, ItemType type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public ItemType getType() {
        return type;
    }
}
