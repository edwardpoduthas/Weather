package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

public class ForecastCache implements ForecastInterface {

    @Override
    public Forecast forecastFor(Region region, Day day){
        return new Forecast("", 0);
    }

    public void CacheData(Forecast fc, Region region, Day day){

    }
}
