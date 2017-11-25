package saud.abdulrhman.tliesecurtiysystem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PCD on 11/16/2017.
 */

public class myAdpter extends RecyclerView.Adapter<myAdpter.ViewHolder> {


    private List<arteList> AlrteList;


    public myAdpter(List<arteList> AlrteList) {
        this.AlrteList = AlrteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.alret_list,null);
               return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        arteList alrte = AlrteList.get(position);
        holder.textViewhead.setText(alrte.getHead());
        holder.TextViewtime.setText(alrte.getTime());
    }

    @Override
    public int getItemCount() {
        return AlrteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

          public TextView textViewhead;
          public TextView TextViewtime;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewhead = (TextView)  itemView.findViewById(R.id.textViewhead);
            TextViewtime = (TextView)  itemView.findViewById(R.id.TextViewtime);

        }
    }
}
