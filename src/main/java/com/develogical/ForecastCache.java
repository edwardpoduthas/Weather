package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.HashMap;
import java.util.Map;

public class ForecastCache implements ForecastInterface {

    private static HashMap<Region, Map<Day, Forecast>> CashedForecast = new HashMap();
    private ForecastInterface delegate;

    public ForecastCache(ForecastInterface delegate) {

        this.delegate = delegate;
    }

    @Override
    public Forecast forecastFor(Region region, Day day){
         return delegate.forecastFor(region, day);
    }

    public void CacheData(Forecast fc, Region region, Day day){

    }
}
