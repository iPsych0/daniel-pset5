package daniel.daniel_pset5;

/* Student name: Daniel Oliemans
 * Student number: 11188669
 * Universiteit van Amsterdam
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/*
 * Custom adapter to read over the ArrayList
 */
public class DataAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Data> datalist;

    // Constructor
    public DataAdapter(Context context, ArrayList<Data> data){
        this.context = context;
        this.datalist = data;
    }

    @Override
    public int getCount() {
        return this.datalist.size();
    }

    @Override
    public Object getItem(int arg0){
        return null;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent){
        if (view == null){
            // Inflates the rows into the ListView
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, parent, false);
        }

        // Sets the text of TextViews to the title and genre of the movie
        Data results = datalist.get(pos);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView genre = (TextView) view.findViewById(R.id.genre);
        title.setText(results.getTitle());
        genre.setText(results.getGenre());
        return view;
    }
}
