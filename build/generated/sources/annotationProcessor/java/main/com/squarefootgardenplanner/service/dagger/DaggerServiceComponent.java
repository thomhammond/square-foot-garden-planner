package com.squarefootgardenplanner.service.dagger;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.squarefootgardenplanner.service.activity.GetPlantActivity;
import com.squarefootgardenplanner.service.dao.PlantDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
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
public final class DaggerServiceComponent implements ServiceComponent {
  private final DaggerServiceComponent serviceComponent = this;

  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerServiceComponent(DaoModule daoModuleParam) {

    initialize(daoModuleParam);

  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  private PlantDao plantDao() {
    return new PlantDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final DaoModule daoModuleParam) {
    this.provideDynamoDBMapperProvider = DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(daoModuleParam));
  }

  @Override
  public GetPlantActivity provideGetPlantActivity() {
    return new GetPlantActivity(plantDao());
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new DaggerServiceComponent(daoModule);
    }
  }
}
