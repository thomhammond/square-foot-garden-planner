package com.squarefootgardenplanner.service.models.requests;

import com.squarefootgardenplanner.service.enums.PlantType;

public class GetPlantsByTypeRequest {
    private PlantType type;

    public GetPlantsByTypeRequest() {}

    public GetPlantsByTypeRequest(Builder builder) {
        this.type = builder.type;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private PlantType type;

        private Builder() {}

        public Builder withType(PlantType type) {
            this.type = type;
            return this;
        }

        public GetPlantsByTypeRequest build() {
            return new GetPlantsByTypeRequest(this);
        }
    }


}
