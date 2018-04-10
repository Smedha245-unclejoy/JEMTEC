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
public class ContactAdapter8 extends RecyclerView.Adapter<ContactAdapter8.MyViewHolder8>{
    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder8 extends RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView textViewName;
        TextView textViewemail;
        TextView textViewsurname;

        public MyViewHolder8(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.txtName8);
            this.textViewtitle = (TextView) itemView.findViewById(R.id.title8);
            this.textViewemail=(TextView) itemView.findViewById(R.id.txtEmail8);
            this.textViewsurname=(TextView) itemView.findViewById(R.id.txtSurname8);

        }
    }

    public ContactAdapter8(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder8 onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bca_card_part, parent, false);
        MyViewHolder8 myViewHolder = new MyViewHolder8(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder8 holder, int listposition) {
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
