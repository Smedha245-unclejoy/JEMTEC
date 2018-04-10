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
public class bballb_card extends Activity {
    private static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bballb_card);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList7);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData8.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData8.nameArray[i],
                    MyData8.emailArray[i],
                    MyData8.id_[i],
                    MyData8.titleArray[i],
                    MyData8.surnameArray[i]
            ));
        }


        adapter = new ContactAdapter(data);
        recList.setAdapter(adapter);
    }

}
