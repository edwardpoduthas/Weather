package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

public class ForecastCache implements ForecastInterface {

    private ForecastInterface delegate;
    private Forecast previousForecast;

    public ForecastCache(ForecastInterface delegate) {

        this.delegate = delegate;
    }

    @Override
    public Forecast forecastFor(Region region, Day day){
        if (previousForecast == null) {
            previousForecast = delegate.forecastFor(region, day);
        }
        return previousForecast;
    }
}
