package com.squarefootgardenplanner.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.squarefootgardenplanner.service.dagger.DaggerServiceComponent;
import com.squarefootgardenplanner.service.dagger.ServiceComponent;
import com.squarefootgardenplanner.service.models.requests.GetPlantsByTypeRequest;
import com.squarefootgardenplanner.service.models.results.GetPlantsByTypeResponse;

public class GetPlantsByTypeActivityProvider implements RequestHandler<GetPlantsByTypeRequest, GetPlantsByTypeResponse> {

    public GetPlantsByTypeActivityProvider() {}

    @Override
    public GetPlantsByTypeResponse handleRequest(final GetPlantsByTypeRequest request, Context context) {
        return getServiceComponent().provideGetPlantsByTypeActivity().handleRequest(request, context);
    }

    public ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }



}
