package com.squarefootgardenplanner.service.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlantTypeTest {
    @Test
    public void isValidPlantType_validPlantType_returnsTrue() {
        // GIVEN
        String testType = "Vegetables ";

        // WHEN
        boolean result = PlantType.isValidPlantType(testType);

        // THEN
        assertTrue(result, "Vegetables is a valid plant type.");
    }

    @Test
    public void isValidPlantType_invalidPlantType_returnsFalse() {
        // GIVEN
        String testType = "Tacos";

        // WHEN
        boolean result = PlantType.isValidPlantType(testType);

        // THEN
        assertFalse(result, "Tacos is not a valid plant type");
    }
}
