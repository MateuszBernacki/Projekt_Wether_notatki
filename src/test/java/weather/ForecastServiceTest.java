package weather;

import org.junit.Test;
public class ForecastServiceTest  {
    @Test
    public void test(){
        ILocationRepositoryMock iLocationRepositoryMock = new ILocationRepositoryMock();
        ForecastService forecastService = new ForecastService(iLocationRepositoryMock);
        Forecast forecast = forecastService.getForecastWeat(1L,1);
        System.out.println(forecast);
    }
}