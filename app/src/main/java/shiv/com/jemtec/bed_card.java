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
public class bed_card extends Activity {
    private static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bed_card);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList9);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData10.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData10.nameArray[i],
                    MyData10.emailArray[i],
                    MyData10.id_[i],
                    MyData10.titleArray[i],
                    MyData10.surnameArray[i]
            ));
        }


        adapter = new ContactAdapter9(data);
        recList.setAdapter(adapter);
    }
}
