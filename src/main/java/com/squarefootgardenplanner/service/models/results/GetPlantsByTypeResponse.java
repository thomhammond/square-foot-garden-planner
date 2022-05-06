package com.squarefootgardenplanner.service.models.results;

import com.squarefootgardenplanner.service.models.Plant;

import java.util.List;

public class GetPlantsByTypeResponse {
    private List<Plant> plantList;

    public GetPlantsByTypeResponse(Builder builder) {
        this.plantList = builder.plantList;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private List<Plant> plantList;

        public Builder withPlantList(List<Plant> plantList) {
            this.plantList = plantList;
            return this;
        }

        public GetPlantsByTypeResponse build() {
            return new GetPlantsByTypeResponse(this);
        }
    }
}
