package shiv.com.jemtec;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewActivity12 extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_12);
        String[] bca_list = getResources().getStringArray(R.array.bca_list);

        // Binding resources Array to ListAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewActivity12.this, R.layout.list_item_adm5, R.id.label5, bca_list);
        ListView lv5 = (ListView) findViewById(R.id.ListView5);
        lv5.setAdapter(adapter);
        lv5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent0 = new Intent(getApplicationContext(), bca_adm.class);
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 1) {
                    Intent myIntent1 = new Intent(getApplicationContext(), bca_adm2.class);
                    startActivityForResult(myIntent1, 0);
                }

            }
        });

    }
    }
