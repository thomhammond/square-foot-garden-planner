package com.squarefootgardenplanner.service.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.squarefootgardenplanner.service.dao.PlantDao;
import com.squarefootgardenplanner.service.helpers.PlantTestHelper;
import com.squarefootgardenplanner.service.models.dynamodb.Plant;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.exceptions.PlantNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.stubbing.defaultanswers.ForwardsInvocations;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class PlantDaoTest {
    private ArgumentCaptor<DynamoDBQueryExpression<Plant>> argumentCaptor;

    @Mock
    private DynamoDBMapper dynamoDBMapper;

    @Mock
    private PaginatedQueryList<Plant> paginatedQueryList;

    @InjectMocks
    private PlantDao plantDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);

        argumentCaptor = ArgumentCaptor.forClass(DynamoDBQueryExpression.class);
        when(dynamoDBMapper.query(eq(Plant.class), argumentCaptor.capture())).thenReturn(paginatedQueryList);
    }

    @Test
    public void getPlant_plantExists_returnsPlant() {
        // GIVEN
        Plant testPlant = PlantTestHelper.generatePlant();

        PlantType testType = testPlant.getType();
        String testName = testPlant.getName();

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
    public void getPlantsByType_existingPlantType_returnsPlantList() {
        // GIVEN
        PlantType testType = PlantType.VEGETABLES;

        // WHEN
        List<Plant> plantList = plantDao.getPlantsByType(testType);

        // THEN
        DynamoDBQueryExpression<Plant> dynamoDBQueryExpression = argumentCaptor.getValue();
        assertEquals(testType, dynamoDBQueryExpression.getHashKeyValues().getType());
        assertEquals(paginatedQueryList, plantList);
    }

    @Test
    public void getPlantsByType_plantTypeDoesNotExist_throwsPlantTypeNotFoundException() {

    }
    // TODO: Add getPlantsByType multiple plants Happy Case test
    // TODO: Add getPlantsByType Sad Case
}
