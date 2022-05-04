package com.squarefootgardenplanner.service.models.results;

import com.squarefootgardenplanner.service.models.Plant;

public class GetPlantResponse {
    private Plant plant;

    public GetPlantResponse (Builder builder) {
        this.plant = builder.plant;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Plant plant;

        public Builder withPlant(Plant plant) {
            this.plant = plant;
            return this;
        }

        public GetPlantResponse build() {
            return new GetPlantResponse(this);
        }
    }


}
