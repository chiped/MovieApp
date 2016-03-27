package com.chinmay.movieapp.moviedetails.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChiP on 3/26/2016.
 */
public abstract class DetailItem {
    public enum ItemType {
        TEXT(0),
        EXPANDABLE_TEXT(1),
        HORIZONTAL_MOVIE_LIST(2),
        HORIZONTAL_PEOPLE_LIST(3),
        HORIZONTAL_IMAGE_LIST(4),
        HORIZONTAL_TEXT_LIST(5),
        VERTICAL_REVIEWS_LIST(6);

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
    protected ItemType itemType;
    protected String title;

    public ItemType getItemType() {
        return itemType;
    }

    public String getTitle() {
        return title;
    }
}
