package shiv.com.jemtec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class NewActivity0 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_0);
        String[] adm_list2 = getResources().getStringArray(R.array.adm_list2);

        // Binding resources Array to ListAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewActivity0.this, R.layout.list_item_adm2, R.id.label2, adm_list2);
        ListView lv2 = (ListView) findViewById(R.id.ListView2);
        lv2.setAdapter(adapter);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent0 = new Intent(getApplicationContext(), NewActivity5.class);
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 1) {
                    Intent myIntent1 = new Intent(getApplicationContext(), NewActivity6.class);
                    startActivityForResult(myIntent1, 0);
                }
                if (position == 2) {
                    Intent myIntent2 = new Intent(getApplicationContext(), NewActivity7.class);
                    startActivityForResult(myIntent2, 0);
                }
                if (position == 3) {
                    Intent myIntent3 = new Intent(getApplicationContext(), NewActivity8.class);
                    startActivityForResult(myIntent3, 0);
                }

            }
        });
    }
    }

