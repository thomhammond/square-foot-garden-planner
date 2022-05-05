package com.squarefootgardenplanner.service.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squarefootgardenplanner.service.enums.GrowingSeason;

import java.util.ArrayList;
import java.util.List;

public class GrowingSeasonConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List growingSeasons) {
        return GSON.toJson(growingSeasons);
    }

    @Override
    public List unconvert(String growingSeasons) {
        return GSON.fromJson(growingSeasons, new TypeToken<ArrayList<GrowingSeason>>() {}.getType());
    }
}
