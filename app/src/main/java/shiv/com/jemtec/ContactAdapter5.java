package shiv.com.jemtec;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by medha singh on 4/11/2016.
 */
public class ContactAdapter5 extends RecyclerView.Adapter<ContactAdapter5.MyViewHolder5>{
    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder5 extends RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView textViewName;
        TextView textViewemail;
        TextView textViewsurname;

        public MyViewHolder5(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.txtName5);
            this.textViewtitle = (TextView) itemView.findViewById(R.id.title5);
            this.textViewemail=(TextView) itemView.findViewById(R.id.txtEmail5);
            this.textViewsurname=(TextView) itemView.findViewById(R.id.txtSurname5);

        }
    }

    public ContactAdapter5(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder5 onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mech_card_part, parent, false);
        MyViewHolder5 myViewHolder = new MyViewHolder5(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder5 holder, int listposition) {
        TextView textViewName = holder.textViewName;
        TextView textViewemail = holder.textViewemail;
        TextView textViewsurname=holder.textViewsurname;
        TextView textViewtitle=holder.textViewtitle;


        textViewName.setText(dataSet.get(listposition).getName());
        textViewemail.setText(dataSet.get(listposition).getEmail());
        textViewsurname.setText(dataSet.get(listposition).getSurname());
        textViewtitle.setText(dataSet.get(listposition).getTitle());



    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
