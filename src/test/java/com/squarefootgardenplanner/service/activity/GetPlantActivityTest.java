package com.squarefootgardenplanner.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.squarefootgardenplanner.service.dao.PlantDao;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.helpers.PlantTestHelper;
import com.squarefootgardenplanner.service.models.Plant;
import com.squarefootgardenplanner.service.models.requests.GetPlantRequest;
import com.squarefootgardenplanner.service.models.results.GetPlantResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetPlantActivityTest {

    @Mock
    Context context;

    @Mock
    private PlantDao plantDao;

    @InjectMocks
    GetPlantActivity getPlantActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void handleRequest_plantExists_returnsPlantInResponse() {
        // GIVEN
        Plant testPlant = PlantTestHelper.generatePlant();
        PlantType testType = testPlant.getType();
        String testName = testPlant.getName();

        GetPlantRequest request = GetPlantRequest.builder()
                .withType(testType)
                .withName(testName)
                .build();

        when(plantDao.getPlant(testType, testName)).thenReturn(testPlant);

        // WHEN
        GetPlantResponse response = getPlantActivity.handleRequest(request, context);

        // THEN
        assertEquals(testType, response.getPlant().getType());
        assertEquals(testName, response.getPlant().getName());
        assertEquals(testPlant, response.getPlant());
    }
}
