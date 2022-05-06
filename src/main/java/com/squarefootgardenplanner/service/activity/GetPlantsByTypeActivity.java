package com.squarefootgardenplanner.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.squarefootgardenplanner.service.dao.PlantDao;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.models.Plant;
import com.squarefootgardenplanner.service.models.requests.GetPlantsByTypeRequest;
import com.squarefootgardenplanner.service.models.results.GetPlantsByTypeResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetPlantsByTypeActivity implements RequestHandler<GetPlantsByTypeRequest, GetPlantsByTypeResponse> {
    private final Logger log = LogManager.getLogger();
    private final PlantDao plantDao;

    @Inject
    public GetPlantsByTypeActivity(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    @Override
    public GetPlantsByTypeResponse handleRequest(final GetPlantsByTypeRequest request, Context context) {
        log.info("Received GetPlantsByTypeRequest {}", request);

        PlantType type = request.getType();

        List<Plant> plantList = plantDao.getPlantsByType(type);

        return GetPlantsByTypeResponse.builder()
                .withPlantList(plantList)
                .build();
    }
}
