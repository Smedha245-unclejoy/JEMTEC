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
public class civil_card extends Activity{
    public static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civil_card);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList4);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData4.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData4.nameArray[i],
                    MyData4.emailArray[i],
                    MyData4.id_[i],
                    MyData4.titleArray[i],
                    MyData4.surnameArray[i]
            ));
        }


        adapter = new ContactAdapter4(data);
        recList.setAdapter(adapter);
    }
}
