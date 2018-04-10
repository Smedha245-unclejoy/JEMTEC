package shiv.com.jemtec;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewActivity9 extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_9);
        String[] adm_list3 = getResources().getStringArray(R.array.cut_off_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewActivity9.this,R.layout.list_item_adm3,R.id.label3,adm_list3);
        ListView lv3 = (ListView) findViewById(R.id.ListView3);
        lv3.setAdapter(adapter);
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent0 = new Intent(getApplicationContext(), NewActivity10.class);
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 1) {
                    Intent myIntent1 = new Intent(getApplicationContext(), NewActivity11.class);
                    startActivityForResult(myIntent1, 0);
                }
                if (position == 2) {
                    Intent myIntent2 = new Intent(getApplicationContext(), NewActivity12.class);
                    startActivityForResult(myIntent2, 0);
                }
                if (position == 3) {
                    Intent myIntent3 = new Intent(getApplicationContext(), NewActivity13.class);
                    startActivityForResult(myIntent3, 0);
                }

            }
        });
    }
}
