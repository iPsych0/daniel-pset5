package daniel.daniel_pset5;

/* Student name: Daniel Oliemans
 * Student number: 11188669
 * Universiteit van Amsterdam
 */

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/*
 * Parses over the XML given from the query string result
 */
public class TagAsyncTask extends AsyncTask<String, Integer, String> {

    Context context;
    MainActivity activity;

    // Constructor
    public TagAsyncTask(MainActivity activity){
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }


    // Loading the query
    @Override
    protected void onPreExecute(){
        Toast.makeText(context, "Loading data...", Toast.LENGTH_SHORT).show();
    }

    // Parses the query
    @Override
    protected String doInBackground(String... params) {
        // Gets the data
        return HttpRequestHelper.downloadFromServer(params);
    }

    // Updates the values
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    // Retrieves the XML from the query request
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        // If no results found, toast user
        if(result.length() == 0){
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }
        // If results are found
        else{
            // Put them in an arraylist
            ArrayList<Data> data = new ArrayList<>();
            try {
                // Convert the XML to a JSONArray (not working)
                JSONArray array = new JSONArray(result);

                // For each item by tag "titel" or "genre"
                for(int i = 0; i < array.length(); i++){
                    JSONObject object = array.getJSONObject(i);
                    String title = object.getString("titel");
                    String genre = object.getString("genre");
                    // Add the title and genre to the ArrayList
                    data.add(new Data(title, genre));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // Give the ArrayList to the main activity
            this.activity.setData(data);
        }
    }
}
