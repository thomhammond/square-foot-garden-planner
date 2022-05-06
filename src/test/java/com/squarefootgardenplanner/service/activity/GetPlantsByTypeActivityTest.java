package com.squarefootgardenplanner.service.activity;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.lambda.runtime.Context;
import com.squarefootgardenplanner.service.dao.PlantDao;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.helpers.PlantTestHelper;
import com.squarefootgardenplanner.service.models.Plant;
import com.squarefootgardenplanner.service.models.requests.GetPlantsByTypeRequest;
import com.squarefootgardenplanner.service.models.results.GetPlantsByTypeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetPlantsByTypeActivityTest {

    @Mock
    Context context;

    @Mock
    PlantDao plantDao;

    @InjectMocks
    GetPlantsByTypeActivity getPlantsByTypeActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void handleRequest_validType_returnsPlantListInResponse() {
        // GIVEN
        Plant testPlant = PlantTestHelper.generatePlant();
        PlantType testType = testPlant.getType();

        List<Plant> plantList = PlantTestHelper.generateSingletonPlantList();

        GetPlantsByTypeRequest request = GetPlantsByTypeRequest.builder()
                .withType(testType)
                .build();

        when(plantDao.getPlantsByType(any(PlantType.class))).thenReturn(plantList);

        // WHEN
        GetPlantsByTypeResponse response = getPlantsByTypeActivity.handleRequest(request, context);

        // THEN
        // TODO: Add messages
        assertEquals(plantList, response.getPlantList());
    }
}
