package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PutYourTestCodeInThisDirectoryTest {
    @Test
    public void placeholder() throws Exception {
        assertThat(2, equalTo(2));
    }

    @Test
    public void CachesForecastData () {
        ForecastCache mockForecastCache = mock(ForecastCache.class);
        Forecast fc = mockForecastCache.forecastFor(Region.LONDON, Day.MONDAY);
        verify(mockForecastCache).CacheData(fc, Region.LONDON, Day.MONDAY);
    }
}
