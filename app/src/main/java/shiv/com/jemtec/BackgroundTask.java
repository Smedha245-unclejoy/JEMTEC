package shiv.com.jemtec;

/**
 * Created by SHIVAM on 2/14/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by SHIVAM on 2/8/2016.
 */
public class BackgroundTask extends AsyncTask<Void,Jims,Void> {
    Context ctx;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Jims> arrayList=new ArrayList<>();
    public BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
        activity=(Activity)ctx;
    }
    String json_string="http://jemtec.esy.es/jemtec.php";
    @Override
    protected void onPreExecute() {
        recyclerView=(RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected Void doInBackground(Void... params) {

        try{
            URL url=new URL(json_string);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            String line;
            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line+"\n");
            }
            httpURLConnection.disconnect();
            String json_string=stringBuilder.toString().trim();
            JSONObject jsonObject= new JSONObject(json_string);
            JSONArray jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;
            while (count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                count++;
                Jims jims =new Jims(JO.getInt("sno"),JO.getString("notice"),JO.getString("date"));
                publishProgress(jims);
            }
            Log.d("JSON STRING",json_string);
        }
        catch (MalformedURLException e){
            Log.d("shivam",e.toString());
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
            Log.d("shivam2", e.toString());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            Log.d("shivam3", e.toString());
        }
        catch (Exception e){
            Log.d("shivam4", e.toString());
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Jims... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
