package ly.generalassemb.drewmahrt.cursorlab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getCanonicalName();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase db;
        ListView list;
        SimpleAdapter adapter;
        ArrayList<String> strings;
        context = this;
        db = openOrCreateDatabase(
                "BooksData.db"
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.execSQL("DROP TABLE IF EXISTS tbl_books");
        String[] titles = new String[]{"Harry Potter and the Sorcerers Stone","Harry Potter and the Chamber of Secrets","The Martian"};
        String[] authors = new String[]{"J. K. Rowling","J. K. Rowling","Andy Weir"};
        int[] years = new int[]{1997,1998,2011};
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_books (title VARCHAR, author VARCHAR, year VARCHAR);");
        for (int i=0; i<titles.length;i++) {
            db.execSQL("INSERT INTO tbl_books Values ('" + titles[i] + "', '"+ authors[i] + "', '" + years[i] +"');");
        }

        Cursor res = db.rawQuery( "select * from tbl_books", null );
        strings = new ArrayList<>();
        res.moveToFirst();
        while (!res.isAfterLast()) {
            strings.add(res.getString(0) + " - " + res.getString(1) + " - " + res.getInt(2));
            res.moveToNext();
        }
        res.close();
//        for (String item : strings) {
//            System.out.println(item);
//        }
        list = (ListView) findViewById(R.id.listView);
        adapter = new SimpleAdapter(this, strings);
        if (list != null) {
            list.setAdapter(adapter);
        }

    }
}
