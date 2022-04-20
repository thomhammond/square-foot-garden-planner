package com.squarefootgardenplanner.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.squarefootgardenplanner.service.dynamodb.models.Plant;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.exceptions.PlantNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.internal.stubbing.defaultanswers.ForwardsInvocations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class PlantDaoTest {

    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private PlantDao plantDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        plantDao = new PlantDao(dynamoDBMapper);
    }

    @Test
    public void getPlant_plantExists_returnsPlant() {
        // GIVEN
        PlantType testType = PlantType.VEGETABLES;
        String testName = "test plant";

        Plant testPlant = new Plant();

        testPlant.setType(testType);
        testPlant.setName(testName);

        when(dynamoDBMapper.load(Plant.class, testType, testName)).thenReturn(testPlant);

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

        when(dynamoDBMapper.load(Plant.class, testType, testName)).thenReturn(null);

        // WHEN & THEN
        PlantNotFoundException thrown = assertThrows(
                PlantNotFoundException.class,
                () -> plantDao.getPlant(testType, testName),
                "Expected getPlant to throw a PlantNotFoundException"
        );

        assertEquals("Could not find plant with name: " + testName, thrown.getMessage());
    }

    @Test
    public void getPlantsByType_singlePlantOfGivenTypeExists_returnsListWithCorrectPlant() {
        // GIVEN
        PlantType testType = PlantType.VEGETABLES;
        String testName = "test plant";


        Plant testPlant = new Plant();

        List<Plant> plantList = List.of(testPlant);

        PaginatedQueryList<?> paginatedPlantList = mock(PaginatedQueryList.class,
                                                         withSettings().defaultAnswer(new ForwardsInvocations(plantList)));


        // TODO: Research how to get rid of unchecked assignment warning on <any>
        when(dynamoDBMapper.query(eq(Plant.class), any(DynamoDBQueryExpression.class))).thenReturn(paginatedPlantList);

        // WHEN
        List<Plant> resultPlantList = plantDao.getPlantsByType(testType);

        // THEN
        assertEquals(
                plantList.size(),
                resultPlantList.size(),
                String.format("Expected plantList (%s) and resultPlantList (%s) to be the be the same size", plantList, resultPlantList)
        );

        assertEquals(
                plantList.get(0),
                resultPlantList.get(0),
                "Expected the intial and resulting plant lists to contain a single equivalent plant"
        );
    }
}
