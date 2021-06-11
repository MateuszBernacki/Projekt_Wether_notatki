package weather;

import java.util.Scanner;

public class UserInterface {

    private final LocationController locationController;
    private final ForecastController forecastController;

    public UserInterface(LocationController locationController, ForecastController forecastController) {
        this.locationController = locationController;
        this.forecastController = forecastController;
    }



    public void run() {
        System.out.println("Aplikacja jest uruchomiona!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Weather, co chcesz zrobić?");
            System.out.println("3. pobierania wartości pogodowych");
            System.out.println("2. Wyświetlanie aktualnie dodanych lokalizacj");
            System.out.println("1. Dodawania konkretnych lokalizacji do bazy danych");
            System.out.println("0. Zamknąć aplikację");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewLocation();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void addNewLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select country: ");
        String country_name = scanner.nextLine();
        System.out.println("Select region: ");
        String region = scanner.nextLine();
        System.out.println("Select city: ");
        String city = scanner.nextLine();
        System.out.println("Set longitude: ");
        int longitude = scanner.nextInt();
        System.out.println("Set latitude: ");
        int latitude = scanner.nextInt();

        // todo use locationController

        System.out.println();
    }

    private void showAllLocations() {
        String httpResponse = locationController.showAllLocations();
        System.out.println("Information form the server" + httpResponse);
        System.out.println();
    }


    public void getForecast(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select city ID: ");
        Long locationId = scanner.nextLong();
        System.out.println("Select day from today up to 8 days forward: " );
        Integer date = scanner.nextInt();

        String httpResponse = forecastController.getForecast(locationId,date);
        System.out.println("Infomration from server: " + httpResponse);
        System.out.println();

    }
}
