package com.squarefootgardenplanner.service.dagger;

import com.squarefootgardenplanner.service.activity.GetPlantActivity;
import com.squarefootgardenplanner.service.activity.GetPlantsByTypeActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetPlantActivity provideGetPlantActivity();
    GetPlantsByTypeActivity provideGetPlantsByTypeActivity();
}
