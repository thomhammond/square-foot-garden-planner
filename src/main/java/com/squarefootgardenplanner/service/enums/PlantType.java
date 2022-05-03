package com.squarefootgardenplanner.service.enums;

public enum PlantType {
    VEGETABLES,
    HERBS,
    FLOWERS;

    private static final PlantType[] plantTypes = values();

    /**
     * Validates a given string is a valid plant type.
     * First removes any leading or trailing whitespace from the string.
     *
     * @param name - plant type to check
     * @return - is the given string a valid plant type?
     */
    public static boolean isValidPlantType(String name) {
        for (PlantType type : plantTypes) {
            if (type.name().equals(name.strip().toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
