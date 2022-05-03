package com.squarefootgardenplanner.service.helpers;

import com.squarefootgardenplanner.service.enums.PlantType;
import com.squarefootgardenplanner.service.models.Plant;

import java.util.ArrayList;
import java.util.List;

public class PlantTestHelper {
    /**
     * Generates a single plant with generic partition and sort keys.
     * @return the generated plant object
     */
    public static Plant generatePlant() {
        Plant plant = new Plant();
        plant.setType(PlantType.VEGETABLES);
        plant.setName("test plant");

        return plant;
    }

    public static List<Plant> generateSingletonPlantList() {
        return List.of(generatePlant());
    }

    public static List<Plant> generatePlantListWithEachPlantType() {
        List<PlantType> plantTypes = List.of(PlantType.VEGETABLES,
                                             PlantType.HERBS,
                                             PlantType.FLOWERS);
        List<Plant> plantList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Plant plant = new Plant();
            plant.setType(plantTypes.get(i));
            plant.setName("test plant " + i);
            plantList.add(plant);
        }

        return plantList;
    }

}
