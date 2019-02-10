package com.MGH.quraan.Plus;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.MGH.quraan.PlayerActivity;
import com.MGH.quraan.R;

import java.util.ArrayList;



public class ListAdapterr extends BaseAdapter
{

    private ArrayList<Data> arraylist;
    Context context;


    public ListAdapterr(ArrayList<Data> arraylist, Context context) {
        this.arraylist = arraylist;
        this.context = context;
    }

    public int getCount()
    {
        return arraylist.size();
    }

    public Data getItem(int paramInt)
    {
        return arraylist.get(paramInt);
    }

    public long getItemId(int paramInt)
    {

        return paramInt;
    }

    Intent paramAnonymousView;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Data Datalist  = arraylist.get(position);
        if (convertView == null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
        }


        TextView localTextView = convertView.findViewById(R.id.titleid);

        localTextView.setText(Datalist.getName());
        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                paramAnonymousView = new Intent(context, PlayerActivity.class);
                paramAnonymousView.putExtra("name", (Datalist.getName()));
                paramAnonymousView.putExtra("url", (Datalist.getLink()));
                paramAnonymousView.putExtra("urlPdf", (Datalist.getLinkPdf()));
                context.startActivity(paramAnonymousView);
            }
        });

        return convertView;

    }


}


