package com.squarefootgardenplanner.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.squarefootgardenplanner.service.dynamodb.models.Plant;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.exceptions.PlantNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class PlantDaoTest {

    @Mock
    private DynamoDBMapper mapper;

    private PlantDao plantDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        plantDao = new PlantDao(mapper);
    }

    @Test
    public void getPlant_plantExists_returnsPlant() {
        // GIVEN
        PlantType testType = PlantType.VEGETABLES;
        String testName = "test plant";

        Plant testPlant = new Plant();

        testPlant.setType(testType);
        testPlant.setName(testName);

        when(mapper.load(Plant.class, testType, testName)).thenReturn(testPlant);

        // WHEN
        Plant result = plantDao.getPlant(testType, testName);

        // THEN
        assertEquals(testType, result.getType(), "Plant types do not match");
        assertEquals(testName, result.getName(), "Names do not match");
    }

    @Test
    public void getPlant_plantDoesNotExist_throwsPlantNotFoundException() {
        // GIVEN
        PlantType testType = PlantType.HERBS;
        String testName = "test plant";

        when(mapper.load(Plant.class, testType, testName)).thenReturn(null);

        // WHEN & THEN
        PlantNotFoundException thrown = assertThrows(
                PlantNotFoundException.class,
                () -> plantDao.getPlant(testType, testName),
                "Expected getPlant to throw a PlantNotFoundException"
        );

        assertEquals("Could not find plant with name: " + testName, thrown.getMessage());
    }


}
