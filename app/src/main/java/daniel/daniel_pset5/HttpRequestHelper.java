package daniel.daniel_pset5;

/* Student name: Daniel Oliemans
 * Student number: 11188669
 * Universiteit van Amsterdam
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Queries the HTTP requests and parses the query string
 */
public class HttpRequestHelper {
    // Make string for url
    private static final String url1 = "http://api.filmtotaal.nl/filmsoptv.xml";
    private static final String url2 = "?apikey=j8noahkyi6fq4v1bgqrcfysgvvxaicb9";

    // Method to download from server
    protected static synchronized String downloadFromServer(String...params){
        // Declare return string result
        String result = "";

        // Chosen tag from argument
        String chosenTag = params[0];

        // Complete string url
        String fullUrl = url1 + url2 + "&dag=" + chosenTag + "&sorteer=0";

        // Turn string into url
        URL url = null;
        try {
            url = new URL(fullUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Make the connection
        HttpURLConnection connection;
        if(url != null)
            try {
                connection = (HttpURLConnection) url.openConnection();

                // Open connection, set request method
                connection.setRequestMethod("GET");

                // Get response code
                Integer responseCode = connection.getResponseCode();

                // If 200-300, read inputstream
                if (200 <=  responseCode && responseCode <= 299){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        result = result + line;
                    }
                }
                // Else read error stream
                else{
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    // Communicate error
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return result;
    }
}
