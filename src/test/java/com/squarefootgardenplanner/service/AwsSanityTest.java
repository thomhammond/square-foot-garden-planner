package com.squarefootgardenplanner.service;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.squarefootgardenplanner.service.dao.PlantDao;
import com.squarefootgardenplanner.service.models.dynamodb.Plant;
import com.squarefootgardenplanner.service.enums.PlantType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AwsSanityTest {
    private DynamoDBMapper dynamoDBMapper;

    private PlantDao plantDao;

    @BeforeEach
    public void setUp() {
        dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(Regions.US_WEST_1)
                .build());

        plantDao = new PlantDao(dynamoDBMapper);
    }

    @Test
    public void getPlant_plantExists_returnsPlant() {
        Plant expectedPlant = new Plant();
        expectedPlant.setType(PlantType.VEGETABLES);
        expectedPlant.setName("Squash");

        Plant plant = plantDao.getPlant(PlantType.VEGETABLES, "Squash");

        assertEquals(expectedPlant, plant, "Plants are not the same");
    }

}
