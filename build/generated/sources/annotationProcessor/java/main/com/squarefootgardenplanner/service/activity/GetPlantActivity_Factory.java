package com.squarefootgardenplanner.service.activity;

import com.squarefootgardenplanner.service.dao.PlantDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetPlantActivity_Factory implements Factory<GetPlantActivity> {
  private final Provider<PlantDao> plantDaoProvider;

  public GetPlantActivity_Factory(Provider<PlantDao> plantDaoProvider) {
    this.plantDaoProvider = plantDaoProvider;
  }

  @Override
  public GetPlantActivity get() {
    return newInstance(plantDaoProvider.get());
  }

  public static GetPlantActivity_Factory create(Provider<PlantDao> plantDaoProvider) {
    return new GetPlantActivity_Factory(plantDaoProvider);
  }

  public static GetPlantActivity newInstance(PlantDao plantDao) {
    return new GetPlantActivity(plantDao);
  }
}
