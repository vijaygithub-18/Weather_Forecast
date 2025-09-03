import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class WeatherFetcher {

    // Your OpenWeatherMap API Key (replace with your own)
    private static final String API_KEY = "5ff18d0d44b569f3b8214a7668939369";

    public static JSONObject getWeatherData(String cityName) throws Exception {
        // Build the API URL with the city name and API key
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName 
                            + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(urlString);

        // Open a connection to the API
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // If the response code is 200 (HTTP OK), process the data
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Convert the response to a JSON object
            return new JSONObject(response.toString());
        } else {
            throw new Exception("Failed to fetch weather data. HTTP Response code: " + responseCode);
        }
    }
}
