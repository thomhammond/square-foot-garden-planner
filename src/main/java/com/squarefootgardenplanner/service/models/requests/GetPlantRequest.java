package com.squarefootgardenplanner.service.models.requests;

import com.squarefootgardenplanner.service.enums.PlantType;

public class GetPlantRequest {
    private PlantType type;
    private String name;

    public GetPlantRequest(){}

    public GetPlantRequest(PlantType type, String name) {
        this.type = type;
        this.name = name;
    }

    public GetPlantRequest(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private PlantType type;
        private String name;

        private Builder() {}

        public Builder withType(PlantType type) {
            this.type = type;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public GetPlantRequest build() {
            return new GetPlantRequest(this);
        }
    }
}
