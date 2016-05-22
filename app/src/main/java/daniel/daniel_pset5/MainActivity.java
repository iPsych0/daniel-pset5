package daniel.daniel_pset5;

/* Student name: Daniel Oliemans
 * Student number: 11188669
 * Universiteit van Amsterdam
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

/*
 * Main screen for user input
 */
public class MainActivity extends AppCompatActivity {

    EditText inputBox;
    ListView dataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);

        // Initializing the EditText and ListView
        inputBox = (EditText) findViewById(R.id.inputBox);
        dataListView = (ListView) findViewById(R.id.dataListView);
    }

    // Executes this when the "Search" button is pressed
    public void getData(View view){

        // Date is the entered date for the query string parameter
        String date = inputBox.getText().toString();

        // Retrieves data from AsyncTask
        TagAsyncTask asyncTask = new TagAsyncTask(this);
        asyncTask.execute(date);
        inputBox.setText("");
        }

    // Loads in the data from AsyncTask
    public void setData(ArrayList<Data> data){
        // Loads in data from Data.java and uses this to write in the listview
        DataAdapter adapter = new DataAdapter(this, data);
        dataListView.setAdapter(adapter);
    }
}
