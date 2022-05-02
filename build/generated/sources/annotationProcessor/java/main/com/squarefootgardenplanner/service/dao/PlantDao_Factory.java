package com.squarefootgardenplanner.service.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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
public final class PlantDao_Factory implements Factory<PlantDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public PlantDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public PlantDao get() {
    return newInstance(dynamoDBMapperProvider.get());
  }

  public static PlantDao_Factory create(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new PlantDao_Factory(dynamoDBMapperProvider);
  }

  public static PlantDao newInstance(DynamoDBMapper dynamoDBMapper) {
    return new PlantDao(dynamoDBMapper);
  }
}
