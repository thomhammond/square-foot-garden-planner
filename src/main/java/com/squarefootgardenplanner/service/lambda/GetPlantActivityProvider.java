package com.squarefootgardenplanner.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.squarefootgardenplanner.service.dagger.DaggerServiceComponent;
import com.squarefootgardenplanner.service.dagger.ServiceComponent;
import com.squarefootgardenplanner.service.models.requests.GetPlantRequest;
import com.squarefootgardenplanner.service.models.results.GetPlantResponse;

public class GetPlantActivityProvider implements RequestHandler<GetPlantRequest, GetPlantResponse> {

    public GetPlantActivityProvider() {}

    @Override
    public GetPlantResponse handleRequest(final GetPlantRequest request, Context context) {
        return getServiceComponent().provideGetPlantActivity().handleRequest(request, context);
    }

    private ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
