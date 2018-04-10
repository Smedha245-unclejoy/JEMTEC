package shiv.com.jemtec;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    String[] result_menu;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Gallery mainActivity, String[] prgmNameList, int[] prgmImages) {

        result_menu = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result_menu.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.gallery_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result_menu[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent myintent=new Intent(context.getApplicationContext(),WelcomeFreshers.class);
                    context.startActivity(myintent);
                }
                if (position == 1) {
                    Intent myintent=new Intent(context.getApplicationContext(),zest.class);
                    context.startActivity(myintent);
                }
                if (position == 2) {
                    Intent myintent=new Intent(context.getApplicationContext(),nss.class);
                    context.startActivity(myintent);
                }
                if (position == 3) {
                    Intent myintent=new Intent(context.getApplicationContext(),Ballb.class);
                    context.startActivity(myintent);
                }
                if (position == 4) {
                    Intent myintent=new Intent(context.getApplicationContext(),celebrations.class);
                    context.startActivity(myintent);
                }
                if (position == 5) {
                    Intent myintent=new Intent(context.getApplicationContext(),blood_bnk.class);
                    context.startActivity(myintent);
                }
                if (position == 6) {
                    Intent myintent=new Intent(context.getApplicationContext(),certi.class);
                    context.startActivity(myintent);
                }
            }
        });

        return rowView;
    }

}
