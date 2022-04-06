package com.squarefootgardenplanner.service.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.squarefootgardenplanner.service.enums.GrowingSeason;

import java.util.ArrayList;
import java.util.List;

public class GrowingSeasonConverter implements DynamoDBTypeConverter<List<String>, List<GrowingSeason>> {

    @Override
    public List<String> convert(List<GrowingSeason> growingSeasons) {
        List<String> result = new ArrayList<>();
        if (growingSeasons != null) {
            for (GrowingSeason season : growingSeasons) {
                result.add(season.name());
            }
        }
        return result;
    }

    @Override
    public List<GrowingSeason> unconvert(List<String> growingSeasons) {
        List<GrowingSeason> result = new ArrayList<>();
        if (growingSeasons != null) {
            for (String season : growingSeasons) {
                result.add(GrowingSeason.valueOf(season));
            }
        }
        return result;
    }
}
