package weather;

import org.junit.Test;
public class ForecastServiceTest  {

    LocationService locationService;
    ForecastService forecastService;
    @Test
    public void test(){
        ILocationRepositoryMock iLocationRepositoryMock = new ILocationRepositoryMock();
        Location location = new Location(null, "Malopolska", "Poland", "Krakow", 45.2, 12.1 );
        iLocationRepositoryMock.save(location);

        ForecastService forecastService = new ForecastService();
        Forecast forecast = forecastService.getForecastWeat(1L,1);
        System.out.println(forecast);
    }


}