import java.util.Scanner;
import org.json.JSONObject;

public class WeatherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather Forecast Application");

        // Start a loop to keep the application running
        while (true) {
            System.out.print("Enter the city name (or type 'exit' to quit): ");
            String cityName = scanner.nextLine();

            // Check if the user wants to exit
            if (cityName.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }

            try {
                // Fetch weather data
                JSONObject weatherData = WeatherFetcher.getWeatherData(cityName);

                // Display the weather data
                WeatherDisplay.displayWeather(weatherData);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
