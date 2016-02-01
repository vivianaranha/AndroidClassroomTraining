package com.vivianaranha.yqlapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vivianaranha on 1/24/16.
 */
public class ResultsAdapter extends ArrayAdapter{

    ArrayList<Results> results;
    Context context;

    public ResultsAdapter(Context context, ArrayList<Results> results) {
        super(context, R.layout.single_row, results);
        this.results = results;
        this.context = context;
    }

    class ResultsViewHolder{
        TextView myTitle;
        TextView myAddress;
        TextView myPhone;
        TextView myDistance;

        ResultsViewHolder(View v){
            myTitle = (TextView) v.findViewById(R.id.titleField);
            myAddress = (TextView) v.findViewById(R.id.addressField);
            myPhone = (TextView) v.findViewById(R.id.phoneField);
            myDistance = (TextView) v.findViewById(R.id.distanceField);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ResultsViewHolder holder = null;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new ResultsViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ResultsViewHolder) row.getTag();
        }
        Results result = results.get(position);
        holder.myTitle.setText(result.title);
        holder.myAddress.setText(result.address+", "+result.city+", "+result.state);
        holder.myPhone.setText("Phone: "+result.phone);
        holder.myDistance.setText("Distance: "+result.disance+" miles");

        return row;
    }
}
