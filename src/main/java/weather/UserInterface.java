package weather;

import java.util.Scanner;

public class UserInterface {

    public UserInterface(LocationController locationController) {

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
}
