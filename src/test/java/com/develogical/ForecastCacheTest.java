package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ForecastCacheTest {

    @Test
    public void GetForecastFromDelegate() {

        ForecastInterface delegate = mock(ForecastInterface.class);
        given(delegate.forecastFor(Region.LONDON,Day.MONDAY)).willReturn(new Forecast("cold", 18));
        ForecastCache underTest = new ForecastCache(delegate);
        Forecast fc = underTest.forecastFor(Region.LONDON, Day.MONDAY);

        assertThat(fc.summary(), equalTo("cold"));
        assertThat(fc.temperature(), equalTo(18));
    }

    @Test
    public void GetForecastFromCacheIfSeenBefore() {

        ForecastInterface delegate = mock(ForecastInterface.class);
        given(delegate.forecastFor(Region.LONDON,Day.MONDAY)).willReturn(new Forecast("cold", 18));
        ForecastCache underTest = new ForecastCache(delegate);
        underTest.forecastFor(Region.LONDON, Day.MONDAY);
        Forecast fc = underTest.forecastFor(Region.LONDON, Day.MONDAY);

        assertThat(fc.summary(), equalTo("cold"));
        assertThat(fc.temperature(), equalTo(18));

        verify(delegate, times(1)).forecastFor(Region.LONDON,Day.MONDAY);
    }
}
