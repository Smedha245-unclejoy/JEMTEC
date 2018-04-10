package shiv.com.jemtec;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter10 extends RecyclerView.Adapter<ContactAdapter10.MyViewHolder10>{
    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder10 extends RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView textViewName;
        TextView textViewemail;
        TextView textViewsurname;

        public MyViewHolder10(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.txtName10);
            this.textViewtitle = (TextView) itemView.findViewById(R.id.title10);
            this.textViewemail=(TextView) itemView.findViewById(R.id.txtEmail10);
            this.textViewsurname=(TextView) itemView.findViewById(R.id.txtSurname10);

        }
    }

    public ContactAdapter10(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder10 onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sci_hu_card_part, parent, false);
        MyViewHolder10 myViewHolder = new MyViewHolder10(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder10 holder, int listposition) {
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
