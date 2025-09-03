import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherDisplay {

    public static void displayWeather(JSONObject weatherData) {
        try {
            // Extract main weather data
            JSONObject main = weatherData.getJSONObject("main");
            double temp = main.getDouble("temp") - 273.15; // Convert from Kelvin to Celsius
            int humidity = main.getInt("humidity");

            // Extract weather condition
            JSONArray weather = weatherData.getJSONArray("weather");
            String description = weather.getJSONObject(0).getString("description");

            // Display the weather data
            System.out.printf("Temperature: %.2f°C\n", temp);
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Condition: " + description);

        } catch (Exception e) {
            System.err.println("Error while processing weather data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example of using the displayWeather method
        String jsonResponse = "{"
            + "\"main\": {\"temp\": 295.15, \"humidity\": 80},"
            + "\"weather\": [{\"description\": \"clear sky\"}]"
            + "}";
        
        JSONObject weatherData = new JSONObject(jsonResponse);
        displayWeather(weatherData);
    }
}
