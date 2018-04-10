package shiv.com.jemtec;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by medha singh on 4/11/2016.
 */
public class ContactViewHolder extends RecyclerView.ViewHolder {
    protected TextView vName;
    protected TextView vSurname;
    protected TextView vEmail;
    protected TextView vTitle;

    public ContactViewHolder(View v) {
        super(v);
        vName =  (TextView) v.findViewById(R.id.txtName);
        vSurname = (TextView)  v.findViewById(R.id.txtSurname);
        vEmail = (TextView)  v.findViewById(R.id.txtEmail);
        vTitle = (TextView) v.findViewById(R.id.title);
    }
}
