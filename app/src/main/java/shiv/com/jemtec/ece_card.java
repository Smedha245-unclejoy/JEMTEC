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
public class ece_card extends Activity {
    public static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ece_card);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList2);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData2.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData2.nameArray[i],
                    MyData2.emailArray[i],
                    MyData2.id_[i],
                    MyData2.titleArray[i],
                    MyData2.surnameArray[i]
            ));
        }


        adapter = new ContactAdapter(data);
        recList.setAdapter(adapter);
    }
}
