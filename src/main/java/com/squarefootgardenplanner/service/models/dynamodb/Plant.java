package com.squarefootgardenplanner.service.models.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.squarefootgardenplanner.service.converters.GrowingSeasonConverter;
import com.squarefootgardenplanner.service.enums.GrowingSeason;
import com.squarefootgardenplanner.service.enums.PlantType;

import java.util.List;
import java.util.Objects;

/**
 * Represents a record in the plants table.
 */
@DynamoDBTable(tableName = "plants")
public class Plant {
    private PlantType type;
    private String name;
    private String family;
    private String height;
    private String spacingPerSqFt;
    private List<GrowingSeason> growingSeasons;
    private int weeksFromSeedToHarvest;
    private int yearsSeedsCanBeStored;

    @DynamoDBTypeConvertedEnum
    @DynamoDBHashKey(attributeName = "type")
    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    @DynamoDBRangeKey(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "family")
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @DynamoDBAttribute(attributeName = "height")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @DynamoDBAttribute(attributeName = "spacing_per_sq_ft")
    public String getSpacingPerSqFt() {
        return spacingPerSqFt;
    }

    public void setSpacingPerSqFt(String spacingPerSqFt) {
        this.spacingPerSqFt = spacingPerSqFt;
    }

    @DynamoDBTypeConverted(converter = GrowingSeasonConverter.class)
    @DynamoDBAttribute(attributeName = "growing_seasons")
    public List<GrowingSeason> getGrowingSeasons() {
        return growingSeasons;
    }

    public void setGrowingSeasons(List<GrowingSeason> growingSeasons) {
        this.growingSeasons = growingSeasons;
    }

    @DynamoDBAttribute(attributeName = "weeks_from_seed_to_harvest")
    public int getWeeksFromSeedToHarvest() {
        return weeksFromSeedToHarvest;
    }

    public void setWeeksFromSeedToHarvest(int weeksFromSeedToHarvest) {
        this.weeksFromSeedToHarvest = weeksFromSeedToHarvest;
    }

    @DynamoDBAttribute(attributeName = "years_seeds_can_be_stored")
    public int getYearsSeedsCanBeStored() {
        return yearsSeedsCanBeStored;
    }

    public void setYearsSeedsCanBeStored(int yearsSeedsCanBeStored) {
        this.yearsSeedsCanBeStored = yearsSeedsCanBeStored;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", height='" + height + '\'' +
                ", spacingPerSqFt='" + spacingPerSqFt + '\'' +
                ", growingSeasons=" + growingSeasons +
                ", weeksFromSeedToHarvest=" + weeksFromSeedToHarvest +
                ", yearsSeedsCanBeStored=" + yearsSeedsCanBeStored +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return getWeeksFromSeedToHarvest() == plant.getWeeksFromSeedToHarvest() && getYearsSeedsCanBeStored() == plant.getYearsSeedsCanBeStored() && getType() == plant.getType() && getName().equals(plant.getName()) && Objects.equals(getFamily(), plant.getFamily()) && Objects.equals(getHeight(), plant.getHeight()) && Objects.equals(getSpacingPerSqFt(), plant.getSpacingPerSqFt()) && Objects.equals(getGrowingSeasons(), plant.getGrowingSeasons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getName(), getFamily(), getHeight(), getSpacingPerSqFt(), getGrowingSeasons(), getWeeksFromSeedToHarvest(), getYearsSeedsCanBeStored());
    }
}
