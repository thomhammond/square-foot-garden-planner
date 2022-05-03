package com.squarefootgardenplanner.service.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.squarefootgardenplanner.service.models.dynamodb.Plant;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.exceptions.PlantNotFoundException;

import javax.inject.Inject;
import java.util.EnumSet;
import java.util.List;

/**
 * Accesses data for a plant using {@link Plant} to represent the model in DynamoDB.
 */
public class PlantDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Instantiates a PlantDao object.
     *
     * @param dynamoDBMapper the {@link DynamoDBMapper} used to interact with the plants table.
     */
    @Inject
    public PlantDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Plant getPlant(PlantType type, String name) throws PlantNotFoundException {
        Plant plant = dynamoDBMapper.load(Plant.class, type, name);

        if (plant == null) {
            throw new PlantNotFoundException("Could not find plant with name: " + name);
        }

        return plant;
    }

    public List<Plant> getPlantsByType(PlantType type) {
        // TODO: Might want to check that type is a valid PlantType here or in handleRequest...
        // TODO: Should this take in a String and do the conversion in the activity?

        Plant plant = new Plant();
        plant.setType(type);

        DynamoDBQueryExpression<Plant> queryExpression = new DynamoDBQueryExpression<Plant>()
                .withHashKeyValues(plant);

        PaginatedQueryList<Plant> plants = dynamoDBMapper.query(Plant.class, queryExpression);

        // TODO: Should this throw a unique exception? Should we check plants is not null first?
        // TODO: Should this even throw an exception? Should we just return an empty list?
        // TODO: Or since we check that we have a valid plant type first, can we assume we'll always have a valid list?
        if (plants.isEmpty()) {
            throw new PlantNotFoundException("No plants found with plant type: " + type);
        }

        return plants;
    }
}
