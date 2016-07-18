package ly.generalassemb.drewmahrt.cursorlab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class SimpleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> strings;
    private final Context context;

    public SimpleAdapter(Context context, ArrayList<String> strings) {
        //super();
        inflater = LayoutInflater.from(context);
        this.strings = strings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View child, ViewGroup parent) {

        View v = child;
        TextView items;

        if (v == null) {

            v = inflater.inflate(R.layout.sql_items, parent, false);
        }


        items = (TextView) v.findViewById(R.id.items);



        items.setText(String.valueOf(strings.get(position)));


        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(context.getApplicationContext(), MainActivity.class);
               context.startActivity(intent);

           }
        });

        return v;
    }
}
