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
public class ContactAdapter9 extends RecyclerView.Adapter<ContactAdapter9.MyViewHolder9>{
    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder9 extends RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView textViewName;
        TextView textViewemail;
        TextView textViewsurname;

        public MyViewHolder9(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.txtName9);
            this.textViewtitle = (TextView) itemView.findViewById(R.id.title9);
            this.textViewemail=(TextView) itemView.findViewById(R.id.txtEmail9);
            this.textViewsurname=(TextView) itemView.findViewById(R.id.txtSurname9);

        }
    }

    public ContactAdapter9(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder9 onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bed_card_part, parent, false);
        MyViewHolder9 myViewHolder = new MyViewHolder9(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder9 holder, int listposition) {
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
