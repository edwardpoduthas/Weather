package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

public class ForecastCache implements ForecastInterface {

    private ForecastInterface delegate;
    private Map<String, Forecast>cache = new HashMap<>();

    public ForecastCache(ForecastInterface delegate) {

        this.delegate = delegate;
    }

    @Override
    public Forecast forecastFor(Region region, Day day){
        String key = region.name() + day.name();
        if (!cache.containsKey(key)) {
            cache.put(key, delegate.forecastFor(region, day));
        }
        return cache.get(key);
    }
}
