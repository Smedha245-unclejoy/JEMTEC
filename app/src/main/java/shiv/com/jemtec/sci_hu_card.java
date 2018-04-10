package shiv.com.jemtec;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by medha singh on 4/11/2016.
 */
public class sci_hu_card extends Activity {
    private static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sci_hu_card);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList10);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData6.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData6.nameArray[i],
                    MyData6.emailArray[i],
                    MyData6.id_[i],
                    MyData6.titleArray[i],
                    MyData6.surnameArray[i]
            ));
        }


        adapter = new ContactAdapter10(data);
        recList.setAdapter(adapter);
    }
}
