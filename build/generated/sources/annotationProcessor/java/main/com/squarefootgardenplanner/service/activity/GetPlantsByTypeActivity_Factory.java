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
public final class GetPlantsByTypeActivity_Factory implements Factory<GetPlantsByTypeActivity> {
  private final Provider<PlantDao> plantDaoProvider;

  public GetPlantsByTypeActivity_Factory(Provider<PlantDao> plantDaoProvider) {
    this.plantDaoProvider = plantDaoProvider;
  }

  @Override
  public GetPlantsByTypeActivity get() {
    return newInstance(plantDaoProvider.get());
  }

  public static GetPlantsByTypeActivity_Factory create(Provider<PlantDao> plantDaoProvider) {
    return new GetPlantsByTypeActivity_Factory(plantDaoProvider);
  }

  public static GetPlantsByTypeActivity newInstance(PlantDao plantDao) {
    return new GetPlantsByTypeActivity(plantDao);
  }
}
