package shiv.com.jemtec;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class cse4 extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse_list_view);
        String[] cse_list = getResources().getStringArray(R.array.cse);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, R.layout.list_item_cse, R.id.label,cse_list );
        ListView lv = (ListView)findViewById(R.id.ListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    Intent myIntent0 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/0BzaRGu22V1EkRFNyZ2NfbWZWRjQ/view?usp=docslist_api"));
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 1) {

                    Intent myIntent0 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/file/d/0BzaRGu22V1EkZmNvbFdfQnFxTWc/view?usp=docslist_api"));
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 2) {

                    Intent myIntent0 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/file/d/0BzaRGu22V1EkV0VCLVdiVl9EdVE/view?usp=docslist_api"));
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 3) {

                    Intent myIntent0 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/file/d/0BzaRGu22V1Ekd1NKcWlrT3BSdnM/view?usp=docslist_api"));
                    startActivityForResult(myIntent0, 0);
                }
                if (position == 4) {

                    Intent myIntent0 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/file/d/0BzaRGu22V1EkZ2tmTnFEci1mcW8/view?usp=docslist_api"));
                    startActivityForResult(myIntent0, 0);
                }

            }
        });
    }
}
