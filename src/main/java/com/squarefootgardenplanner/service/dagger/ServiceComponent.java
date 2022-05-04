package com.squarefootgardenplanner.service.dagger;

import com.squarefootgardenplanner.service.activity.GetPlantActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetPlantActivity provideGetPlantActivity();
}
