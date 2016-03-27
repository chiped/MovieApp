package com.chinmay.movieapp.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChiP on 1/10/2016.
 */
@JsonDeserialize(using = ImageUrlResult.ImageUrlResultDeserializer.class)
public class ImageUrlResult {

    private List<String> posters;
    private List<String> backdrops;

    public List<String> getBackdrops() {
        return backdrops;
    }

    public List<String> getPosters() {
        return posters;
    }

    public static class ImageUrlResultDeserializer extends JsonDeserializer<ImageUrlResult> {

        public ImageUrlResultDeserializer() {

        }

        @Override
        public ImageUrlResult deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            List<String> backdropList = new ArrayList<>();
            List<String> posterList = new ArrayList<>();

            ArrayNode backdrops = (ArrayNode) node.get("backdrops");
            for(JsonNode backdrop : backdrops) {
                backdropList.add(backdrop.get("file_path").asText());
            }
            ArrayNode posters = (ArrayNode) node.get("posters");
            for(JsonNode poster : posters) {
                posterList.add(poster.get("file_path").asText());
            }

            ImageUrlResult result = new ImageUrlResult();
            result.posters = posterList;
            result.backdrops = backdropList;
            return result;
        }
    }
}
