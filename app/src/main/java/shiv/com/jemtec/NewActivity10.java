package shiv.com.jemtec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class NewActivity10 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_10);
        String[] cut_list = getResources().getStringArray(R.array.cut_list);

        // Binding resources Array to ListAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewActivity10.this, R.layout.list_item_adm4, R.id.label4,cut_list);
        ListView lv4 = (ListView) findViewById(R.id.ListView4);
        lv4.setAdapter(adapter);
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent0 = new Intent(getApplicationContext(), cutoff0.class);
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 1) {
                    Intent myIntent1 = new Intent(getApplicationContext(), cutoff1.class);
                    startActivityForResult(myIntent1, 0);
                }
                if (position == 2) {
                    Intent myIntent2 = new Intent(getApplicationContext(), cutoff2.class);
                    startActivityForResult(myIntent2, 0);
                }
                if (position == 3) {
                    Intent myIntent3 = new Intent(getApplicationContext(), cutoff3.class);
                    startActivityForResult(myIntent3, 0);
                }

            }
        });

    }}
