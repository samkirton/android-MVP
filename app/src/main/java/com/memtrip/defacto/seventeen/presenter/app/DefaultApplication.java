package com.memtrip.defacto.seventeen.presenter.app;

import android.app.Application;

import com.memtrip.defacto.seventeen.presenter.app.weather.DaggerWeatherComponent;
import com.memtrip.defacto.seventeen.repository.RepositoryModule;
import com.memtrip.defacto.seventeen.system.SystemModule;

import static com.memtrip.defacto.seventeen.presenter.app.weather.WeatherComponent.WEATHER_COMPONENT;

public class DefaultApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public Object getSystemService(String name) {
        if (name.equals(WEATHER_COMPONENT)) {
            return DaggerWeatherComponent.builder()
                    .systemModule(new SystemModule(this))
                    .repositoryModule(new RepositoryModule())
                    .build();
        } else {
            return super.getSystemService(name);
        }
    }
}
