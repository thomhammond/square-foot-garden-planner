package com.squarefootgardenplanner.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.squarefootgardenplanner.service.dao.PlantDao;
import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.models.Plant;
import com.squarefootgardenplanner.service.models.requests.GetPlantRequest;
import com.squarefootgardenplanner.service.models.results.GetPlantResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetPlantActivity implements RequestHandler<GetPlantRequest, GetPlantResponse> {
    private final Logger log = LogManager.getLogger();
    private final PlantDao plantDao;

    // TODO: Add JavaDocs
    @Inject
    public GetPlantActivity(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    // TODO: Add JavaDocs
    @Override
    public GetPlantResponse handleRequest(final GetPlantRequest request, Context context) {
        log.info("Received GetPlantRequest {}", request);

        PlantType type = request.getType();
        String name = request.getName();

        Plant plant = plantDao.getPlant(type, name);

        return GetPlantResponse.builder()
                .withPlant(plant)
                .build();
    }
}
