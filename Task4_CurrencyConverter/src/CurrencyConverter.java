import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter 
{
    public static double getExchangeRate(String baseCurrency, String targetCurrency) 
    {
        try 
        {
            String apiURL = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) 
            {
                response.append(inputLine);
            }
            in.close();

            JSONObject data = new JSONObject(response.toString());
            JSONObject rates = data.getJSONObject("rates");

            return rates.getDouble(targetCurrency);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ CURRENCY CONVERTER ------");

        System.out.print("Enter base currency (e.g. USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g. INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double rate = getExchangeRate(baseCurrency, targetCurrency);

        if (rate != -1) 
        {
            double convertedAmount = amount * rate;
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        } 
        else 
        {
            System.out.println("Failed to fetch exchange rate.");
        }

        scanner.close();
    }
}
